package com.malomnogo.netologytest.ui.main

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.malomnogo.netologytest.R
import com.malomnogo.netologytest.model.ui.NetologyUiData
import kotlinx.android.synthetic.main.item_netology_list.view.*
import kotlinx.android.synthetic.main.item_netology_list_header.view.*

class MainAdapter(private val uiData: List<NetologyUiData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            HEADER -> HEADER
            else -> ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_netology_list_header, parent, false)
                HeaderViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_netology_list, parent, false)
                MainViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.onBind()
            //POSITION -1 FOR HEADER
            is MainViewHolder -> holder.onBind(uiData[position - 1])
        }
    }

    override fun getItemCount(): Int {
        //HEADER
        return uiData.size + 1
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(data: NetologyUiData) {
            with(itemView) {
                item_netology_list_tv_title.text = data.title
                item_netology_list_tv_desc.text = context.getString(R.string.courses, data.courses)
            }
        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val context = itemView.context
        fun onBind() {
            val spannableString1 = SpannableString(context.getString(R.string.learn))
            spannableString1.setSpan(
                ForegroundColorSpan(Color.BLACK),
                0,
                spannableString1.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            val spannableString2 =
                SpannableString(" " + context.getString(R.string.actual_topics))
            spannableString2.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(context, R.color.teal_200)),
                0,
                spannableString2.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            with(itemView) {
                item_netology_list_header_tv_header.text = spannableString1
                item_netology_list_header_tv_header.append(spannableString2)
            }

        }
    }

    companion object {
        const val HEADER = 0
        const val ITEM = 1
    }

}