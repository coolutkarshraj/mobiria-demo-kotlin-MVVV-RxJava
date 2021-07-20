package com.utkarsh.mvvmrxjavakotlin.viewmodel

import TicketResponseModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utkarsh.mvvmrxjavakotlin.network.RetroInstance
import com.utkarsh.mvvmrxjavakotlin.network.RetroService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel : ViewModel() {
    var ticketList: MutableLiveData<TicketResponseModel> = MutableLiveData()

    fun getBookListObserver(): MutableLiveData<TicketResponseModel> {
        return ticketList
    }

    /*
    * Call of api done
    * In the below mentioned
    * */
    fun makeApiCall(userToken: String) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        retroInstance.getAllTicket(
            userToken,
            "0",
            "1"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getAllTicketList())

    }

    /*
    * method tell us our response is success
    * or false
    *
    * */
    private fun getAllTicketList(): Observer<TicketResponseModel> {
        return object : Observer<TicketResponseModel> {
            override fun onComplete() {
                //hide progress indicator .
            }

            override fun onError(e: Throwable) {
                ticketList.postValue(null)
            }

            override fun onNext(t: TicketResponseModel) {
                ticketList.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
                //start showing progress indicator.
            }
        }
    }
}