package timoptr.multiselectablelist.util


import androidx.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView

/**
 * Created by timoptr on 03/12/2017.
 */
@BindingAdapter("drawable")
fun setDrawable(view: ImageView, drawable: Drawable?) = view.setImageDrawable(drawable)
