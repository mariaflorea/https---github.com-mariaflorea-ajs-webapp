angular.module('MonsterSearch', [])
	.controller('monstersController',
		function($scope, $http, $location) {
			$scope.code = '';
			$scope.authorizedOnly = true;
			$scope.totalRows = 0;
			$scope.limit = 3;
			var path = window.location.toString();
			path = path.substring(0, path.lastIndexOf('/'));
			
			function getData() {
				if (  $scope.code == undefined ) {
					return false;
				}
				var url = path + '/monsters/' + '123' 
						+ '?code=' + encodeURIComponent( $scope.code ) 
						+ '&isAuthorizedOnly=' + ( $scope.authorizedOnly ? 1: 0 )
						+ '&limit=' + $scope.limit;
				//alert(url);
				$http.get( url )
						.success(function(response) {
							$scope.data = response.monster;
							$scope.totalRows = response.totalRows;
						});
			}
			
			$scope.submit = function(){
				getData();
			}
			
			//getData();
			
		}
	);