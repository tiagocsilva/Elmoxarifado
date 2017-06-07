app.controller("editarFerramentaController",function($scope, $http, $routeParams) {

    $scope.ferramenta = [];

    function buscarFerramenta() {
        $http.get("http://localhost:8080/ferramentas/buscar/" + $routeParams.id).then(function(ferramenta) {
            $scope.ferramenta = ferramenta.data;
        });
    }

    function excluir() {
        $http.post("http://localhost:8080/ferramentas/deletar", $scope.ferramenta).then(function() {
             swal({title: "Ferramenta DELETADA com sucesso!"}, function() {
                location.href = "#!/administracao/ferramentas/gerenciar"; 
            }); 
        });
    }

    function salvar() {
        $http.put("http://localhost:8080/ferramentas/editar", $scope.ferramenta).then(function() {
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