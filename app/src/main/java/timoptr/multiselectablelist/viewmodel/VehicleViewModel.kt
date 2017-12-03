package timoptr.multiselectablelist.viewmodel

import android.databinding.ObservableBoolean
import com.bioserenity.wemu.utils.SelectableItem

/**
 * Created by timothynibeaudeau on 03/12/2017.
 */
class VehicleViewModel(val name: String, val type: Type = Type.CAR) : SelectableItem {
    enum class Type {
        CAR,
        BIKE
    }

    override var isSelected = ObservableBoolean(false)
}