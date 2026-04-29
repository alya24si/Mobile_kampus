package com.example.cintaku.Home.pertemuan_7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.cintaku.R
import com.example.cintaku.databinding.ActivitySevenBinding

class SevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySevenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFragment(SatuFragment())
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Halaman Seven"
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        binding.btnFragmen1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragmen2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragmen3.setOnClickListener {
            replaceFragment(TigaFragment())
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}