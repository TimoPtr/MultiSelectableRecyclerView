package timoptr.multiselectablelist.viewmodel

import androidx.databinding.ObservableBoolean
import timoptr.multiselectablelist.util.SelectableItem

/**
 * Created by timothynibeaudeau on 03/12/2017.
 */
class VehicleViewModel(override val id: Int, val name: String, val type: Type = Type.CAR) : SelectableItem {

    enum class Type {
        CAR,
        BIKE
    }

    override var isSelected = ObservableBoolean(false)
}