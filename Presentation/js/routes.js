var app = angular.module("elmoapp", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/administracao", {
        templateUrl : "administracao/administracao.html"
    })
    .when("/administracao/usuarios/novo", {
        templateUrl : "administracao/usuarios/novo.html"
    });
});