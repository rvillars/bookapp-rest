'use strict';

var authors = angular.module('authors', ['ngResource']);

authors.controller('AuthorController', ['$scope', 'Author', function ($scope, Author) {
    $scope.currentAuthor = new Author();
    $scope.authors = Author.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentAuthor = new Author();
    };

    $scope.save = function () {
        var isNew = $scope.currentAuthor.id == null;
        if (isNew) {
            $scope.currentAuthor = Author.save($scope.currentAuthor);
            $scope.authors.push($scope.currentAuthor);
        } else {
            $scope.currentAuthor = Author.update($scope.currentAuthor);
        }
        $scope.cancel();
    };

    $scope.edit = function (author) {
        $scope.currentAuthor = author;
    };

    $scope.remove = function (index, id) {
        $scope.authors.splice(index, 1);
        Author.remove({authorId: id});
    };
}]);

authors.factory('Author', ['$resource', function ($resource) {
    return $resource('rest/authors/:authorId', {authorId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);