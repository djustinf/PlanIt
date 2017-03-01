var calendarDemoApp = angular.module('calendarDemoApp', ['ui.calendar', 'ui.bootstrap', 'ngAnimate', 'ngMaterial', 'ngMessages', 'material.svgAssetsCache', 'angularModalService']);

calendarDemoApp.controller('CalendarCtrl',
    function ($scope, $compile, $timeout, uiCalendarConfig, ModalService) {
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();

        var Day = {
            SUNDAY: 0,
            MONDAY: 1,
            TUESDAY: 2,
            WEDNESDAY: 3,
            THURSDAY: 4,
            FRIDAY: 5,
            SATURDAY: 6
        };

        /**
         * function to check whether or not any variable is an integer or not
         * @param possibleInt variable to test
         * @returns {boolean} typeof possibleInt === integer
         */
        function isInt(possibleInt){
            var x;
            if(isNaN(possibleInt)){
                return false;
            }
            x = parseFloat(possibleInt);

            return (x | 0) === x;
        }

        /**
         *
         * @param title name of the class
         * @param segmentedEventArr array of segmented events
         * @param uniqueCourseComponentId integer id for the course component. MUST BE UNIQUE
         *
         * each segmented event will need to contain the:
         *      startTime time that the event starts (must be between 0 (midnight) and 1439 (11:59 PM)
         *      endTime time that the event ends
         *      days arr of days of the week that that segment is occurs
         *
         * note if a class is 9-11 Tues, Thursday and 5-6 Wednesday, there should be 2 segmented events
         *      one for the Tuesday-Thursday time slot and another for the Wednesday
         */
        function createArrOfEventsForCourseComponent(title, segmentedEventArr, uniqueCourseComponentId){
            if(!title || !segmentedEventArr || !segmentedEventArr.length || !isInt(uniqueCourseComponentId)){
                console.warn("one of the variables you passed in is not valid, nothing is being created (yell at Ethan)");
                alert("error in courseComponent, nothing is being created");
                return undefined;
            }

            var courseComponentComponentArr = [];

            for(var i = 0; i < segmentedEventArr.length; i++){
                var segment = segmentedEventArr[i];

                //check to make sure that all the required fields are populated for the given segment
                if(!segment || !segment.startTime || !segment.endTime || !segment.days || segment.days.constructor !== Array){
                    console.warn("one of the segments is invalid, nothing is being created");
                    alert("error in segments, nothing created (yell at Ethan)");
                    return undefined;
                }

                //check to make sure that all of the days for the given segment are valid
                for(var j = 0; j < segment.days.length; j++){
                    var day = segment.days[j];
                    if(!isInt(day) || day < Day.SUNDAY || day > Day.SATURDAY) {
                        console.log(day)
                        console.warn("one of the days in the segment at index " + i + " is invalid, nothing is being created");
                        alert("error in segments, nothing created (yell at Ethan)");
                        return undefined;
                    }
                }

                //check to make sure that the start and end time for the given segment are valid
                if(segment.startTime < 0 || segment.endTime > 1439 || segment.startTime >= segment.endTime){
                    console.warn("in the segment at index " + i + " either the start or end time is invalid, nothing is being created");
                    alert("error in segments, nothing is being created");
                    return undefined;
                }
                if(segment.startTime + 30 > segment.endTime){
                    console.warn("valid segments must have an elapsed time of at least 30 minutes, nothing is being created");
                    alert("error in segments, nothing is being created");
                    return undefined;
                }

                var newCourseComponentComponent = new CourseComponentComponent(title, segment.startTime, segment.endTime, segment.days, uniqueCourseComponentId);

                courseComponentComponentArr.push(newCourseComponentComponent)
            }

            return courseComponentComponentArr;

        }

        /**
         *
         * @param title name of the class
         * @param startTime time that the class starts
         * @param endTime time that the class ends
         * @param days array of days that the course (AT THAT GIVEN TIME) is offered
         * @param id identification int for the given event
         * returns an event object that can be added to the calendar
         *
         * note, this can only create events at the same time, so adding a course component may require
         * adding multiple of these
         */
        function CourseComponentComponent(title, startTime, endTime, days, id){
            this.title = title;

            var startTimeHour = Math.floor(startTime / 60);
            var startTimeMinute = startTime % 60;

            var endTimeHour = Math.floor(endTime / 60);
            var endTimeMinute = endTime % 60;

            this.start = "" + startTimeHour + ":" + startTimeMinute;
            this.end = "" + endTimeHour + ":" + endTimeMinute;

            console.log(this.start);
            console.log(this.end);

            this.dow = days;
            this.id = id;

            this.allDay = false;
        }

        /* event source that contains custom events on the scope */
        $scope.events = [];
        $scope.events = $scope.events.concat(createArrOfEventsForCourseComponent("CPE 309-01", [{startTime: 9 * 60 + 10, endTime: 10 * 60, days: [Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY]}],1));
        $scope.events = $scope.events.concat(createArrOfEventsForCourseComponent("CPE 309-02", [{startTime: 10 * 60 + 10, endTime: 11 * 60, days: [Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY]}], 2));
        $scope.events = $scope.events.concat(createArrOfEventsForCourseComponent("PHYS 132-01", [
            {startTime: 11 * 60 + 10, endTime: 12 * 60, days: [Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY]},
            {startTime: 15 * 60 + 10, endTime: 18 * 60, days: [Day.WEDNESDAY]}
        ],3));
        $scope.events = $scope.events.concat(createArrOfEventsForCourseComponent("PHIL 231-06", [{startTime: 18 * 60 + 10, endTime: 20 * 60, days: [Day.MONDAY, Day.WEDNESDAY]}], 4));
        $scope.events = $scope.events.concat(createArrOfEventsForCourseComponent("CPE 436-03", [{startTime: 13 * 60 + 40, endTime: 15 * 60, days: [Day.TUESDAY, Day.THURSDAY]}], 5));
        $scope.events = $scope.events.concat(createArrOfEventsForCourseComponent("CPE 436-04", [{startTime: 15 * 60 + 10, endTime: 16 * 60 + 30, days: [Day.TUESDAY, Day.THURSDAY]}], 6));

        /* add and removes an event source of choice */
        $scope.addRemoveEventSource = function (sources, source) {
            var canAdd = 0;
            angular.forEach(sources, function (value, key) {
                if (sources[key] === source) {
                    sources.splice(key, 1);
                    canAdd = 1;
                }
            });
            if (canAdd === 0) {
                sources.push(source);
            }
        };
        /* add custom event*/
        $scope.addEvent = function () {
            $scope.events.push({
                title: 'Open Sesame',
                start: new Date(y, m, 28),
                end: new Date(y, m, 29),
                className: ['openSesame']
            });
        };
        /* remove event */
        $scope.remove = function (index) {
            $scope.events.splice(index, 1);
        };

        $scope.calendarInstanceState = {
            currentView: "month",
            currentCalendar: "myCalendar1"
        }

        /* Change View */
        $scope.changeView = function (view, calendar) {
            $scope.calendarInstanceState.currentView = view;
            uiCalendarConfig.calendars[calendar].fullCalendar('changeView', view);
        };
        /* Change View */
        $scope.renderCalendar = function (calendar) {
            $timeout(function () {
                if (uiCalendarConfig.calendars[calendar]) {
                    uiCalendarConfig.calendars[calendar].fullCalendar('render');
                }
            });
        };
        /* Render Tooltip */
        $scope.eventRender = function (event, element, view) {
            element.attr({
                'tooltip': event.title,
                'tooltip-append-to-body': true
            });
            $compile(element)($scope);
        };
        /* config object */
        $scope.uiConfig = {
            calendar: {
                height: 500,
                editable: true,
                header: {
                    left: 'title',
                    center: '',
                    right: 'today prev,next'
                },
                eventClick: $scope.alertOnEventClick,
                eventDrop: $scope.alertOnDrop,
                eventResize: $scope.alertOnResize,
                eventRender: $scope.eventRender,
                minTime: "6:00:00",
                maxTime: "22:00:00"
            }
        };

        $scope.showModal = false;

        $scope.openAddCourseSectionModal = function () {
            ModalService.showModal({
                templateUrl: "addEvent.partial.html",
                controller: "ModalController"
            }).then(function(modal) {

                //it's a bootstrap element, use 'modal' to show it
                console.log(modal.element)
                modal.element.modal();
                modal.close.then(function(result) {
                    console.log(result);
                    var days = [];
                    if(result.days.sunday) days.push(Day.SUNDAY);
                    if(result.days.monday) days.push(Day.MONDAY);
                    if(result.days.tuesday) days.push(Day.TUESDAY);
                    if(result.days.wednesday) days.push(Day.WEDNESDAY);
                    if(result.days.thursday) days.push(Day.THURSDAY);
                    if(result.days.friday) days.push(Day.FRIDAY);
                    if(result.days.saturday) days.push(Day.SATURDAY);
                    var newCompArr = createArrOfEventsForCourseComponent(result.department + " " + result.courseNumber + "-" + result.courseSection, [{startTime: result.startTime, endTime: result.endTime, days: days}],10);
                    if(newCompArr) {
                        $scope.events = $scope.events.concat(newCompArr);
                        console.log(newCompArr)
                    }
                    $scope.renderCalendar($scope.calendarInstanceState.currentCalendar)
                });
                console.log("test")
            });

        };

        $scope.changeLang = function () {
            $scope.uiConfig.calendar.dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
            $scope.uiConfig.calendar.dayNamesShort = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
        };
        /* event sources array*/
        $scope.eventSources = [$scope.events];
        $scope.eventSources2 = [$scope.events];
    });


