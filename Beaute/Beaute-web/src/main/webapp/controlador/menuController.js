app.controller("menuController", function($scope, $http, $window,
		$sessionStorage) {

//	/**
//	 * lista de accesos de un usuario
//	 */
//	$scope.accesos = [];
//
//	/**
//	 * funcion que carga los accesos de un usuario en el menu
//	 */
//	$scope.cargarAccesos = function() {
//		
//		if ($sessionStorage.objeto!= undefined) {
//			var ttoken=$sessionStorage.objeto.token;
//			
//			
//			var xsrf = $.param({
//				usuario : $sessionStorage.objeto.usuario
//				
//			});
//			
//			$http({
//				url : '../rest/login/accesos',
//				method : "POST",
//				data : xsrf,
//				headers : {
//					"Content-Type" : "application/x-www-form-urlencoded",
//				    "Authorization" : ttoken
//				}
//			}).success(function(data, status, headers, config) {
//				if (data.codigo == '00') {
//					$scope.accesos = data.obj.accesos;
//					$sessionStorage.objt = data.obj;
//				} else {
//					alert(data.mensaje);
//				}
//			}).error(function(data, status, headers, config) {
//				alert('error::' + data.mensaje);
//			});
//		}else{
//			alert('no tiene usuario');
//			window.location.href = '../app/login.html';
//		}
//	};
//
//	/**
//	 * funcion para cerrar sesion
//	 */
//	$scope.logout = function() {
//		sessionStorage.clear();
//	};
//
//	/**
//	 * constructor
//	 */
//	$scope.iniciar = function() {
//		$scope.cargarAccesos();
//	}
//	$scope.iniciar()
});