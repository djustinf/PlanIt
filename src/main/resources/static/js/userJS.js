var myAppModule = angular.module('userApp', ["ngTable"]);

myAppModule.controller('UserController', function($scope, $http, $filter, NgTableParams) {
    var self = this;
    $scope.users = [];
    $scope.enableFiltering = true;


    $scope.refreshUsers = function () {
        $http({
            method: 'GET',
            url: '/user'
        }).then(function successCallback(response) {
            console.log(response.data);
            $scope.data = response.data;
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
        var tp = new NgTableParams({}, { dataset: $scope.data});
    };

    $scope.refreshUsers();

    $scope.addUser = function() {
        var obj = {
            userName: $scope.userName,
            email : $scope.email,
            password: null,
            firstName: $scope.firstName,
            lastName: $scope.lastName,
            fullName: $scope.firstName + $scope.lastName,
            numHours: $scope.numHours,
            coursePreferences : [],
            preferredHours: []
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

});