var app = angular.module("miApp", [ "ngRoute", "ngStorage" ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		controller : "menuController",
		controllerAs : "m1",
	}).when("/pedidos", {
		controller : "pedidosController",
		templateUrl : "paginas/pedidosClientes.html"
	});
});