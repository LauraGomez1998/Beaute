app.controller("pedidosController", function($scope,$http,$sessionStorage) {
	
	$scope.cuotas=1;
	$scope.cliente=1;
	$scope.afiliado=1;
	$scope.cantidad=0;
	$scope.seleccionado='';
	$scope.productos= [];
	$scope.listaTabla= [];
	$scope.lista= [];
	$sessionStorage = $scope.cliente;
	
	
	$scope.listarProductos = function(VALOR) {
		
		alert("entro 22");
		
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
	
$scope.realizarPedido = function() {
		
	alert("entroo");
		var dato3 = JSON.stringify({
			listaProductoPedidoDTO : $scope.lista,
			afiliado : $scope.afiliado,
			cliente : $scope.cliente,
			cuotas : $scope.cuotas
		});
		
		alert(dato3);
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
	
	
	
	
});