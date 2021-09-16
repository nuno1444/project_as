package com.project.all_studies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        btn_logout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            auth?.signOut()

        }

        with(supportFragmentManager.beginTransaction()){
            val fragment1= Fragment1()
            replace(R.id.container,fragment1)
            commit()
        }
        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId)
            {
                R.id.tab1 ->{
                    with(supportFragmentManager.beginTransaction()){
                        val fragment1= Fragment1()
                        replace(R.id.container,fragment1)
                        commit()
                    }
                    return@setOnNavigationItemReselectedListener
                }
                R.id.tab2 ->{
                    with(supportFragmentManager.beginTransaction()){
                        val fragment2= Fragment2()
                        replace(R.id.container,fragment2)
                        commit()
                    }
                    return@setOnNavigationItemReselectedListener
                }
                R.id.tab3 ->{
                    with(supportFragmentManager.beginTransaction()){
                        val fragment3= Fragment3()
                        replace(R.id.container,fragment3)
                        commit()
                    }
                    return@setOnNavigationItemReselectedListener
                }

            }
            return@setOnNavigationItemReselectedListener
        }
    }
}