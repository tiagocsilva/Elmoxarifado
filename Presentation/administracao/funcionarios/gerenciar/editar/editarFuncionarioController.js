app.controller("editarFuncionarioController",function(apiUrl, $scope, $http, $routeParams) {

    $scope.usuario = [];

    function buscarUsuario() {
        $http.get(apiUrl + "/funcionarios/buscar/" + $routeParams.matricula).then(function(usuario) {
            $scope.usuario = usuario.data;
        });
    }

    function resetarSenha() {
        $http.post(apiUrl + "/funcionarios/resetarSenha", $scope.usuario).then(function(novaSenha) {
             swal({title: "Senha RESETADA com sucesso!", text: "Nova SENHA: " + novaSenha.data}, function() {
                location.href = "#!/administracao/funcionarios/gerenciar"; 
            }); 
        });
    }

    function salvar() {
        $http.put(apiUrl + "/funcionarios/editar", $scope.usuario).then(function() {
             swal({title: "Funcionario SALVO com sucesso!"}, function() {
                location.href = "#!/administracao/funcionarios/gerenciar"; 
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