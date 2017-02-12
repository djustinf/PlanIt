var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope) {
    $scope.menus = [
        {
            name: "Year",
            values: ["2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"]
        },
        {
            name: "Terms",
            values: ["Fall", "Winter", "Spring"]
        },
        {
            name: "Views",
            values: ["Week View", "List View"]
        },
        {
            name: "Course Levels",
            values: ["100", "200", "300", "400", "500"]
        },
        {
            name: "Days",
            values: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
        },
        {
            name: "Faculty",
            values: ["Course Level", "100", "200", "300", "400", "500"]
        },
        {
            name: "Classes",
            values: ["101", "102", "103"]
        },
        {
            name: "Time",
            values: ["Morning", "Afternoon", "Evening", "Night"]
        },
    ]
});