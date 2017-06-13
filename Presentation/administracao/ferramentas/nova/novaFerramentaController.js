app.controller("novaFerramentaController",function(apiUrl, $scope, $http) {

    //Variáveis View
    $scope.descricao;
    $scope.fabricante;
    $scope.valor;

    function formatarValor(valor) {
        return valor.split(",").join(".");
    }

   $scope.salvar = function() {

        var ferramenta = {
            descricao: $scope.descricao,
            fabricante: $scope.fabricante,
            valor: formatarValor($scope.valor)               
        }        

        $http.post(apiUrl + "/ferramentas/cadastrar", ferramenta).then(function(codFerramenta) {
            swal({title: "Ferramenta cadastrada com sucesso!", text: "Código da Ferramenta: " + codFerramenta.data}, function() {
                location.href = "#!/administracao"; 
            });                       
        },function(err) {
            alert(err.data.message);
        });
    }
});