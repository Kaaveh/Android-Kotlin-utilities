import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.requestPermission(requestCode: Int, vararg permissions: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        ActivityCompat.requestPermissions(this, permissions, requestCode)
    }
}

fun FragmentActivity.checkAppPermission(permission: String): Boolean =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    else
        true

fun FragmentActivity.openAppPermissionSetting() {
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    val uri = Uri.fromParts("package", this.packageName, null)
    intent.data = uri
    this.startActivityForResult(intent, Constants.APP_SETTING)
}

fun FragmentActivity.showAppSettingDialog(
    permission: String,
    requestCode: Int,
    @StringRes messageResource: Int,
    function: (() -> Unit)? = null
) {
    AlertDialog.Builder(this)
        .setMessage(messageResource)
        .setNegativeButton(R.string.cancel) { dialog, _ ->
            dialog.dismiss()
        }
        .setPositiveButton(R.string.show_app_permissions_setting) { dialog, _ ->
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                this.requestPermission(requestCode, permission)
            } else {
                this.openAppPermissionSetting()
            }
            function?.invoke()
            dialog.dismiss()
        }
        .show()
}

fun isLollipopOrAbove(func: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        func()
    }
}