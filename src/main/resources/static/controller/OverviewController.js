angular
    .module('aircraftFactoryConfigurationApp')
    .controller(
        'OverviewController',
        ['$scope', 'SelectedConfigurationFactory', 'BackendApiService', '$location',
          function ($scope, SelectedConfigurationFactory, BackendApiService, $location) {
            $scope.data = {
              airCraftConfiguration: {
                economicSeats: 0,
                businessSeats: 0,
                description: '',
                totalPrice: 0,
                features: [],
                modelName: ''
              }
            };

            const selectedConfiguration = SelectedConfigurationFactory.getSelectedConfiguration();
            BackendApiService.getConfigurationOverview(selectedConfiguration)
                .then((airCraftConfiguration) => {
                  $scope.data.airCraftConfiguration = airCraftConfiguration;
                })
                .catch(err => console.error(err));

            $scope.back = () => {
              SelectedConfigurationFactory.clear();
              $location.url('/configuration');
            };
          }]);
