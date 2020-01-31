angular
    .module('aircraftFactoryConfigurationApp')
    .factory('SelectedConfigurationFactory', [function () {
      let _selectedConfiguration = {
        modelId: '',
        featureIds: [],
        businessSeats: 0,
        economicSeats: 0,
      };

      const _setSelectedConfiguration = (selectedConfiguration) => {
        _selectedConfiguration = selectedConfiguration;
      };

      const _getSelectedConfiguration = () => _selectedConfiguration;

      const _clear = () => {
        _selectedConfiguration = {
          modelId: '',
          featureIds: [],
          businessSeats: 0,
          economicSeats: 0,
        }
      };

      return {
        setSelectedConfiguration: _setSelectedConfiguration,
        getSelectedConfiguration: _getSelectedConfiguration,
        clear: _clear
      }
    }]);
