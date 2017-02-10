var myAppModule = angular.module('myApp', []);
myAppModule.controller('TestController', function($scope) {
  $scope.message = "Goodbye World";
  $scope.arr = ["hi", "lol", "bye"];
  $scope.action = function(newMsg) {
    console.log("I've been clicked"); 
     $scope.arr.push(newMsg); 
  };
  $scope.show = false;
  $scope.submit = function($location) {
    console.log("Submit was clicked");
    if (!$scope.username || !$scope.password) {
      $scope.err = true;
      $location.url("http://localhost:63342/project1/Business%20Logic/src/View/viewSchedule.html");
    }
    else {
      $scope.err = false;
      console.log("Attempt to log in with" + $scope.username + " and password " + $scope.password);
    }
  };
  $scope.err = false;
});
