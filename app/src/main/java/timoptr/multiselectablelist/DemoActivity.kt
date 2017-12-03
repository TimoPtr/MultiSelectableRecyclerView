package timoptr.multiselectablelist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
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
        listSingle.adapter = VehicleAdapter(SelectableAdapter.Selection.SINGLE)
        listSingle.layoutManager = VehicleAdapter.VehicleLayoutManager(this)
        listSingle.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        with(listSingle.adapter as VehicleAdapter) {
            addVehicle(VehicleViewModel("3008"))
            addVehicle(VehicleViewModel("C3"))
            addVehicle(VehicleViewModel("Focus"))
            addVehicle(VehicleViewModel("A1"))
            addVehicle(VehicleViewModel("DS4"))
            addVehicle(VehicleViewModel("Clio"))
        }
    }

    private fun initListMulti() {
        listMulti.adapter = VehicleAdapter(SelectableAdapter.Selection.MULTIPLE)
        listMulti.layoutManager = VehicleAdapter.VehicleLayoutManager(this)
        listMulti.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        with(listMulti.adapter as VehicleAdapter) {
            addVehicle(VehicleViewModel("R1", VehicleViewModel.Type.BIKE))
            addVehicle(VehicleViewModel("Bandit", VehicleViewModel.Type.BIKE))
            addVehicle(VehicleViewModel("Z1000", VehicleViewModel.Type.BIKE))
            addVehicle(VehicleViewModel("Speed triple", VehicleViewModel.Type.BIKE))
            addVehicle(VehicleViewModel("MT07", VehicleViewModel.Type.BIKE))
        }
    }
}