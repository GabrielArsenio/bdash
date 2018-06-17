(function () {
    angular.module('app', [
        'ui.router'
    ]);

    angular.module('app').config(AppConfig);

    AppConfig.$inject = ['$stateProvider'];

    function AppConfig($stateProvider) {
        $stateProvider
            .state({
                name: 'produtosList',
                url: '/produtos',
                templateUrl: '/views/produtos/list.html',
                controller: 'ProdutoListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'produtosNovo',
                url: '/produtos/novo',
                templateUrl: '/views/produtos/form.html',
                controller: 'ProdutoFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'produtosEditar',
                url: '/produtos/{id}',
                templateUrl: '/views/produtos/form.html',
                controller: 'ProdutoFormController',
                controllerAs: 'vm'
            })


            .state({
                name: 'funcionariosList',
                url: '/funcionarios',
                templateUrl: '/views/funcionarios/list.html',
                controller: 'FuncionarioListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'funcionariosNovo',
                url: '/funcionarios/novo',
                templateUrl: '/views/funcionarios/form.html',
                controller: 'FuncionarioFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'funcionariosEditar',
                url: '/funcionarios/{id}',
                templateUrl: '/views/funcionarios/form.html',
                controller: 'FuncionarioFormController',
                controllerAs: 'vm'
            })
            ;
    }
})();