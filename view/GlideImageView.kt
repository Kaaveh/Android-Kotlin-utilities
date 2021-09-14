import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadUrl(url: String) {
    Glide.with(context).load(url).apply(RequestOptions().error(R.mipmap.ic_launcher)).into(this)
}

fun ImageView.loadCircleImage(url: String) {
    Glide.with(context).load(url).apply(
        RequestOptions.circleCropTransform()
            .error(R.mipmap.ic_launcher_round)
    ).into(this)
}