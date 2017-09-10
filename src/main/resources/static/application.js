'use strict';
//routing, default settings....
var app = angular.module('sos',['ngRoute','mgcrea.ngStrap']);

app.config(['$httpProvider','$logProvider','$routeProvider',
	function($httpProvider,$logProvider,$routeProvider) {
		$logProvider.debugEnabled(true);
		
		
		  $httpProvider.defaults.headers.common = {};
		  $httpProvider.defaults.headers.post = {};
		  $httpProvider.defaults.headers.put = {};
		  $httpProvider.defaults.headers.patch = {};
		
		//$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		  
		
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
		
    
	}
])


/*
 .controller('index', function($http) {
    var self = this;
    $http.get('/api/{userId}/').then(function(response) {
     self.user = response.data;
    })
  })*/
  .controller('navigation', function($rootScope, $http, $location) {

  var self = this

  var authenticate = function(credentials, callback) {

    var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
    } : {};

    $http.get('user', {headers : headers}).then(function(response) {
      if (response.data.name) {
        $rootScope.authenticated = true;
      } else {
        $rootScope.authenticated = false;
      }
      callback && callback();
    }, function() {
      $rootScope.authenticated = false;
      callback && callback();
    });

  }

  authenticate();
  self.credentials = {};
  self.login = function() {
      authenticate(self.credentials, function() {
        if ($rootScope.authenticated) {
          $location.path("/");
          self.error = false;
        } else {
          $location.path("/login");
          self.error = true;
        }
      });
  };
});
self.logout = function() {
  $http.post('logout', {}).finally(function() {
    $rootScope.authenticated = false;
    $location.path("/");
  });
}
	  
	  
	  /*.controller('index', function($http) {
  var self = this;
  $http.get('token').then(function(response) {
    $http({
      url : 'http://localhost:9000',
      method : 'GET',
      headers : {
        'X-Auth-Token' : response.data.token
      }
    }).then(function(response) {
      self.user = response.data;
    });
  })
});*/