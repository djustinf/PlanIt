var myAppModule = angular.module('roomApp', ["ngTable"]);

myAppModule.controller('RoomController', function($scope, $http, $filter, NgTableParams) {
    var self = this;
    $scope.rooms = [];
    $scope.enableFiltering = true;
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
    var tp = new NgTableParams({}, { dataset: $scope.data});

    $scope.addRoom = function() {
        $http({
            method: 'POST',
            url: '/room',
            headers : {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(response) {
            console.log(response.data);
            $scope.data = response.data;
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }
});