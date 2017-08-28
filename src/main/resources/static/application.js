'use strict';

var app = angular.module('sos',['ngRoute','mgcrea.ngStrap']);

app.config(['$httpProvider','$logProvider','$routeProvider',
	function($httpProvider,$logProvider,$routeProvider) {
		$logProvider.debugEnabled(true);
		
		$routeProvider
		.when('/', {
		    controller: 'MainController',
		    templateUrl: 'index.html'
		})
		.when('/download',{
			templateUrl: 'download.html'
	/*	})
			.when('/login',{
			templateUrl: 'login.html'
		})
				.when('/index',{
			templateUrl: 'index.html'
		})*/
		.otherwise({
		    redirectTo: '/'
		});
	}
])


