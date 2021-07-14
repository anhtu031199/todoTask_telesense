package com.example.todotask_telesense

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.room.*
import com.example.todotask_telesense.database.Task
import com.example.todotask_telesense.database.TaskDB
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var curFragment: Fragment? = null
    var isShow: Boolean = true
    ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_option = findViewById(R.id.btn_option) as FloatingActionButton
        val btn_add = findViewById(R.id.btn_add) as FloatingActionButton
        val btn_complete = findViewById(R.id.btn_completed) as FloatingActionButton
        btn_option.setOnClickListener() {
            isShow = !isShow
            if (isShow) {
                btn_option.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                btn_add.visibility = View.INVISIBLE
                btn_complete.visibility = View.INVISIBLE
            } else {
                btn_option.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                btn_add.visibility = View.VISIBLE
                btn_complete.visibility = View.VISIBLE
            }
        }


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ListAllTaskFragment>(R.id.frame_main)
            }
        }
//        val listAllTask = ListAllTaskFragment()
//        addFragment(listAllTask)


    }

    fun addFragment(fragment: Fragment?) {
        if (fragment == null) return
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(R.id.frame_main, fragment)
        tr.commitAllowingStateLoss()
        curFragment = fragment
    }


}