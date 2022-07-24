package com.htetarkarzaw.codigotest3.common.activities

import androidx.recyclerview.widget.LinearLayoutManager
import com.htetarkarzaw.codigotest3.common.adapter.ChooserAdapter
import com.htetarkarzaw.codigotest3.common.base.BaseBottomSheet
import com.htetarkarzaw.codigotest3.common.delegate.ChooserDelegate
import com.htetarkarzaw.codigotest3.databinding.BsFragmentChooserBinding

class ChooserBottomSheetDialogFragment(private val delegate: ChooserDelegate,private val list:MutableList<String>,private val type:String) :
    BaseBottomSheet<BsFragmentChooserBinding>(BsFragmentChooserBinding::inflate) {
    private lateinit var adapter: ChooserAdapter
    override fun setupView() {
        super.setupView()
        dialog?.setCanceledOnTouchOutside(true)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = ChooserAdapter { clickItem(it) }.apply {
            binding.rvChooser.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            binding.rvChooser.adapter = this
        }
        adapter.submitList(list)
    }

    private fun clickItem(position: Int) {
        val item = adapter.getClickItem(position)
        delegate.onClickedItem(item,type)
        dismiss()
    }
}