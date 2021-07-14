package com.example.todotask_telesense

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todotask_telesense.database.Task
import com.example.todotask_telesense.database.TaskDB
import kotlin.coroutines.coroutineContext

class ListAllTaskFragment : Fragment() {

    companion object {
        fun newInstance() = ListAllTaskFragment()
    }

    private lateinit var viewModel: ListAllTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        val view = inflater.inflate(R.layout.list_all_task_fragment, container, false)
        val db = Room.databaseBuilder(view.context, TaskDB::class.java, "Task2.db")
            .allowMainThreadQueries()
            .build()
        val taskDAO = db.taskDAO()
        var taskList = taskDAO.getAll()

        val task: Task = Task("Task1", false)
        taskList += task

        val adapterFull = TaskAdapter(taskList)
//        val adapterComplete = TaskAdapter(taskListCompleted)


        val rcv = view.findViewById<RecyclerView>(R.id.rcv_alltask)
        rcv.adapter = adapterFull
        rcv.layoutManager = LinearLayoutManager(view.context)
        rcv.setHasFixedSize(true)



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListAllTaskViewModel::class.java)
        // TODO: Use the ViewModel
    }

}