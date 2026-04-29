package com.example.cintaku.Home.pertemuan_5

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.cintaku.R

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.webView)
        toolbar = findViewById(R.id.toolbar)

        // Toolbar jadi ActionBar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Web Merdeka"
            setDisplayHomeAsUpEnabled(true)

            // ubah warna icon back
            toolbar.navigationIcon?.setTint(Color.WHITE)
        }

        // ⭐ IMPROVISASI TOOLBAR (FADE IN ANIMATION)
        toolbar.alpha = 0f
        toolbar.animate()
            .alpha(1f)
            .setDuration(800)
            .start()

        // ⭐ IMPROVISASI BARU: WebView Loading Feedback
        webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {
                super.onPageStarted(view, url, favicon)

                // perubahan terlihat
                supportActionBar?.title = "Loading..."
            }

            override fun onPageFinished(
                view: WebView?,
                url: String?
            ) {
                super.onPageFinished(view, url)

                supportActionBar?.title = "Web Merdeka"

                Toast.makeText(
                    this@WebViewActivity,
                    "Website berhasil dimuat",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // WebView settings
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://merdeka.com")

        // BACK HANDLING MODERN (WAJIB)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    finish()
                }
            }
        })
    }

    // Tombol back di toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}