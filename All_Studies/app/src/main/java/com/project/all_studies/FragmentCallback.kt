package com.project.all_studies

import android.os.Bundle

interface FragmentCallback {
    enum class FragmentItem {
        MAIN_VIEW, STUDY_DETAILS, ITEM_RESERVATION,
        ITEM_PLACE, ITEM_FAVORITE, ITEM_FAVORITE_DETAILS
    }

    fun onFragmentSelected(item: FragmentItem, bundle: Bundle?)
}