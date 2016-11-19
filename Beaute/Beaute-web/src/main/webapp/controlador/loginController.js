app.controller("loginController", function($scope, $http, $window,
		$sessionStorage) {
	
	
	/**
	 * user del usuario
	 */
	$scope.user = '';
	 
	/**
	 * contrasenia del usuario
	 */
	$scope.pass = '';

	/**
	 * funcion para consumir servicio de verificar usuario
	 */
	$scope.login = function() {
		var xsrf = $.param({
			usuario : $scope.user,
			contrasenia : $scope.pass
		});
		$http({
			url : 'rest/login/verificar',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$sessionStorage.objeto = data.obj;
				window.setTimeout(function() {
					window.location.href = '/Beaute-web/menu.html#/';
				}, 1800);
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	};
		
});