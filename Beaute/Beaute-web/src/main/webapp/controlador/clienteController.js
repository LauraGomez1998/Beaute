
app.controller("clienteController", function($scope, $http, $sessionStorage) {

	$scope.cedula = '';
	$scope.nombre = '';
	$scope.apellido = '';
	$scope.ciudad = '';
	$scope.genero = '';
	$scope.usuario = '';
	$scope.contrasenia = '';
	$scope.telefono = '';
	$scope.ciudades = [];

	
	$scope.listarCiudades = function() {

		$http({
			url : '../rest/cliente/listarCiudades',
			method : "GET",
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$scope.ciudades = data.obj;
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {

			alert('error::' + data.mensaje);
		});

	}
	
	
	
	$scope.crear = function() {

		var dato3 = ({
			cedula : $scope.cedula,
			nombre : $scope.nombre,
			apellido : $scope.apellido,
			telefono : $scope.telefono,
			usuario : $scope.usuario,
			contrasenia : $scope.contrasenia,
			genero : $scope.genero,
			ciudad : $scope.ciudad.codigo
		
		});

		$http({
			url : '../rest/cliente/crear',
			method : "POST",

			data : dato3,
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {

			alert('error::' + data.mensaje);
		});

	}
	
	
	
	$scope.eliminar = function() {

		var dato3 = ({
			cedula : $scope.cedula,
			nombre : $scope.nombre,
			apellido : $scope.apellido,
			telefono : $scope.telefono,
			usuario : $scope.usuario,
			contrasenia : $scope.contrasenia,
			genero : $scope.genero,
			ciudad : $scope.ciudad.codigo
		
		});

		$http({
			url : '../rest/cliente/eliminar',
			method : "POST",

			data : dato3,
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {

			alert('error::' + data.mensaje);
		});

	}
	
	
	
	$scope.editar = function() {

		var dato3 = ({
			cedula : $scope.cedula,
			nombre : $scope.nombre,
			apellido : $scope.apellido,
			telefono : $scope.telefono,
			usuario : $scope.usuario,
			contrasenia : $scope.contrasenia,
			genero : $scope.genero,
			ciudad : $scope.ciudad.codigo
		
		});

		$http({
			url : '../rest/cliente/editar',
			method : "POST",

			data : dato3,
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {

			alert('error::' + data.mensaje);
		});

	}
	
	
	
	
	
	
	$scope.buscar = function() {

		var dato2 = $.param({
			cedula : $scope.cedula
		});
		$http({
			url : '../rest/cliente/buscar',
			method : "POST",

			data : dato2,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {

				$scope.nombre = data.obj.nombre;
				$scope.apellido = data.obj.apellido;
				$scope.telefono= data.obj.telefono;
				$scope.usuario= data.obj.usuario;
				$scope.contrasenia= data.obj.contrasenia;
				$scope.genero = data.obj.genero;
				$scope.ciudad = data.obj.ciudad;
				
				
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {

			alert('error::' + data.mensaje);
		});

	}
	
	
	
	
	
	$scope.listarCiudades();

});