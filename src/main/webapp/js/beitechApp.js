	var app = angular.module("BeitechApp", []);

	//Controller Part
	app.controller("CustomerController", function($scope, $http) {

		$scope.customerModel = {
			customer_id : "",
			name : "",
			email : ""
		};
		
		
		$scope.user = {
				id : -1,
				start_date : "",
				end_date : "",
		};
		
		$scope.mostrar = false;

		
		$scope.listCustomers = [];

		$scope.listOrdersByCustomers = [];

		_consultAllCustomers();
		
		$scope.submitCustomer = function() {
			var yestermonth = new Date();
			yestermonth.setMonth(yestermonth.getMonth() - 1);
			
            $http({
                method : 'GET',
                url : 'http://localhost:8080/listOrders',
                params : {
                    "customerId" : $scope.user.id,
                    "startDate" : yestermonth,
                    "endDate" : new Date()
                }
            }).then( function successCallback(response) {
                console.log(response.data);
                $scope.mostrar = true;
                $scope.user.start_date = yestermonth;
                $scope.user.end_date = new Date();
                $scope.listOrdersByCustomers = response.data;
            }, _error );
        };
        
	

		/* Private methods */
		function _consultAllCustomers() {
			$http({
				method : 'GET',
				url : 'http://localhost:8080/getAllCustomers'
			}).then(function successCallback(response) {
				$scope.listCustomers = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		};
		
		function _success(response) {
			_consultAllCustomers();            
        };
 
        function _error(response) {
            console.log(response.statusText);
        };
        

	});