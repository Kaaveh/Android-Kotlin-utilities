package ir.kaaveh.cryptocurrencycompose.common

import android.view.View

fun View.visible(b: Boolean) =
    if (b) this.visibility = View.VISIBLE else this.visibility = View.GONE