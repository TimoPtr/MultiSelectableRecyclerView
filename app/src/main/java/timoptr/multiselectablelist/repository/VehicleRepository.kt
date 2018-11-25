package timoptr.multiselectablelist.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import timoptr.multiselectablelist.viewmodel.VehicleViewModel

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 25/11/2018 for MultiSelectableRecycleListView with IntelliJ IDEA.
 */
interface VehicleRepository {
    fun getMotorcycles(): LiveData<PagedList<VehicleViewModel>>
    fun getCars(): LiveData<PagedList<VehicleViewModel>>
}