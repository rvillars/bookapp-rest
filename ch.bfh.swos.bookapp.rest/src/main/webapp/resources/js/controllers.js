'use strict';

var controllers = angular.module('controllers', ['services','elasticjs.service']);

controllers.controller('BookController', ['$scope', 'Book', 'Author', function($scope, Book, Author) {

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
		Book.remove({bookId:id});
    };
}]);

controllers.controller('AuthorController', ['$scope', 'Author', function($scope, Author) {
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
		Author.remove({authorId:id});
    };
}]);

controllers.controller('SearchController', ['$scope', 'ejsResource', function($scope, ejsResource) {
    var ejs = ejsResource('http://localhost:9200');
    var oQuery = ejs.QueryStringQuery();
    var client = ejs.Request()
    	.indices('bookapp')
    	.types('book');

    $scope.search = function () {
    	$scope.results = client
        	.query(oQuery.query($scope.term || '*'))
        	.doSearch();
    };
    
    $scope.getBook = function(doc) {
    	return doc._source;
    };
}]);

controllers.controller('NavController', ['$scope', '$rootScope', '$route', function($scope, $rootScope, $route) {
	$rootScope.route = $route;
}]);

function filterById(array, id) {
    return array.filter(function (object) {
        return object.id == id;
    })[0];
}