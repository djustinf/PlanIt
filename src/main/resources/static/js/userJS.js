var myAppModule = angular.module('userApp', ["ngTable"]);

myAppModule.controller('UserController', function($scope, $http, $filter, NgTableParams) {
    var self = this;
    $scope.users = [];
    $scope.enableFiltering = true;
    $http({
        method: 'GET',
        url: '/user/faculty'
    }).then(function successCallback(response) {
        console.log(response.data);
        $scope.data = response.data;
    }, function errorCallback(response) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
    });
    var tp = new NgTableParams({}, { dataset: $scope.data});
});