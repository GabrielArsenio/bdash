(function () {
    'use strict'

    angular.module('app')
        .controller('VendaListController', VendaListController);

    VendaListController.$inject = ['VendaService', 'DialogBuilder']

    function VendaListController(VendaService, DialogBuilder) {
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
            VendaService.findAll(vm.filtro, vm.page)
                .then(function (dados) {
                    vm.data = dados
                });
        }

        vm.excluir = function (item) {
            DialogBuilder.confirm('Tem certeza que deseja remover o registro?')
                .then(function (result) {
                    if (result.value) {
                        VendaService.remove(item.id)
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