function Hello($scope, $http) {
	$http.get('http://rest-service.guides.spring.io/greeting').success(
			function(data) {
				$scope.greeting = data;
			});
}

function customersController($scope, $http) {
	$scope.authorizedOnly = true;
	$http.get("http://www.w3schools.com/website/Customers_JSON.php").success(
			function(response) {
				$scope.names = response;
			});
}