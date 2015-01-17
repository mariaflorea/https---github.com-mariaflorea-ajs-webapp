angular.module('MonsterSearch', []).controller(
		'monstersController',
		function($scope, $http, $location) {
			$scope.code = '';
			$scope.authorizedOnly = true;
			var path = window.location.toString();
			path = path.substring(0, path.lastIndexOf('/'));
			var getData = function(){
				if (  $scope.code == undefined ) {
					return false;
				}
				var url = path + '/monsters/' + '123' 
						+ '?code=' + encodeURIComponent( $scope.code ) 
						+ '&isAuthorizedOnly=' + ( $scope.authorizedOnly ? 1: 0 );
				//alert(url);
				$http.get( url )
						.success(function(response) {
							$scope.rows = response.monster;
						});
			}
			$scope.submit = function(){
				getData();
			}
			
			getData();
			
		}).config(function($locationProvider) {
	$locationProvider.html5Mode(true).hashPrefix('!');
});