import ir.hamsaa.persiandatepicker.util.PersianCalendar
import java.text.SimpleDateFormat
import java.util.*
/*
* First of all, add this dependency to your project https://github.com/aliab/Persian-Date-Picker-Dialog
 */

fun String.shamsi(): String {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val date = format.parse(this)
    val persianCalendar = PersianCalendar(date?.time ?: 0)
    return persianCalendar.persianShortDate
}

fun String.toDate(): Date {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    return format.parse(this)
}