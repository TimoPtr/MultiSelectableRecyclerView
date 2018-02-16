package timoptr.multiselectablelist.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import timoptr.multiselectablelist.R
import timoptr.multiselectablelist.viewmodel.VehicleViewModel

/**
 * Created by timoptr on 03/12/2017.
 */
class VehicleAdapter(selectionMode: Selection) : SelectableAdapter<VehicleViewModel, SelectableAdapter.SelectableViewHolderBinding>(object :DiffCallback<VehicleViewModel>() {
    override fun areItemsTheSame(oldItem: VehicleViewModel, newItem: VehicleViewModel): Boolean =
            oldItem == newItem


    override fun areContentsTheSame(oldItem: VehicleViewModel, newItem: VehicleViewModel): Boolean =
            oldItem.name == newItem.name && oldItem.type == newItem.type

},selectionMode) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectableViewHolderBinding =
            SelectableViewHolderBinding(DataBindingUtil.bind(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_vehicle, parent, false))!!)

    class VehicleLayoutManager(context: Context) : LinearLayoutManager(context) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
}