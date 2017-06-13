app.controller("gerenciarFerramentasController",function(apiUrl, $scope, $http) {

    $scope.ferramentas = [];

    function buscarFerramentas() {        
        $http.get(apiUrl + "/ferramentas/buscar").then(function(ferramentas) {
            $scope.ferramentas = ferramentas.data;
        });
    }

    buscarFerramentas();
});