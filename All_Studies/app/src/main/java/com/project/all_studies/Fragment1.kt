package com.project.all_studies

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment1 : Fragment() {
    val TAG = "MainView"

    var callback: FragmentCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentCallback) {
            callback = context
        } else {
            Log.d(TAG, "Activity is not FragmentCallback.")
        }
    }

    override fun onDetach() {
        super.onDetach()

        if (callback != null) {
            callback = null
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_1, container, false)

        val layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
       val recyvlew :RecyclerView =view.findViewById(R.id.studyView)
        recyvlew.layoutManager = layoutManager

       val adapter = StudyAdapter()

        adapter.items.add(Study("1211","23232444"))
        adapter.items.add(Study("Nuno","224555"))
        adapter.listener = object :StudyListItemClickListener{
            override fun onItemClick(holder: StudyAdapter.ViewHolder?, view: View?, position: Int) {
                //showToast("click list")

                if (callback != null) {
                    val bundle = Bundle()

                    callback!!.onFragmentSelected(FragmentCallback.FragmentItem.STUDY_DETAILS, bundle)
                }

            }
        }
        recyvlew.adapter = adapter
        return  view
       // return inflater.inflate(R.layout.fragment_1, container, false)


    }
    fun showToast(msg:String)
    {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
    }

}