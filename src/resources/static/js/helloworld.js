var app = angular.module('demo', []);
app.controller('Hello', function($scope, $http) {
    $http.get("localhost:8080/helloworld")
        .then(function(response) {
            $scope.greeting = response.data;
        });
});
