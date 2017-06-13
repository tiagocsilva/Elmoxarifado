app.config(function($routeProvider) {
    $routeProvider    
    .when("/administracao", {
        templateUrl : "administracao/administracao.html"        
    })
    .when("/administracao/funcionarios/novo", {
        templateUrl : "administracao/funcionarios/novo/novo.html",
        controller: "novoFuncionarioController"
    })
    .when("/administracao/funcionarios/gerenciar", {
        templateUrl : "administracao/funcionarios/gerenciar/gerenciar.html",
        controller: "gerenciarfuncionariosController"        
    })
    .when("/administracao/funcionarios/gerenciar/editar/:matricula", {
        templateUrl : "administracao/funcionarios/gerenciar/editar/editar.html",
        controller: "editarFuncionarioController"
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
    .when("/administracao/emprestimos/novo", {
        templateUrl : "administracao/emprestimos/novo/novo.html",
        controller: "novoEmprestimoController"
    })
    .when("/administracao/emprestimos/gerenciar", {
        templateUrl : "administracao/emprestimos/gerenciar/gerenciar.html",
        controller: "gerenciarEmprestimosController"
    })
    .when("/administracao/sobre", {
        templateUrl : "administracao/sobre/sobre.html"
    })
    .otherwise({redirectTo: "/administracao"});
});