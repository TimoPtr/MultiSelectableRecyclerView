package timoptr.multiselectablelist.sample.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import timoptr.multiselectablelist.sample.R
import timoptr.multiselectablelist.sample.viewmodel.GitRepositoryViewModel
import timoptr.multiselectablelist.adapter.SelectableAdapter


/**
 * Created by timoptr on 03/12/2017.
 */
class GithubAdapter(selectionMode: Selection) : SelectableAdapter<GitRepositoryViewModel, SelectableAdapter.SelectableViewHolderBinding<GitRepositoryViewModel>>(object : DiffUtil.ItemCallback<GitRepositoryViewModel>() {
    override fun areItemsTheSame(oldItem: GitRepositoryViewModel, newItem: GitRepositoryViewModel): Boolean =
            oldItem == newItem


    override fun areContentsTheSame(oldItem: GitRepositoryViewModel, newItem: GitRepositoryViewModel): Boolean =
            oldItem.name == newItem.name && oldItem.id == newItem.id && oldItem.isSelected == newItem.isSelected

}, selectionMode) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectableViewHolderBinding<GitRepositoryViewModel> =
            SelectableViewHolderBinding(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.item_repo, parent, false))

}