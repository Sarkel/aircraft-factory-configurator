angular
    .module('aircraftFactoryConfigurationApp', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
      $routeProvider
          .when('/configurator', {
            templateUrl: 'configurator.html',
            controller: 'ConfiguratorController',
          })
          .when('/overview', {
            templateUrl: 'overview.html',
            controller: 'OverviewController'
          })
          .otherwise('/configurator');
    }]);

