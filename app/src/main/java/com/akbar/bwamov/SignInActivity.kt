package com.akbar.bwamov

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akbar.bwamov.signin.User
import com.google.firebase.*
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    lateinit var iUsername: String
    lateinit var iPassword: String
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

//        database = FirebaseDatabase.getInstance("https://bwa-project-500d4-default-rtdb.firebaseio.com/").getReference("User")
        database = Firebase.database.reference

        btn_memulai.setOnClickListener {
            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()
//            System.out.println(iUsername+iPassword)
            pushLogin(iUsername, iPassword)
        }

        btn_daftar_akun.setOnClickListener {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        if (cekLogin()) {
            /*
            database.child(iUsername).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var user = snapshot.getValue(User::class.java)
                    if (user != null) {
                        if (user.password.equals(iPassword)) {
                            val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@SignInActivity, "Password Salah", Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(this@SignInActivity, "Data Tidak Ditemukan", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    System.out.println("AdaError"+error.message)
                }
            })
            */
           database.child("User").child(iUsername).get().addOnSuccessListener {
               Log.i("firebase","Got Value ${it.value}")
           }.addOnFailureListener{
               Log.e("firebase","Error getting data",it)
           }


        }
    }

    private fun cekLogin(): Boolean {
        if (iUsername.isEmpty()) {
            this.et_username.error = "Username tidak boleh kosong"
            return false
        }else if (iPassword.isEmpty()){
            this.et_password.error = "Harap isi password anda"
            return false
        }else {
            return true
        }
    }
}