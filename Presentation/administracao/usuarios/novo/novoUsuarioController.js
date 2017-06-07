app.controller("novoUsuarioController", function($scope,$http) {
    
    //Variáveis View
    $scope.nome;
    $scope.matricula;
    $scope.ramal;
    $scope.setor;
    $scope.email;
    $scope.usuario;    

    $scope.salvar = function() {

        var func = {
            nome: $scope.nome,
            matricula: $scope.matricula,
            ramal: $scope.ramal,
            setor: $scope.setor,
            login: $scope.usuario,
            email: $scope.email            
        }        

        $http.post("http://localhost:8080/funcionarios/cadastrar", func).then(function(senhaTemporaria) {
            swal({title: "Funcionário cadastrado com sucesso!", text: "A SENHA para o primeiro acesso é: " + senhaTemporaria.data}, function() {
                location.href = "#!/administracao"; 
            });                       
        });
    }

});