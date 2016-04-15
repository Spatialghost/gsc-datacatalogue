/* global admBoard, angular */

'use strict';
angular.module('gscDatacat.controllers')
        .
        controller('searchDatasetsCtrl', [
            '$scope',
            '$rootScope',
            '$stateParams',
            function(
                    $scope,
                    $rootScope,
                    $stateParams) {

                $rootScope.console.log($stateParams);

                $scope.query = $stateParams.query;

            }]);