calendarDemoApp.directive("navigationBar", function () {
    return {
        restrict: "E",
        templateUrl: "/navbar.partial.html",
        scope: {},
        controller: ['$scope', function navbarCtrl(scope) {
            console.log(scope.$parent.calendarInstanceState);
        }]
    }
});

calendarDemoApp.controller("ModalController", function($scope, close){
    console.log("modal loaded")

    $scope.newCourseComponent = {
        department: "",
        courseNumber: "",
        courseSection: "",
        startTime: "",
        endTime: "",
        days: {
            sunday: false,
            monday: false,
            tuesday: false,
            wednesday: false,
            thursday: false,
            friday: false,
            saturday: false
        }
    };

    $scope.courseComponentReady = function(){
        var bool1 = $scope.newCourseComponent.department.length != 0 && $scope.newCourseComponent.courseNumber &&
                $scope.newCourseComponent.courseSection && $scope.newCourseComponent.startTime && $scope.newCourseComponent.endTime;

        var days = $scope.newCourseComponent.days;
        var bool2 = days.sunday || days.monday || days.tuesday || days.wednesday || days.thursday || days.friday || days.saturday;

        return bool1 && bool2;
    };

    $scope.closeModal = function(msg){
        console.log("modal is being closed");
        close(msg, 500);
    }

});