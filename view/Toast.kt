package ir.kaaveh.cryptocurrencycompose.common

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView

fun Context.appToast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, duration).apply {
        val layout = LayoutInflater.from(this@appToast).inflate(R.layout.custom_toast, null)
        val texMessage = layout.findViewById<AppCompatTextView>(R.id.text_message)
        texMessage.text = text
        this.view = layout
    }.show()