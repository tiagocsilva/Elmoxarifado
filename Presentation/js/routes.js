var app = angular.module("elmoapp", ["ngRoute","ngAnimate"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/administracao", {
        templateUrl : "administracao/administracao.html"        
    })
    .when("/administracao/usuarios/novo", {
        templateUrl : "administracao/usuarios/novo/novo.html",
        controller: "novoUsuarioController"
    })
    .when("/administracao/usuarios/gerenciar", {
        templateUrl : "administracao/usuarios/gerenciar/gerenciar.html",
        controller: "gerenciarUsuariosController"        
    })
    .when("/administracao/usuarios/gerenciar/editar/:matricula", {
        templateUrl : "administracao/usuarios/gerenciar/editar/editar.html",
        controller: "editarUsuarioController"
    })
    .when("/administracao/ferramentas/nova", {
        templateUrl : "administracao/ferramentas/nova/nova.html",
        controller: "novaFerramentaController"
    })
    .when("/administracao/ferramentas/gerenciar", {
        templateUrl : "administracao/ferramentas/gerenciar/gerenciar.html",
        controller: "gerenciarFerramentasController"
    })
    .when("/administracao/ferramentas/gerenciar/editar/:id", {
        templateUrl : "administracao/ferramentas/gerenciar/editar/editar.html",
        controller: "editarFerramentaController"
    })
    .when("/administracao/sobre", {
        templateUrl : "administracao/sobre/sobre.html"
    })
    .otherwise({redirectTo: "/administracao"});
});