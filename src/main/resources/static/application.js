'use strict';
//routing, default settings....The angular module is defined in here  [] parameter in the module definition can be used to define dependent modules
var app = angular.module('sos',['ngRoute','mgcrea.ngStrap']);

app.config(['$httpProvider','$logProvider','$routeProvider',
	function($httpProvider,$logProvider,$routeProvider) {
		$logProvider.debugEnabled(true);
		
		/* THESE WILL STOP THE INFO WINDO OPEN AND GIVE A FAULT//CLEAR COOKIES 
		  $httpProvider.defaults.headers.common = {};
		  $httpProvider.defaults.headers.post = {};
		  $httpProvider.defaults.headers.put = {};
		  $httpProvider.defaults.headers.patch = {};
		*/
		 //$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';//will stop pop up info windo too
		//delete $httpProvider.defaults.headers.post['Content-type']
		$routeProvider
		.when('/', {
		    controller: 'MainController',
		    templateUrl: 'index.html'
		})
		.when('/download',{
			templateUrl: 'download.html'
		})
		.when('/login',{//when I go to /login I want to use navigation controller
			templateUrl: 'login.html',
			controller: 'navigation',
			controllerAs: 'controller'
		})
		.otherwise({
		    redirectTo: '/'
		});

	}
])
