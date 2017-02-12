var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $http.get("localhost:8080/helloworld")
        .then(function(response) {
            $scope.myWelcome = response.data;
        });
});
