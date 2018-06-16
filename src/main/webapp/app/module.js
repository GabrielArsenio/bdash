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
            });
    }
})();