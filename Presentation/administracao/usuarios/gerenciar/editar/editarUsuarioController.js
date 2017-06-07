app.controller("editarUsuarioController",function($scope, $http, $routeParams) {

    $scope.usuario = [];

    function buscarUsuario() {
        $http.get("http://localhost:8080/funcionarios/buscar/" + $routeParams.matricula).then(function(usuario) {
            $scope.usuario = usuario.data;
        });
    }

    function resetarSenha() {
        $http.post("http://localhost:8080/funcionarios/resetarSenha", $scope.usuario).then(function(novaSenha) {
             swal({title: "Senha RESETADA com sucesso!", text: "Nova SENHA: " + novaSenha.data}, function() {
                location.href = "#!/administracao/usuarios/gerenciar"; 
            }); 
        });
    }

    function salvar() {
        $http.put("http://localhost:8080/funcionarios/editar", $scope.usuario).then(function() {
             swal({title: "Usuário SALVO com sucesso!"}, function() {
                location.href = "#!/administracao/usuarios/gerenciar"; 
            }); 
        });
    }

    $scope.resetarSenha = function() {
        resetarSenha();
    }

    $scope.salvar = function() {
        salvar();
    }

    buscarUsuario();
});