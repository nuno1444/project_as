package com.project.all_studies

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment2 : Fragment() {
    val TAG = "MyStudyView"

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
        val view: View = inflater.inflate(R.layout.fragment_2, container, false)

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        val recyvlew : RecyclerView =view.findViewById(R.id.myStudyList)
        recyvlew.layoutManager = layoutManager

        val adapter = StudyAdapter()

        adapter.items.add(Study("All-study","이거는 allstudy project 입니다."))
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
    }
 
}