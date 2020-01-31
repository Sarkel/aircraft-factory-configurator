angular
    .module('aircraftFactoryConfigurationApp')
    .service('BackendApiService', ['$http', function ($http) {
      this.getConfigurationOptions = () => {
        return $http.get('/api/configuration')
            .then(res => res.data);
      };

      this.getConfigurationOverview = (airCraftConfigurationSelection) => {
        return $http.post('/api/air-craft/generate-overview', airCraftConfigurationSelection)
            .then(res => res.data);
      }
    }]);
