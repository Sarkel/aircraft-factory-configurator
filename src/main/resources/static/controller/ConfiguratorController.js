angular
    .module('aircraftFactoryConfigurationApp')
    .controller(
        'ConfiguratorController',
        ['$scope', 'BackendApiService', 'SelectedConfigurationFactory', '$location',
          function ($scope, BackendApiService, SelectedConfigurationFactory, $location) {
            $scope.configurationOptions = {
              modelOptions: [],
              featureOptions: []
            };

            $scope.flags = {
              allFeaturesSelected: false,
              selectedModel: null,
              businessSeats: 0,
              economicSeats: 0,
            };

            BackendApiService.getConfigurationOptions()
                .then((configurationOptions) => {
                  $scope.configurationOptions = configurationOptions;
                })
                .catch(err => console.error(err));

            $scope.calculateConfiguration = () => {
              SelectedConfigurationFactory.setSelectedConfiguration({
                modelId: $scope.flags.selectedModel.id,
                featureIds: $scope.configurationOptions
                    .featureOptions
                    .filter(f => f.selected)
                    .map(f => f.id),
                businessSeats: $scope.flags.businessSeats,
                economicSeats: $scope.flags.economicSeats,
              });
              $location.url('/overview');
            };

            $scope.selectAllFeatures = () => {
              $scope.flags.allFeaturesSelected = !$scope.flags.allFeaturesSelected;

              for (const fo of $scope.configurationOptions.featureOptions) {
                fo.selected = $scope.flags.allFeaturesSelected;
              }
            };

            $scope.selectFeature = (feature) => {
              $scope.flags.allFeaturesSelected = false;
              feature.selected = !feature.selected;
            };

            $scope.selectModel = (model) => {
              $scope.flags.selectedModel = model;
              for (const mo of $scope.configurationOptions.modelOptions) {
                mo.selected = mo.id === model.id
              }
            };
          }]);
