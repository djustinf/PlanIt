var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.bootstrap']);

app.controller('MainCtrl', ['$scope', '$interval', function ($scope, $interval) {

    // Indicates if a tab is active
    // Needed for proper rendering of grid inside a tab
    $scope.setTab = function(flag){
        $scope[flag] = true;

        // call resize every 200 ms for 2 s after modal finishes opening - usually only necessary on a bootstrap modal
        $interval( function() {
            console.log('in');
            if (flag === 'test') {
                $scope.gridApi1.core.handleWindowResize();
            } else {
                $scope.gridApi2.core.handleWindowResize();
            }
        }, 10, 500);



    };

    $scope.myData = {
        onRegisterApi: function (gridApi) {
            $scope.gridApi1 = gridApi;

        },
        data: [
            {num: 103, type: "Lab", cap: 25, offerings: "405, 406", resources: "computers"},
            {num: 102, type: "Lecture", cap:50, offerings:"101, 102, 103", resources: "projector"}
        ]};

    $scope.myData2 = {
        // Show all merchants of resource in 'overview'-grid (=table)


        onRegisterApi: function (gridApi) {
            $scope.gridApi2 = gridApi;
        },

        data: [
            {facultyName: "John Doe"}, {facultyName: "Jane Doe"}, {facultyName: "Mary"}
        ]};
}]);


