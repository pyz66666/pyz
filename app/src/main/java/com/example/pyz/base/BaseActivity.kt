package com.example.pyz.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected val TAG: String = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout()
        initView()
        initData()
    }

    abstract fun setContentLayout()

    //数据
    abstract fun initData()

    //UI
    abstract fun initView()

    abstract fun showLoading()

    abstract fun hideLoading()
}