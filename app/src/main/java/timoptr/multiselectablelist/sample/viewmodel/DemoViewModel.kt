package timoptr.multiselectablelist.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timoptr.multiselectablelist.sample.repository.VehicleRepository

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 1.0
 * on 24/11/2018 for MultiSelectableRecycleListView with IntelliJ IDEA.
 */
class DemoViewModel(private val vehicleRepository: VehicleRepository) : ViewModel() {

    class Factory(private val vehicleRepository: VehicleRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = DemoViewModel(vehicleRepository) as T
    }

    val motorcycles = vehicleRepository.getMotorcycles()

    val cars = vehicleRepository.getCars()
}