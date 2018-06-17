(function () {
    'use strict'

    angular.module('app')
        .service('FuncionarioService', FuncionarioService);

    FuncionarioService.$inject = ['$http'];

    function FuncionarioService($http) {
        return {
            findAllOver: findAllOver,
            findAll: findAll,
            findById: findById,
            insert: insert,
            update: update,
            remove: remove
        }

        function findAllOver() {
            return $http.get('http://localhost:8080/api/funcionarios/all?order=nome')
                .then(function (response) {
                    return response.data;
                });
        }

        function findAll(filtro, page) {
            return $http.get(
                'http://localhost:8080/api/funcionarios' +
                '?page=' + page.number +
                '&size=' + page.size +
                '&filterField=nome' +
                '&filterValue=' + filtro)
                .then(function (response) {
                    return {
                        registros: response.data,
                        total: response.headers('X-Total-Lenght'),
                        pageSize: response.headers('X-Page-Size'),
                        pages: _calcPage(response.headers('X-Total-Lenght'), response.headers('X-Page-Size')),
                        currentPage: response.headers('X-Current-Page')
                    }
                });
        }

        function findById(id) {
            return $http.get('http://localhost:8080/api/funcionarios/' + id)
                .then(function (response) {
                    return response.data;
                });
        }

        function remove(id) {
            return $http.delete('http://localhost:8080/api/funcionarios/' + id)
                .then(function (response) {
                    return response.data;
                });
        }

        function update(registro) {
            return $http.put('http://localhost:8080/api/funcionarios/' + registro.id, registro)
                .then(function (response) {
                    return response.data;
                });
        }

        function insert(registro) {
            return $http.post('http://localhost:8080/api/funcionarios', registro)
                .then(function (response) {
                    return response.data;
                });
        }

        function _calcPage(totalRegistros, tamanhoPagina) {
            var pages = [];
            var num = totalRegistros / tamanhoPagina;
            var actual = 1;

            while (num > 0) {
                pages.push(actual++)
                num -= 1;
            }

            return pages;
        }
    }
})();