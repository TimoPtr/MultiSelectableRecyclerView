package timoptr.multiselectablelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_demo.*
import timoptr.multiselectablelist.adapter.SelectableAdapter
import timoptr.multiselectablelist.adapter.VehicleAdapter
import timoptr.multiselectablelist.viewmodel.VehicleViewModel

/**
 * Created by timoptr on 03/12/2017.
 */
class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        initListMulti()
        initListSingle()
    }

    private fun initListSingle() {
        val adapter = VehicleAdapter(SelectableAdapter.Selection.SINGLE)
        listSingle.adapter = adapter
        listSingle.layoutManager = VehicleAdapter.VehicleLayoutManager(this)
        listSingle.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.submitList(arrayListOf(
                VehicleViewModel("3008"),
                VehicleViewModel("C3"),
                VehicleViewModel("Focus"),
                VehicleViewModel("A1"),
                VehicleViewModel("DS4"),
                VehicleViewModel("Clio")
        ))
    }

    private fun initListMulti() {
        val adapter = VehicleAdapter(SelectableAdapter.Selection.MULTIPLE)
        listMulti.adapter = adapter
        listMulti.layoutManager = VehicleAdapter.VehicleLayoutManager(this)
        listMulti.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.submitList(arrayListOf(
                VehicleViewModel("R1", VehicleViewModel.Type.BIKE),
                VehicleViewModel("Bandit", VehicleViewModel.Type.BIKE),
                VehicleViewModel("Z1000", VehicleViewModel.Type.BIKE),
                VehicleViewModel("Speed triple", VehicleViewModel.Type.BIKE),
                VehicleViewModel("MT07", VehicleViewModel.Type.BIKE)
        ))
    }
}