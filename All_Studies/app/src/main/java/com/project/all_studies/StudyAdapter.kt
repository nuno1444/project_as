package com.project.all_studies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_2.view.*
import kotlinx.android.synthetic.main.stduy_view.view.*

class StudyAdapter : RecyclerView.Adapter<StudyAdapter.ViewHolder>() {
    lateinit var listener: StudyListItemClickListener
    var items = ArrayList<Study>()

    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.stduy_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }
    inner class  ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener {

                listener?.onItemClick(this, itemView, adapterPosition)
            }
        }
        fun setItem(item:Study){
            itemView.studyName.text = item.study_name
          //  itemView.textView2.text = item.study_explian
        }
    }

}