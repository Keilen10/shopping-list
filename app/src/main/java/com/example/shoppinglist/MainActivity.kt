package com.example.shoppinglist

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.webkit.WebView
import android.widget.FrameLayout

class MainActivity : Activity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true // localStorage holds the list
            setBackgroundColor(getColor(R.color.background))
            loadUrl("file:///android_asset/shopping-list.html")
        }
        val root = FrameLayout(this).apply { addView(webView) }
        setContentView(root)

        // Android 15+ always draws edge to edge, so keep the page clear of the
        // status bar, navigation bar and keyboard ourselves.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            root.setOnApplyWindowInsetsListener { view, insets ->
                val bars = insets.getInsets(
                    WindowInsets.Type.systemBars() or
                        WindowInsets.Type.displayCutout() or
                        WindowInsets.Type.ime()
                )
                view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
                WindowInsets.CONSUMED
            }
        }
    }
}
