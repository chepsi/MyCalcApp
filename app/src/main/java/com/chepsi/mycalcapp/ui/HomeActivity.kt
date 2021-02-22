package com.chepsi.mycalcapp.ui

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.chepsi.mycalcapp.R
import com.chepsi.mycalcapp.databinding.ActivityHomeBinding
import com.chepsi.mylibrary.Calculator
import com.google.android.material.snackbar.Snackbar

class HomeActivity: AppCompatActivity(), ServiceConnection {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var calculator: Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        attachClickListerners()
    }

    private fun attachClickListerners(){
        binding.btnAdd.setOnClickListener {
            try {
                val result = calculator.add(getVariableOne(),getVariableTwo())
                setAnswer(result.toString())
            }catch (e: RemoteException){
                Log.e("Error: ", e.stackTrace.toString())
            }
        }

        binding.btnMultiply.setOnClickListener {
            try {
                val result = calculator.multiply(getVariableOne(),getVariableTwo())
                setAnswer(result.toString())
            }catch (e: RemoteException){
                Log.e("Error: ", e.stackTrace.toString())
            }
        }

        binding.btnMinus.setOnClickListener {
            try {
                val result = calculator.minus(getVariableOne(),getVariableTwo())
                setAnswer(result.toString())
            }catch (e: RemoteException){
                Log.e("Error: ", e.stackTrace.toString())
            }
        }

        binding.btnDivide.setOnClickListener {
            try {
                val result = calculator.divide(getVariableOne(),getVariableTwo())
                setAnswer(result.toString())
            }catch (e: RemoteException){
                Log.e("Error: ", e.stackTrace.toString())
            }
        }
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        calculator = Calculator.Stub.asInterface(service)
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        //ToDO
    }

    override fun onStart() {
        super.onStart()
        bindService(Intent(".domain.CalcService").setPackage("com.chepsi.mycalcapp"), this, BIND_AUTO_CREATE)
    }

    fun setAnswer(result: String){
        binding.tilResult.editText?.setText(result)
    }

    fun getVariableOne() = binding.tilVariableOne.editText?.text.toString().trim().toInt()
    fun getVariableTwo() = binding.tilVariableTwo.editText?.text.toString().trim().toInt()

}