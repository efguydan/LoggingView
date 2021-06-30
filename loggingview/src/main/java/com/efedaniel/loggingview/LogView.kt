package com.efedaniel.loggingview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class LogView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ScrollView(context, attrs, defStyle) {

    private val logTextView: TextView

    init {
        inflate(context, R.layout.custom_layout_log_view, this)
        logTextView = findViewById(R.id.logTextView)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        readLogs()
        setupScrollViewScroll()
    }

    private fun readLogs() {
        try {
            val process = Runtime.getRuntime().exec("logcat -d")
            val bufferedReader = BufferedReader(InputStreamReader(process.inputStream))

            val log = StringBuilder()
            var line: String? = bufferedReader.readLine()

            while (line != null) {
                log.append(line)
                log.append("\n")
                logTextView.text = log
                line = bufferedReader.readLine()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun setupScrollViewScroll() {
        post {
            fullScroll(View.FOCUS_DOWN)
        }
    }

}