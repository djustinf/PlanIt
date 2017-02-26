angular.module('adminStuff', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('adminStuff').controller('AdminPage', function ($scope) {

    $scope.options = {
        hstep: [1, 2, 3],
        mstep: [1, 5, 10, 15, 25, 30]
    };
});