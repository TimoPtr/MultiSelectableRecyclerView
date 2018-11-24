package timoptr.multiselectablelist.util

import androidx.databinding.ObservableBoolean


/**
 * Created by timoptr on 01/12/2017.
 */

/**
 * Interface to allow selection on an Item,
 * your item need to implement this interface to be use in [SelectableAdapter]
 */
interface SelectableItem {
    /**
     * Observable on selection, can be use in XML to set the selection status if needed
     */
    var isSelected: ObservableBoolean
}

/**
 * Listener use to be notify on item selection
 */
interface OnItemSelectedListener {
    fun onItemSelected(item: SelectableItem)
}