package com.utkarsh.mvvmrxjavakotlin.adapter

import TicketsListDataModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utkarsh.mvvmrxjavakotlin.utils.Utils
import com.bumptech.glide.Glide
import com.utkarsh.mvvmrxjavakotlin.R
import kotlinx.android.synthetic.main.recycler_list_row.view.*


class TicketListAdapter : RecyclerView.Adapter<TicketListAdapter.MyViewHolder>() {

    var ticketListData = ArrayList<TicketsListDataModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false)
        return MyViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(ticketListData[position])
    }
/*
* return size list Of total item
* */
    override fun getItemCount(): Int {
        return ticketListData.size
    }

    /*
    * Class for initializing the view of adapter
    * and after that set value to Recycler view
    *
    * */
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.tvTItle
        private val tvDesc = view.tvDesc
        private val btDay = view.btDay
        private val btHour = view.btHour
        private val btMin = view.btMin
        private val btSec = view.btSec
        private val ivIcon = view.ivIcon

        fun bind(data: TicketsListDataModel) {
            tvTitle.text = data.product_name
            tvDesc.text = data.campaigns_title
            btDay.text = Utils.calculateDay(data.campaigns_remaining_uts.toLong()).toString()
            btHour.text = Utils.calculateHours(data.campaigns_remaining_uts.toLong()).toString()
            btMin.text = Utils.calculateMin(data.campaigns_remaining_uts.toLong()).toString()
            btSec.text = Utils.calculateSec(data.campaigns_remaining_uts.toLong()).toString()

            val url = data.campaigns_image
            Glide.with(ivIcon)
                .load(url)
                .circleCrop()
                .into(ivIcon)
        }
    }


}