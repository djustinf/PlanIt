var myAppModule = angular.module('userApp', ["ngTable"]);

myAppModule.controller('UserController', function($scope, $filter, NgTableParams) {
    $scope.enableFiltering = true;
    var self = this;
    $scope.data = [{facultyName: "John Doe"}, {facultyName: "Jane Doe"}, {facultyName: "Mary"}];
    var tp = new NgTableParams({}, { dataset: $scope.data});
});
