package com.project.all_studies

import android.view.View

interface StudyListItemClickListener {
    fun onItemClick(holder: StudyAdapter.ViewHolder?, view: View?, position:Int)
}