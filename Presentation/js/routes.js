var app = angular.module("elmoapp", ["ngRoute","ngAnimate"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/administracao", {
        templateUrl : "administracao/administracao.html"
    })
    .when("/administracao/usuarios/novo", {
        templateUrl : "administracao/usuarios/novo.html"
    })
    .when("/administracao/usuarios/gerenciar", {
        templateUrl : "administracao/usuarios/gerenciar.html"
    })
    .when("/administracao/ferramentas/nova", {
        templateUrl : "administracao/ferramentas/nova.html"
    })
    .when("/administracao/sobre", {
        templateUrl : "administracao/sobre/sobre.html"
    })
    .otherwise({redirectTo: "/administracao"});
});