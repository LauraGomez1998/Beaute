app.controller("pedidosController", function($scope,$http,$sessionStorage) {
	$scope.cantidad=1;
	$scope.cuotas=1;
	$scope.afiliado=0;
	$scope.ciudad = '';
	$scope.seleccionado='';
	$scope.productos= [];
	$scope.listaTabla= [];
	$scope.lista= [];
	$scope.ciudades = [];
	$scope.afiliados = [];
	
	
	$scope.listarProductos = function(VALOR) {
		
		
		var dato2 = $.param({
			categoria : VALOR
		});
		$http({
			url : 'rest/pedido/listarProductosCatalogo',
			method : "POST",

			data : dato2,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert("entro 2");
				$scope.productos = data.obj;
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			
			alert('error::' + data.mensaje);
		});

	}
	
	
	
	
$scope.listarAfiliados = function(ciudad) {
		
		
		var dato2 = $.param({
			codigo : ciudad.codigo
		});
		alert(dato2);
		$http({
			url : 'rest/pedido/listarAfiliados',
			method : "POST",

			data : dato2,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$scope.afiliados = data.obj;
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			
			alert('error::' + data.mensaje);
		});

	}
	
	
	
	
	
	
	
	
	
	$scope.listarCiudades = function() {

		$http({
			url : 'rest/cliente/listarCiudades',
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
	
	
	
	
$scope.realizarPedido = function() {
	alert("entroo");
		var dato3 = JSON.stringify({
			listaProductoPedidoDTO : $scope.lista,
			afiliado : $scope.afiliado.cedulaAfiliado,
			cliente : $sessionStorage.objeto.cedula,
			cuotas : $scope.cuotas
		});
		
		
		$http({
			url : 'rest/pedido/realizarPedido',
			method : "POST",

			data : dato3,
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
				$scope.listaTabla= [];
				$scope.lista= [];
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			
			alert('error::' + data.mensaje);
		});

	}
	
	
	
	
	$scope.llenarTabla = function(){
		var dato = ({		
			codigo : $scope.seleccionado.codigo,
			nombre : $scope.seleccionado.nombre,
			cantidad : $scope.cantidad
		});
		
		
				$scope.listaTabla.push(dato);
			
				
			
			var dato2 = ({
				codigo : $scope.seleccionado.codigo,
				cantidad : $scope.cantidad
			});
			$scope.lista.push(dato2);	
	}
	
	/*$scope.eliminarTarea = function (dato) {
		alert(dato);
       
        $scope.tareas.splice(dato);
        delete[dato]
    }*/
	
	
	$scope.iniciar = function(){
		$scope.listarCiudades();
	}

	$scope.iniciar();
	
	
});