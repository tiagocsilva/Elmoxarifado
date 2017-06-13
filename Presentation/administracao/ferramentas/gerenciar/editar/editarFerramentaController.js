app.controller("editarFerramentaController",function(apiUrl, $scope, $http, $routeParams) {

    $scope.ferramenta = [];

    function buscarFerramenta() {
        $http.get(apiUrl + "/ferramentas/buscar/" + $routeParams.id).then(function(ferramenta) {
            $scope.ferramenta = ferramenta.data;
        });
    }

    function excluir() {
        $http.post(apiUrl + "/ferramentas/deletar", $scope.ferramenta).then(function() {
             swal({title: "Ferramenta DELETADA com sucesso!"}, function() {
                location.href = "#!/administracao/ferramentas/gerenciar"; 
            }); 
        });
    }

    function salvar() {
        $http.put(apiUrl + "/ferramentas/editar", $scope.ferramenta).then(function() {
             swal({title: "Ferramenta SALVA com sucesso!"}, function() {
                location.href = "#!/administracao/ferramentas/gerenciar"; 
            }); 
        });
    }

    $scope.excluir = function() {
        excluir();
    }

    $scope.salvar = function() {
        salvar();
    }

    buscarFerramenta();
});