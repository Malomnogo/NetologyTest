package com.malomnogo.netologytest.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.malomnogo.netologytest.R
import com.malomnogo.netologytest.model.ui.NetologyUiData
import com.malomnogo.netologytest.utils.Status
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dataUi.observe(viewLifecycleOwner) { initUi(it) }
        viewModel.state.observe(viewLifecycleOwner) { handleStatus(it.getContentIfNotHandled()) }
    }

    private fun handleStatus(status: Status?) {
        when (status) {
            Status.ERROR -> {
                fragment_main_pb.visibility = View.GONE
                showErrorResult(getString(R.string.status_error))
            }
            else -> {
                fragment_main_pb.visibility = View.GONE
            }
        }
    }

    private fun showErrorResult(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    private fun initUi(listNetologyData: List<NetologyUiData>) {
        fragment_main_rv_main_data.apply {
            adapter = MainAdapter(listNetologyData)
        }
    }
}