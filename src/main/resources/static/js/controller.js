var myAppModule = angular.module('myApp', []);

myAppModule.controller('TestController', function($scope) {


    $scope.message = "Goodbye World";
    $scope.arr = ["hi", "lol", "bye"];
    $scope.action = function (newMsg) {
        console.log("I've been clicked");
        $scope.arr.push(newMsg);
    };
    $scope.show = false;
    $scope.submit = function ($location) {
        console.log("Submit was clicked");
        if (!$scope.username || !$scope.passwolrd) {
            $scope.err = true;
        }
        else {
            $scope.err = false;
            console.log("Attempt to log in with" + $scope.username + " and password " + $scope.password);
        }
    };
    $scope.err = false;

    $scope.rowCollection = [
        {
            firstName: 'Laurent',
            lastName: 'Renard',
            birthDate: new Date('1987-05-21'),
            balance: 102,
            email: 'whatever@gmail.com'
        },
        {
            firstName: 'Blandine',
            lastName: 'Faivre',
            birthDate: new Date('1987-04-25'),
            balance: -2323.22,
            email: 'oufblandou@gmail.com'
        },
        {
            firstName: 'Francoise',
            lastName: 'Frere',
            birthDate: new Date('1955-08-27'),
            balance: 42343,
            email: 'raymondef@gmail.com'
        }
    ];

    $scope.removeRow = function removeRow(row) {
        var index = scope.rowCollection.indexOf(row);
        if (index !== -1) {
            scope.rowCollection.splice(index, 1);
        }
    }
});


