package com.example.cintaku

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cintaku.databinding.ActivityFourthBinding
import com.example.cintaku.databinding.ActivityMainBinding
import com.example.cintaku.databinding.ActivityThirdBinding
import com.example.cintaku.pertemuan2.SecondActivity
import com.example.cintaku.pertemuan_3.ThirdActivity
import com.example.cintaku.pertemuan_3.ThirdResultActivity
import com.example.cintaku.pertemuan_4.FourthActivity
import com.example.cintaku.pertemuan_5.FifthActivity
import com.example.cintaku.pertemuan_7.SevenActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {

            val intent = Intent(this, FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent (this, FourthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToTwo.setOnClickListener {

            val intent = Intent (this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnToThree.setOnClickListener {

            val intent = Intent (this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnToFive.setOnClickListener {

            val intent = Intent (this, FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSeven.setOnClickListener {

            val intent = Intent (this, SevenActivity::class.java)
            startActivity(intent)
        }

        binding.btna.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    val intent = Intent (this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()

        }
    }
}


