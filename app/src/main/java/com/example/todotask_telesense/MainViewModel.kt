package com.example.todotask_telesense

import android.view.View
import androidx.databinding.BaseObservable
import androidx.fragment.app.commit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.fragment.app.Fragment

class MainViewModel : BaseObservable() {


    fun onCompletedBtnPress(){

        val fm =
        val tr = fm.beginTransaction()
        tr.add(R.id.frame_main, fragment)
        tr.commitAllowingStateLoss()
        curFragment = fragment
    }


}