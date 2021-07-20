package com.utkarsh.mvvmrxjavakotlin.activity

import LoginResponseModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.utkarsh.mvvmrxjavakotlin.MainActivity
import com.utkarsh.mvvmrxjavakotlin.R
import com.utkarsh.mvvmrxjavakotlin.utils.Utils
import com.utkarsh.mvvmrxjavakotlin.viewmodel.LoginActivityViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginActivityViewModel
    private var btnLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        bindListner()
    }


    private fun initView() {
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun bindListner() {
        btnLogin!!.setOnClickListener {
            if(etEmail.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter email.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(!Utils.isValidEmail(etEmail.text.toString())){
                Toast.makeText(this, "Please enter valid email.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(etPassword.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter password.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                loadAPIData()
            }
        }
    }


    /*
   * this method load data from api
   * View model car about all this
   *
   * */
    private fun loadAPIData() {
        viewModel = ViewModelProvider(this).get(LoginActivityViewModel::class.java)
        viewModel.getLoginObserver().observe(this, Observer<LoginResponseModel> {
            if (it != null) {
                if (it.status.equals("1")) {
                    //Send To Main Activity.
                    val intent = Intent(this, MainActivity::class.java)
                    // start your next activity
                    intent.putExtra("userToken",it.accessToken)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent)

                } else {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                }

            } else {
                Toast.makeText(this, getString(R.string.fetch_data), Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall(
            etEmail.text.toString().trim(),
            etPassword.text.toString().trim(), "hello", "android",
            "794d1f62ee4a97ce")
    }
}