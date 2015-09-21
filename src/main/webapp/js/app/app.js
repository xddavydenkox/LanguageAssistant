'use strict';

angular.module('plsApp', ['ngResource','ngRoute']).config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'templates/pages/home.html', controller: 'HelloCtrl', activetab: 'Home'});
        $routeProvider.when('/test', {templateUrl: 'templates/pages/testWords.html', controller: 'TestWordsCtrl', activetab: 'Test grammar'});
    }
]);