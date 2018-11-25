package timoptr.multiselectablelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_demo.*
import timoptr.multiselectablelist.adapter.SelectableAdapter
import timoptr.multiselectablelist.adapter.VehicleAdapter
import timoptr.multiselectablelist.repository.VehicleRepositoryFake
import timoptr.multiselectablelist.viewmodel.DemoViewModel

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 1.0
 * on 03/12/2017 for MultiSelectableRecycleListView with IntelliJ IDEA.
 */
class DemoActivity : AppCompatActivity() {

    private lateinit var viewModel: DemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        viewModel = ViewModelProviders.of(this, DemoViewModel.Factory(VehicleRepositoryFake())).get(DemoViewModel::class.java)
        initListMulti()
        initListSingle()
    }

    private fun initListSingle() {
        val adapter = VehicleAdapter(SelectableAdapter.Selection.SINGLE)
        listSingle.adapter = adapter
        listSingle.layoutManager = VehicleAdapter.VehicleLayoutManager(this)
        listSingle.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        viewModel.cars.observe(this, Observer { carsPagedList ->
            adapter.submitList(carsPagedList)
        })
    }

    private fun initListMulti() {
        val adapter = VehicleAdapter(SelectableAdapter.Selection.MULTIPLE)
        listMulti.adapter = adapter
        listMulti.layoutManager = VehicleAdapter.VehicleLayoutManager(this)
        listMulti.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        viewModel.motorcycles.observe(this, Observer { motorcyclePagedList ->
            adapter.submitList(motorcyclePagedList)
        })
    }
}