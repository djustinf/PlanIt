var myAppModule = angular.module('userApp', ["ngTable"]);

myAppModule.controller('UserController', function($scope, $filter, NgTableParams) {
    var self = this;
    $scope.enableFiltering = true;
    $scope.data = [{facultyName: "John Doe"}, {facultyName: "Jane Doe"}, {facultyName: "Mary"}];
    var tp = new NgTableParams({}, { dataset: $scope.data});
});
