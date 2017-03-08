var myAppModule = angular.module('userApp', ["ngTable"]);

myAppModule.controller('UserController', function($scope, $http, $filter, NgTableParams) {
    var self = this;
    $scope.enableFiltering = true;
    $scope.email = {};
    $scope.firstName = {};
    $scope.lastName = {};
    $scope.fullName = {};
    $scope.password = {};
    $scope.userName = {};
    $scope.coursePreferences = {};
    $scope.numHours = {};
    $scope.preferredTimes = {};

    $scope.refreshUsers = function () {
        $http({
            method: 'GET',
            url: '/user'
        }).then(function successCallback(response) {
            console.log(response.data);
            $scope.data = response.data;
        }, function errorCallback(response) {
            console.log(response);
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
        var tp = new NgTableParams({}, { dataset: $scope.data});
    };

    $scope.refreshUsers();

    $scope.addUser = function() {
        var obj = {
            email : $scope.email,
            firstName: $scope.firstName,
            fullName: $scope.firstName + $scope.lastName,
            lastName: $scope.lastName,
            password: null,
            userName: $scope.userName,
        };
        $http({
            method: 'POST',
            url: '/user',
            data: obj,
            headers : {'Content-Type': 'application/json',
                'Accept': '*/*' }
        }).then(function successCallback(response) {
            $scope.message = response.data;
            $scope.refreshUsers();
        }, function errorCallback(response) {
            console.log(response);
        });
    };

    $scope.refreshUsers();

    $scope.remove=function(userID){
        $http({
            method: 'DELETE',
            url: '/user' + '?id=' + userID,
            headers : {'Content-Type': 'application/json',
                'Accept': '*/*' }
        }).then(function successCallback(response) {
            $scope.message = response.data;
            $scope.refreshUsers();
        }, function errorCallback(response) {
            console.log(response);
        });
    }

});