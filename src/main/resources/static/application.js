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
		*/
		  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		  
		  
		 //$http.defaults.headers.common['Authorization'] = 'Bearer ' + access_token={accessToken};
		
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
// Creating the Angular Controller
app.controller('AppCtrl', function($http, $scope) {

	// method for getting user details
	var getUser = function() {
		$http.get('/user').success(function(user) {
			$scope.user = user;
			console.log('Logged User : ', user);
		}).error(function(error) {
			$scope.resource = error;
		});
	};
	getUser();

	// method for logout
	$scope.logout = function() {
		$http.post('/logout').success(function(res) {
			$scope.user = null;
		}).error(function(error) {
			console.log("Logout error : ", error);
		});
	};
});
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