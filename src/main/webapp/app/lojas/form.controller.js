(function () {
    'use strict'

    angular.module('app')
        .controller('LojaFormController', LojaFormController);

    LojaFormController.$inject = ['LojaService', '$state', '$stateParams', 'DialogBuilder'];

    function LojaFormController(LojaService, $state, $stateParams, DialogBuilder) {
        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Nova Loja';
        vm.salvar = salvar;

        if ($stateParams.id) {
            LojaService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Loja';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                LojaService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("lojasList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                LojaService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("lojasList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();