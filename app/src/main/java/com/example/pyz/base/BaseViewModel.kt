package com.example.pyz.base

import android.database.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel :ViewModel() {

     var showLoadingObservable : MutableLiveData<String> = MutableLiveData("加载中")

     var hideLoadingObservable : MutableLiveData<String> = MutableLiveData()




}