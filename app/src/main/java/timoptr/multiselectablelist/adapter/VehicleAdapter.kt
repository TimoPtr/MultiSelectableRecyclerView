package timoptr.multiselectablelist.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import timoptr.multiselectablelist.BR
import timoptr.multiselectablelist.R
import timoptr.multiselectablelist.databinding.ItemVehicleBinding
import timoptr.multiselectablelist.viewmodel.VehicleViewModel

/**
 * Created by timoptr on 03/12/2017.
 */
class VehicleAdapter(override val selectionMode: Selection) : SelectableAdapter<VehicleAdapter.ViewHolder, VehicleViewModel>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(DataBindingUtil.bind(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_vehicle, parent, false)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (position > -1) {
            val device = items[position]
            holder.item = device //set Selectable Item
            with(holder.binding) {
                setVariable(BR.viewModel, device)
            }
        }
    }

    fun addVehicle(vm: VehicleViewModel) {
        val position = items.size
        items.add(vm)
        notifyItemInserted(position)
    }

    inner class ViewHolder(val binding: ItemVehicleBinding) :
            SelectableAdapter.ViewHolder(binding.root)

    class VehicleLayoutManager(context: Context) : LinearLayoutManager(context) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
}