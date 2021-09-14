package ir.kaaveh.cryptocurrencycompose.common

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

internal fun RecyclerView.linearLayout(
    context: Context,
    @RecyclerView.Orientation orientation: Int? = RecyclerView.VERTICAL,
    reverseLayout: Boolean? = false,
    stackFromEnd: Boolean? = false
) {
    val lm = LinearLayoutManager(context, orientation!!, reverseLayout!!)
    lm.stackFromEnd = stackFromEnd!!
    layoutManager = lm
    setHasFixedSize(true)
}