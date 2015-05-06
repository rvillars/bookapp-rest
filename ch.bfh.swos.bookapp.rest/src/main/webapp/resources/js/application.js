'use strict';

var bookapp = angular.module('bookapp', ['books', 'authors', 'ui.bootstrap']);

bookapp.config(function ($routeProvider) {
    $routeProvider.
        when('/', {templateUrl: 'pages/books.html', activeMenu: 'books'}).
        when('/books', {templateUrl: 'pages/books.html', activeMenu: 'books'}).
        when('/authors', {templateUrl: 'pages/authors.html', activeMenu: 'authors'}).
        otherwise({redirectTo: '/'});
});

bookapp.controller('NavController', ['$scope', '$rootScope', '$route', function ($scope, $rootScope, $route) {
    $rootScope.route = $route;
}]);
