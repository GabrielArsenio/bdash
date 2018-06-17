(function () {
    'use strict'

    angular.module('app')
        .controller('FuncionarioListController', FuncionarioListController);

    FuncionarioListController.$inject = ['FuncionarioService', 'DialogBuilder']

    function FuncionarioListController(FuncionarioService, DialogBuilder) {
        var vm = this;
        vm.data = {};
        vm.filtro = '';
        vm.page = {
            number: 1,
            size: '15'
        }

        vm.resetFiltro = function () {
            vm.filtro = '';
            vm.load();
        }

        vm.goToPage = function (page) {
            vm.page.number = page;
            vm.load();
        }

        vm.load = function () {
            FuncionarioService.findAll(vm.filtro, vm.page)
                .then(function (dados) {
                    vm.data = dados
                });
        }

        vm.excluir = function (item) {
            DialogBuilder.confirm('Tem certeza que deseja remover o registro?')
                .then(function (result) {
                    if (result.value) {
                        FuncionarioService.remove(item.id)
                            .then(function () {
                                vm.load();
                                DialogBuilder.message('Registro excluído com sucesso!');
                            });
                    } else {
                        DialogBuilder.message({
                            title: 'Exclusão cancelada pelo usuário!',
                            type: 'error'
                        });
                    }
                });
        };

        vm.load();
    }
})();