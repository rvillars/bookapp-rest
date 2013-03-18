'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Book', function ($resource) {
    return $resource('rest/books/:id', {id: '@id'}, {
        'update': {method: 'PUT'}
    });
});

services.factory('Author', function ($resource) {
    return $resource('rest/authors/:id', {id: '@id'}, {
        'update': {method: 'PUT'}
    });
});