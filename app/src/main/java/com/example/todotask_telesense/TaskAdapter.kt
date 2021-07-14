package com.example.todotask_telesense

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todotask_telesense.database.Task

class TaskAdapter(val taskList: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]

        holder.txtName.text = task.name.toString()
        if (task.isComplete == true) {
            holder.txtIsComplete.text = "Completed"
        } else {
            holder.txtIsComplete.text = "Incompleted"
        }
    }

    override fun getItemCount() = taskList.size

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.tv_taskitem_name)
        val txtIsComplete: TextView = itemView.findViewById(R.id.tv_taskitem_isComplete)
    }
}