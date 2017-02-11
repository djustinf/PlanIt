var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.years = ["Year", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"];
    $scope.terms = ["Term", "Fall", "Winter", "Spring"];
    $scope.views = ["View", "Week View", "List View"];
    $scope.courseLevels = ["Course Level", "100", "200", "300", "400", "500"];
    $scope.days = ["Day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    $scope.faculty = ["Faculty", "Bob", "John", "Sally", "Susie"];
    $scope.classes = ["Class", "101", "102", "103"];
    $scope.times = ["Time", "Morning", "Afternoon", "Evening", "Night"];
});