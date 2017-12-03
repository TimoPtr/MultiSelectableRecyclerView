package timoptr.multiselectablelist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bioserenity.wemu.utils.SelectableItem
import com.bioserenity.wemu.utils.SelectableViewHolder

/**
 * Created by timoptr on 01/12/2017.
 */
/**
 * To use this adapter you have to override/implement :
 * - override onBindViewHolder and call super.onBindViewHolder() after you set the item of the viewHolder
 *
 * What you can do :
 * - customize the ViewHolder by extending SelectableAdapter.ViewHolder
 * - use itemSelectedListener to listen on itemSelection
 * - selectionMode (MULTIPLE or SINGLE)
 * - get the list of the selectedItems
 *
 */
abstract class SelectableAdapter<T : SelectableAdapter.ViewHolder, V : SelectableItem>(open val selectionMode: Selection = Selection.MULTIPLE) : RecyclerView.Adapter<T>() {
    val items = ArrayList<V>()
    var itemSelectedListener: SelectableViewHolder.OnItemSelectedListener? = null

    enum class Selection {
        MULTIPLE,
        SINGLE
    }

    private val internalItemSelectionListener = object : SelectableViewHolder.OnItemSelectedListener {
        override fun onItemSelected(item: SelectableItem) {
            //if single browse devices and set all items.isSelected = false
            if (selectionMode == Selection.SINGLE) {
                items.filter { item != it }.forEach {
                    it.isSelected.set(false)
                }
            }
            itemSelectedListener?.onItemSelected(item)//Send outside of the adapter if need
        }
    }

    fun getSelectedItems(): List<V> = items.filter { it.isSelected.get() }

    override fun onBindViewHolder(holder: T, position: Int) {
        if (position > -1) {
            holder.selectableListener = internalItemSelectionListener
        }
    }

    open class ViewHolder(val view: View) : SelectableViewHolder(view)
}