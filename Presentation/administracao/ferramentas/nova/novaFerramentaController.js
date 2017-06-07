app.controller("novaFerramentaController",function($scope, $http) {

    //Variáveis View
    $scope.descricao;
    $scope.fabricante;
    $scope.valor;

   $scope.salvar = function() {

        var ferramenta = {
            descricao: $scope.descricao,
            fabricante: $scope.fabricante,
            valor: $scope.valor                
        }        

        $http.post("http://localhost:8080/ferramentas/cadastrar", ferramenta).then(function(codFerramenta) {
            swal({title: "Ferramenta cadastrada com sucesso!", text: "Código da Ferramenta: " + codFerramenta.data}, function() {
                location.href = "#!/administracao"; 
            });                       
        });
    }
});