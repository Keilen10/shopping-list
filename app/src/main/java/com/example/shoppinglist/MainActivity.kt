package com.example.shoppinglist

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.FrameLayout
import android.window.OnBackInvokedDispatcher

class MainActivity : Activity() {

    private lateinit var webView: WebView
    private lateinit var root: FrameLayout

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true // localStorage holds the list
            setBackgroundColor(getColor(R.color.background))
            addJavascriptInterface(PageBridge(), "AndroidApp")
            loadUrl("file:///android_asset/shopping-list.html")
        }
        root = FrameLayout(this).apply { addView(webView) }
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(
                OnBackInvokedDispatcher.PRIORITY_DEFAULT
            ) { handleBack() }
        }
    }

    // Android 12 and older. Newer versions use the callback registered in onCreate.
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        handleBack()
    }

    // The page closes its settings panel first; otherwise leave the app.
    private fun handleBack() {
        webView.evaluateJavascript("window.handleBack()") { handled ->
            if (handled != "true") finish()
        }
    }

    private fun applyTheme(dark: Boolean) {
        val background = getColor(if (dark) R.color.background_dark else R.color.background_light)
        webView.setBackgroundColor(background)
        root.setBackgroundColor(background)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val lightBars = WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS or
                WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
            window.insetsController?.setSystemBarsAppearance(if (dark) 0 else lightBars, lightBars)
        } else {
            var lightBars = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                lightBars = lightBars or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
            val flags = window.decorView.systemUiVisibility
            window.decorView.systemUiVisibility = if (dark) flags and lightBars.inv() else flags or lightBars
        }
    }

    private inner class PageBridge {
        @JavascriptInterface
        fun setDarkTheme(dark: Boolean) {
            runOnUiThread { applyTheme(dark) }
        }
    }
}
