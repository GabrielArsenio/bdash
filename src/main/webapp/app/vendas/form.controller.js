(function () {
    'use strict'

    angular.module('app')
        .controller('VendaFormController', VendaFormController);

    VendaFormController.$inject = ['VendaService', '$state', '$stateParams', 'DialogBuilder', 'LojaService', 'FuncionarioService'];

    function VendaFormController(VendaService, $state, $stateParams, DialogBuilder, LojaService, FuncionarioService) {
        var vm = this;
        vm.registro = {
            dataVenda: new Date(),
            itens: []
            // itens: [{nome: 'produto 1'}, { nome: 'Produto 2'}]
        };
        vm.error = {};
        vm.titulo = 'Nova Venda';
        vm.salvar = salvar;
        
        vm.lojas = [];
        vm.lojasFiltro = '';
        vm.lojasPage = {
            number: 1,
            size: '999'
        }

        vm.funcionarios = [];
        vm.funcionariosFiltro = '';
        vm.funcionariosPage = {
            number: 1,
            size: '999'
        }

        if ($stateParams.id) {
            VendaService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Venda';
                });
        }

        if (!vm.lojas.length) {
            LojaService.findAll(vm.lojasFiltro, vm.lojasPage)
                .then(function (dados) {
                    for (let registro of dados.registros) {
                        vm.lojas.push(registro)
                    }
                });
        }

        if (!vm.funcionarios.length) {
            FuncionarioService.findAll(vm.funcionariosFiltro, vm.funcionariosPage)
                .then(function (dados) {
                    for (let registro of dados.registros) {
                        vm.funcionarios.push(registro)
                    }
                });
        }

        vm.excluirItem = (item) => {
            var index = vm.registro.itens.indexOf(item);
            if (index > -1) {
                vm.registro.itens.splice(index, 1);
            }
        };

        function salvar() {
            if (!vm.registro.id) {
                VendaService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("vendasList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                VendaService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("vendasList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();