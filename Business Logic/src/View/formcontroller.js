var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.years = ["Year", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"];
    $scope.terms = ["Term", "Fall", "Winter", "Spring"];
    $scope.views = ["View", "Week View", "List View"];
    $scope.courseLevels = ["100", "200", "300", "400", "500"];
    $scope.days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    $scope.faculty = ["Bob", "John", "Sally", "Susie"];
    $scope.classes = ["101", "102", "103"];
    $scope.times = ["Morning", "Afternoon", "Evening", "Night"];
});