package com.utkarsh.mvvmrxjavakotlin.viewmodel

import LoginResponseModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utkarsh.mvvmrxjavakotlin.network.RetroInstance
import com.utkarsh.mvvmrxjavakotlin.network.RetroService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginActivityViewModel : ViewModel() {
    var loginData: MutableLiveData<LoginResponseModel> = MutableLiveData()

    fun getLoginObserver(): MutableLiveData<LoginResponseModel> {
        return loginData
    }

    /*
    * Call of api done
    * In the below mentioned
    * */
    fun makeApiCall(email: String,pass:String,user_device_token:String
                    ,user_device_type:String,device_cart_id:String) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        retroInstance.doLogin(
            email,
            pass,
            user_device_token,
            user_device_type,
            device_cart_id
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getLoginData())

    }

    /*
    * method tell us our response is success
    * or false if api call not happens then return
    * null data therwise return same data
    *
    * */
    private fun getLoginData(): Observer<LoginResponseModel> {
        return object : Observer<LoginResponseModel> {
            override fun onComplete() {
                //hide progress indicator .
            }

            override fun onError(e: Throwable) {
                loginData.postValue(null)
            }

            override fun onNext(t: LoginResponseModel) {
                loginData.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
                //start showing progress indicator.
            }
        }
    }
}