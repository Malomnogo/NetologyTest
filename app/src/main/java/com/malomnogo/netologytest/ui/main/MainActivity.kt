package com.malomnogo.netologytest.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.malomnogo.netologytest.R
import com.malomnogo.netologytest.model.ui.NetologyUiData
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.observe
import com.malomnogo.netologytest.utils.Status

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.dataUi.observe(this) { initUi(it) }
        viewModel.state.observe(this) { handleStatus(it.getContentIfNotHandled()) }
    }

    private fun handleStatus(status: Status?) {
        when (status) {
            Status.ERROR -> {
                activity_main_pb.visibility = View.GONE
                showErrorResult(getString(R.string.status_error))
            }
            else -> {
                activity_main_pb.visibility = View.GONE
            }
        }
    }

    private fun showErrorResult(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun initUi(listNetologyData: List<NetologyUiData>) {
        activity_main_rv_main_data.apply {
            adapter = MainAdapter(listNetologyData)
        }
    }

}