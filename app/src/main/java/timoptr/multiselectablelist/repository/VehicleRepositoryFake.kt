package timoptr.multiselectablelist.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import timoptr.multiselectablelist.viewmodel.VehicleViewModel

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 24/11/2018 for MultiSelectableRecycleListView with IntelliJ IDEA.
 */
class VehicleRepositoryFake : VehicleRepository {

    override fun getMotorcycles(): LiveData<PagedList<VehicleViewModel>> {
        val motorcycles = listOf(
                VehicleViewModel(1, "R1", VehicleViewModel.Type.BIKE),
                VehicleViewModel(2, "Bandit", VehicleViewModel.Type.BIKE),
                VehicleViewModel(3, "Z1000", VehicleViewModel.Type.BIKE),
                VehicleViewModel(4, "Speed triple", VehicleViewModel.Type.BIKE),
                VehicleViewModel(5, "MT07", VehicleViewModel.Type.BIKE)
        )
        return LivePagedListBuilder(object : DataSource.Factory<Int, VehicleViewModel>() {
            override fun create(): DataSource<Int, VehicleViewModel> =
                    object : PositionalDataSource<VehicleViewModel>() {
                        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<VehicleViewModel>) {
                            callback.onResult(motorcycles, 0, motorcycles.size)
                        }

                        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<VehicleViewModel>) {
                            callback.onResult(motorcycles)
                        }
                    }

        }, motorcycles.size).build()
    }

    override fun getCars(): LiveData<PagedList<VehicleViewModel>> {
        val cars = listOf(
                VehicleViewModel(1, "3008"),
                VehicleViewModel(2, "C3"),
                VehicleViewModel(3, "Focus"),
                VehicleViewModel(4, "A1"),
                VehicleViewModel(5, "DS4"),
                VehicleViewModel(6, "Clio")
        )
        return LivePagedListBuilder(object : DataSource.Factory<Int, VehicleViewModel>() {
            override fun create(): DataSource<Int, VehicleViewModel> =
                    object : PositionalDataSource<VehicleViewModel>() {
                        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<VehicleViewModel>) {
                            callback.onResult(cars, 0, cars.size)
                        }

                        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<VehicleViewModel>) {
                            callback.onResult(cars)
                        }
                    }

        }, cars.size).build()
    }
}