app.controller("gerenciarEmprestimosController",function(apiUrl, $scope, $http) {

    $scope.emprestimos = [];

    function buscarEmprestimos() {        
        $http.get(apiUrl + "/emprestimos/buscar").then(function(emprestimos) {
            emprestimos = emprestimos.data;
            emprestimos.forEach(function(emp){
                emp.inicio = new Date(emp.inicio);
                emp.validade = new Date(emp.validade);
            });
            $scope.emprestimos = emprestimos;
        });
    }

    buscarEmprestimos();

    $scope.devolver = function(idFeramenta) {
        swal({   
            title: "Deolver Ferramenta",   
            text: "Tem certeza que deseja devolver esta ferramenta?",
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#CDCDCD",   
            confirmButtonText: "Devolver!",   
            cancelButtonText: "Cancelar",   
            closeOnConfirm: false,   
            closeOnCancel: true 
        }, function(isConfirm){   
            if (isConfirm) {     
                 $http.post(apiUrl + "/emprestimos/devolver/" + idFeramenta).then(function() {
                   
                    swal({   
                        title: "Devolvida!",   
                        text: "Ferramenta Devolvida com Sucesso!",
                        type: "success",   
                        showCancelButton: false,   
                        confirmButtonColor: "#CDCDCD",   
                        confirmButtonText: "OK",                             
                        closeOnConfirm: false,   
                        closeOnCancel: true}, function() {
                            location.reload();
                        });  
                });
        }}); 
    }
});