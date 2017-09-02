'use strict';

var app = angular.module('sos',['ngRoute','mgcrea.ngStrap']);

app.config(['$httpProvider','$logProvider','$routeProvider',
	function($httpProvider,$logProvider,$routeProvider) {
		$logProvider.debugEnabled(true);
		
		$routeProvider
		.when('/', {
		    controller: 'MainController',
		    templateUrl: 'index.html',
			controllerAs: 'controller'
		})
		.when('/download',{
			templateUrl: 'download.html'
		})
				.when('/login',{
			templateUrl: 'login.html',
			controller: 'navigation',
			controllerAs: 'controller'
		})

		.otherwise({
		    redirectTo: '/'
		});
		
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	}
])
  .controller('index', function($http) {
    var self = this;
    $http.get('/{userId}/').then(function(response) {
      self.userId = response.data;
    })
  })
  .controller('navigation', function() {});

	  