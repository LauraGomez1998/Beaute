app.controller("pedidosClientes", function($scope,$http,httpservice,$window,$sessionStorage,$location) {
	
	
	$scope.listarDiasSemestre = function(s) {
		$scope.sem = s;
		$scope.estado.estado1 = true;
		var dato2 = $.param({
			anho : s.anho,
			periodo : s.periodo
		});
		$http({
			url : '../rest/semestre/listarDiasNoLaborales',
			method : "POST",

			data : dato2,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}

		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$scope.dias = data.obj;
			} else {
				$scope.dias = data.obj;
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}
	
});