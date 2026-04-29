package com.example.cintaku

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cintaku.databinding.ActivityAuthBinding
import com.google.android.material.snackbar.Snackbar

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         //Kode ini harus selalu dipanggil saat butuh akses "user_pref"

         		val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                 //Kondisi jika isLogin bernilai true
//                 val isLogin = sharedPref.getBoolean("isLogin", false)
//                if (isLogin) {
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }

        
        binding.btnLogin.setOnClickListener {

            val username = binding.username.text.toString()
            val password = binding.password.text.toString()






            if (username == password) {
                val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", true)
                    editor.putString("username",username)
                    editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }


            else {
                Snackbar.make(binding.root, "anda gagal login", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Tutup") {
                        Log.e("Info Snackbar", "Snackbar ditutup")

                    }
                    .show()
            }

        }
    }
}




