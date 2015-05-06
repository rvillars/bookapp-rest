'use strict';

var books = angular.module('books', ['ngResource', 'authors']);

books.controller('BookController', ['$scope', 'Book', 'Author', function ($scope, Book, Author) {

    $scope.currentBook = new Book();
    $scope.currentBook.releaseDate = new Date();
    $scope.books = Book.query();
    $scope.authors = Author.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentBook = new Book();
        $scope.currentBook.releaseDate = new Date();
    };

    $scope.save = function () {
        var isNew = $scope.currentBook.id == null;
        if (isNew) {
            $scope.currentBook = Book.save($scope.currentBook);
            $scope.books.push($scope.currentBook);
        } else {
            $scope.currentBook = Book.update($scope.currentBook);
        }
        $scope.cancel();
    };

    $scope.edit = function (book) {
        $scope.currentBook = book;
        $scope.currentBook.author = filterById($scope.authors, book.author.id);
    };

    $scope.remove = function (index, id) {
        $scope.books.splice(index, 1);
        Book.remove({bookId: id});
    };
}]);

books.factory('Book', ['$resource', function ($resource) {
    return $resource('rest/books/:bookId', {bookId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);

function filterById(array, id) {
    return array.filter(function (object) {
        return object.id == id;
    })[0];
}