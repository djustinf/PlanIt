angular.module('HelloWorldApp', [])
    .controller('HelloWorldController', function($scope, $http) {
        $http.get('localhost:').
        then(function(response) {
            $scope.greeting = response.data;
        });
    });