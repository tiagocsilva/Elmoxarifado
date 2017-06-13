app.controller("gerenciarFuncionariosController",function(apiUrl, $scope, $http) {

    $scope.usuarios = [];

    function buscarUsuarios() {
        $http.get(apiUrl + "/funcionarios/buscar").then(function(usuarios) {
            $scope.usuarios = usuarios.data;
        });
    }

    buscarUsuarios();
});