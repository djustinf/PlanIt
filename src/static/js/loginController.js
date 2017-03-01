/**
 * Created by Sonia on 2/28/17
 */
var myModule = angular.module('Authentication', []);

    myModule.controller('LoginController', function($scope, $window) {

        $scope.guest = function(){
            $location.path("../views/calendar.html");
        };


        $scope.err = false;

        $scope.login = function() {

            if (!$scope.username || !$scope.password) {
                $scope.err = true;
            }
            else {
                var validate = ($scope.username == "hello" && $scope.password == "there");

                if (validate) {
                    $scope.err = false;
                    $window.location.href = '/calendar.html';
                }
                console.log("Attempt to log in with" + $scope.username + " and password " + $scope.password);
            }


        }
    });