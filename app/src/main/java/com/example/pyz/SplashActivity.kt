package com.example.pyz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pyz.base.MvvmBaseActivity
import com.example.pyz.databinding.ActivitySplashBinding
import com.example.pyz.viewmodel.SplashViewModel

class SplashActivity : MvvmBaseActivity<SplashViewModel,ActivitySplashBinding>()  {

    override fun initData() {
        mBinding.tvSkip.text = "3秒"
        mBinding.tvSkip.setOnClickListener(OnClickListener {

        })
    }

    override fun initView() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun observableListen() {
        mViewModel.showLoadingObservable.observe(this) {

        }
        mViewModel.hideLoadingObservable.observe(this){

        }
    }

}