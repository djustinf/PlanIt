var myAppModule = angular.module('roomApp', ["ngTable"]);

myAppModule.controller('RoomController', function($scope, $filter, NgTableParams) {
    var self = this;
    $scope.enableFiltering = true;
    $scope.data = [{num: 103, type: "Lab", cap: 25, offerings: "405, 406", resources: "computers"},
        {num: 102, type: "Lecture", cap:50, offerings:"101, 102, 103", resources: "projector"}];
    var tp = new NgTableParams({}, { dataset: $scope.data});
});
