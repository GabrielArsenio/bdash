(function () {
    'use strict'

    angular.module('app')
        .controller('LojaListController', LojaListController);

    LojaListController.$inject = ['LojaService', 'DialogBuilder']

    function LojaListController(LojaService, DialogBuilder) {
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
            LojaService.findAll(vm.filtro, vm.page)
                .then(function (dados) {
                    vm.data = dados
                });
        }

        vm.excluir = function (item) {
            DialogBuilder.confirm('Tem certeza que deseja remover o registro?')
                .then(function (result) {
                    if (result.value) {
                        LojaService.remove(item.id)
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