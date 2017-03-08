var myAppModule = angular.module('roomApp', ["ngTable"]);

myAppModule.directive("navigationBar", function () {
    return {
        restrict: "E",
        templateUrl: "../views/navbar.partial.html",
        scope: {},
        controller: ['$scope', function navbarCtrl(scope) {
        }]
    }
});

myAppModule.controller('RoomController', function($scope, $http, $filter, NgTableParams) {
    var self = this;
    $scope.enableFiltering = true;

    $scope.refreshRooms = function() {

        $http({
            method: 'GET',
            url: '/room'
        }).then(function successCallback(response) {
            console.log(response.data);
            $scope.data = response.data;
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
        var tp = new NgTableParams({}, {dataset: $scope.data});
    };


    $scope.refreshRooms();

    $scope.addRoom = function() {
        var obj = {
            name : $scope.name,
            resources : [$scope.resources],
            capacity: $scope.capacity,
            roomType: $scope.roomType
        };
        $http({
            method: 'POST',
            url: '/room',
            data: obj,
            headers : {'Content-Type': 'application/json',
                'Accept': '*/*' }
        }).then(function successCallback(response) {
            $scope.message = response.data;
            $scope.refreshRooms();
        }, function errorCallback(response) {
            console.log(response);
        });
    };

    $scope.refreshRooms();

    $scope.remove=function(roomID){
        $http({
            method: 'DELETE',
            url: '/room' + '?id=' + roomID,
            headers : {'Content-Type': 'application/json',
                'Accept': '*/*' }
        }).then(function successCallback(response) {
            $scope.message = response.data;
            $scope.refreshRooms();
        }, function errorCallback(response) {
            console.log(response);
        });
    }
});