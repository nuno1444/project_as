package com.project.all_studies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.activity_register)

        btn_signup.setOnClickListener {
            createAccount(
                reg_email.text.toString(),
                reg_pw.text.toString())
        }
    }

    //계정생성
    private fun createAccount(id: String, pw: String) {
        if (id.isNotEmpty() && pw.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(id, pw)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, " 계정생성 완료 ", Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this, " 계정생성 실패 ", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }


}