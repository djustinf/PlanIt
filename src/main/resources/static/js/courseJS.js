var myAppModule = angular.module('courseApp', ["ngTable"]);

myAppModule.controller('CourseController', function($scope, $http, $filter, NgTableParams) {
    var self = this;
    $scope.enableFiltering = true;
    $http({
        method: 'GET',
        url: '/course'
    }).then(function successCallback(response) {
        console.log(response.data);
        $scope.data = response.data;
    }, function errorCallback(response) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
    });
    var tp = new NgTableParams({}, { dataset: $scope.data});
});