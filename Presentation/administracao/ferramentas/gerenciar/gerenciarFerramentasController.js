app.controller("gerenciarFerramentasController",function($scope, $http) {

    $scope.ferramentas = [];

    function buscarFerramentas() {
        $http.get("http://localhost:8080/ferramentas/buscar").then(function(ferramentas) {
            $scope.ferramentas = ferramentas.data;
        });
    }

    buscarFerramentas();
});