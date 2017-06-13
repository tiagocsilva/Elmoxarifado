app.controller("novoEmprestimoController",function(apiUrl, $scope, $http) {

    //Variáveis View
    $scope.matriculaFuncionario = -1;
    $scope.idFerramenta = -1;
    $scope.inicio;
    $scope.validade;

    function getDate(strDate) { 
        var dia = strDate.slice(0,2);
        var mes = strDate.slice(3,5)-1;
        var ano = strDate.slice(6,10);
        return new Date(ano, mes, dia).getTime();        
    }

    function buscarFuncionarios() {
        $http.get(apiUrl + "/funcionarios/buscar").then(function(funcionarios) {
            $scope.funcionarios = funcionarios.data;
        });
    }

    function buscarFerramentasDisponiveis() {        
        $http.get(apiUrl + "/ferramentas/buscarDisponiveis").then(function(ferramentas) {
            $scope.ferramentas = ferramentas.data;
        });
    }

    buscarFuncionarios();
    buscarFerramentasDisponiveis();

   $scope.salvar = function() {
        
        var emprestimo = {
            matriculaFuncionario: $scope.matriculaFuncionario,
            ferramentaId: $scope.idFerramenta,
            inicio: getDate($scope.inicio),
            validade: getDate($scope.validade)
        }        

        $http.post(apiUrl + "/emprestimos/novo", emprestimo).then(function(codFerramenta) {
            swal({title: "Empréstimo realizado com sucesso!"}, function() {
                location.href = "#!/administracao"; 
            });                    
        }, function(err) {
            alert(err.data.message);
        });
    }
});