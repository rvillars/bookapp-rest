'use strict';

var bookapp = angular.module('bookapp', ['controllers', 'services','directives', 'ui.bootstrap', 'pascalprecht.translate']);

bookapp.config(function ($routeProvider) {
    $routeProvider.
        when('/', {templateUrl: 'pages/books.html', activeMenu: 'books'}).
        when('/books', {templateUrl: 'pages/books.html', activeMenu: 'books'}).
        when('/authors', {templateUrl: 'pages/authors.html', activeMenu: 'authors'}).
        otherwise({redirectTo: '/'});
});

bookapp.config(function ($translateProvider) {
    $translateProvider.useUrlLoader('/ch.bfh.swos.bookapp.rest/rest/messageBundle');
    $translateProvider.useStorage('UrlLanguageStorage');
    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('en');
});
