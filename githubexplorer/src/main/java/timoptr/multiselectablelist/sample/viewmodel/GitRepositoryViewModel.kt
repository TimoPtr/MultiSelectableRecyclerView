package timoptr.multiselectablelist.sample.viewmodel

import androidx.databinding.ObservableBoolean
import timoptr.multiselectablelist.util.SelectableItem

/**
 * Created by timothynibeaudeau on 03/12/2017.
 */
class GitRepositoryViewModel(override val id: Int, val name: String) : SelectableItem {
    override var isSelected = ObservableBoolean(false)
}