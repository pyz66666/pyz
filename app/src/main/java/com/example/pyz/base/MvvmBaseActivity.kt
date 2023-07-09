package com.example.pyz.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

open abstract class MvvmBaseActivity<VM : ViewModel,DB : ViewBinding>:BaseActivity() {
    open lateinit var mBinding : DB
    open lateinit var mViewModel : VM
    override fun setContentLayout() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val vbClass: Class<DB> = type!!.actualTypeArguments[1] as Class<DB>
            val method = vbClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
            mBinding = method.invoke(this, layoutInflater)!! as DB
            setContentView(mBinding.root)
            mViewModel = ViewModelProvider(this)[type!!.actualTypeArguments[1] as Class<VM>]
            for (i in 0 until  type!!.actualTypeArguments.size){
                Log.v("测试", type!!.actualTypeArguments[i].toString())
            }
        }
        /**
         *  (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
         *  这个方法获取的是该类下面的没有实例的泛型类的类型，按照顺序来
         *  2023-07-09 23:05:06.961  9431-9431  测试  V  class com.example.pyz.viewmodel.SplashViewModel
         *  2023-07-09 23:05:06.961  9431-9431  测试  V  class com.example.pyz.databinding.ActivitySplashBinding
         *  https://www.codenong.com/47418161/
         *  https://blog.csdn.net/weixin_45359574/article/details/105559327
         * */

    }

    abstract fun observableListen()

}