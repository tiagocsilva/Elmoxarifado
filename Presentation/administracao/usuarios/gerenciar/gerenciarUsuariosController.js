app.controller("gerenciarUsuariosController",function($scope, $http) {

    $scope.usuarios = [];

    function buscarUsuarios() {
        $http.get("http://localhost:8080/funcionarios/buscar").then(function(usuarios) {
            $scope.usuarios = usuarios.data;
        });
    }

    buscarUsuarios();
});