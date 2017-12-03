package com.bioserenity.wemu.utils

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by timoptr on 01/12/2017.
 * Inspiration from https://medium.com/@maydin/multi-and-single-selection-in-recyclerview-d29587a7dee2
 */
abstract class SelectableViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    lateinit var item: SelectableItem
    lateinit var selectableListener: OnItemSelectedListener

    init {
        view.setOnClickListener {
            item.isSelected.set(!item.isSelected.get())
            selectableListener.onItemSelected(item)
        }
    }

    interface OnItemSelectedListener {
        fun onItemSelected(item: SelectableItem)
    }
}