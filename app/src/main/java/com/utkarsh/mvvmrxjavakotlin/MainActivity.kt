package com.utkarsh.mvvmrxjavakotlin

import TicketResponseModel
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.booksearchrxjavakotlin.R
import com.utkarsh.mvvmrxjavakotlin.adapter.TicketListAdapter
import com.utkarsh.mvvmrxjavakotlin.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var userToken:String;

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var ticketListAdapter: TicketListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getIntentData()
        initRecyclerView()
        loadAPIData()
    }

    private fun getIntentData() {
        userToken = intent.getStringExtra("userToken")
    }

    /*
    * Initialization of recycler view done
    * in this method
    *
    * */
    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            ticketListAdapter = TicketListAdapter()
            adapter = ticketListAdapter
        }
    }

    /*
    * this method load data from api
    * View model car about all this
    *
    * */
    private fun loadAPIData() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getBookListObserver().observe(this, Observer<TicketResponseModel> {
            if (it != null) {
                if(it.status.equals("1")){
                    //update adapter...
                    ticketListAdapter.ticketListData = it.oData.ticketsList
                    ticketListAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                }

            } else {
                Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall(userToken)
    }
}