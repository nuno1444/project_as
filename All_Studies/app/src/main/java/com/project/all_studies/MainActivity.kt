package com.project.all_studies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mypage.*
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(),FragmentCallback {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
/*
        btn_logout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            auth?.signOut()
        }*/

        with(supportFragmentManager.beginTransaction()){
            val fragment1= Fragment1()
            replace(R.id.container,fragment1)
            commit()
        }
        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.tab1 ->{
                    with(supportFragmentManager.beginTransaction()){
                        val fragment1= Fragment1()
                        replace(R.id.container,fragment1)
                        commit()
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.tab2 ->{
                    with(supportFragmentManager.beginTransaction()){
                        val fragment2= Fragment2()
                        replace(R.id.container,fragment2)
                        commit()
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.tab3 ->{
                    with(supportFragmentManager.beginTransaction()){
                        val fragment3= Fragment3()
                        replace(R.id.container,fragment3)
                        commit()
                    }
                    return@setOnItemSelectedListener true
                }

            }
            return@setOnItemSelectedListener false
        }
    }

    override fun onFragmentSelected(item: FragmentCallback.FragmentItem, bundle: Bundle?) {
        var fragment: Fragment
        fragment = StudyDetailsFragment.newInstance(1, "1")
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment!!).commit()
    }

}