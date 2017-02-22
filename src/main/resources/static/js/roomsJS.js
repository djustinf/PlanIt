var myAppModule = angular.module('roomApp', ["ngTable"]);

myAppModule.controller('RoomController', function($scope, $filter, NgTableParams) {
    var self = this;
    $scope.enableFiltering = true;
    $scope.data = [{buildingNum: "103 ", roomNum: 23, cap: 25}, {buildingNum: "215 ", roomNum: 115, cap: 30}];
    var tp = new NgTableParams({}, { dataset: $scope.data});
});
