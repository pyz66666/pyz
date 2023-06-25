package com.example.pyz.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

open abstract class MvvmBaseActivity<DB : ViewBinding>:BaseActivity() {
    private lateinit var mBinding : DB


    override fun setContentLayout() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val vbClass: Class<DB> = type!!.actualTypeArguments[0] as Class<DB>
            val method = vbClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
            mBinding = method.invoke(this, layoutInflater)!! as DB
            setContentView(mBinding.root)
        }
    }

}