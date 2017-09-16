'use strict';
//routing, default settings....
var app = angular.module('sos',['ngRoute','mgcrea.ngStrap']);

app.config(['$httpProvider','$logProvider','$routeProvider',
	function($httpProvider,$logProvider,$routeProvider) {
		$logProvider.debugEnabled(true);
		
		/* THESE WILL STOP THE INFO WINDO OPEN AND GIVE A FAULT
		  $httpProvider.defaults.headers.common = {};
		  $httpProvider.defaults.headers.post = {};
		  $httpProvider.defaults.headers.put = {};
		  $httpProvider.defaults.headers.patch = {};
		
		  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		  */
		
		$routeProvider
		.when('/', { //when I go to / I want to use MainController
		    controller: 'MainController',
		    templateUrl: 'index.html',
			controllerAs: 'controller'
		})
		.when('/download',{
			templateUrl: 'download.html'
		})
			/*	.when('/login',{//when I go to /login I want to use navigation controller
			templateUrl: 'login.html',
			controller: 'navigation',
			controllerAs: 'controller'
		})*/

		.otherwise({
		    redirectTo: '/'
		});		
	}
])

/*
$http({
  method: 'GET',
  url: 'http://sos.au-syd.mybluemix.net/api',
  headers: { Accept: 'application/json' }
})*/
    

/*
 .controller('MainController', function($http) {//the name of controller is defined inside its class 
    var self = this;
    $http.get('/api/user/{userId}/').then(function(response) {
     self.user = response.data;
    })
  })*/
  
	  
	  /*.controller('MainController', function($http) {
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