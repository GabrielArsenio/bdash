(function () {
    'use strict'

    angular.module('app')
        .controller('FuncionarioFormController', FuncionarioFormController);

    FuncionarioFormController.$inject = ['FuncionarioService', '$state', '$stateParams', 'DialogBuilder'];

    function FuncionarioFormController(FuncionarioService, $state, $stateParams, DialogBuilder) {
        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Novo Funcionario';
        vm.salvar = salvar;

        if ($stateParams.id) {
            FuncionarioService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Funcionario';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                FuncionarioService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("funcionariosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                FuncionarioService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("funcionariosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();