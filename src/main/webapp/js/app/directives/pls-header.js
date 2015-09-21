angular.module('plsApp').directive('plsHeader', [
   function() {
        return {
            restrict: 'A',
            templateUrl: 'templates/components/header.html'
        };
    }

]);