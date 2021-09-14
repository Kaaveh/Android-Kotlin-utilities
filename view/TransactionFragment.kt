import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

internal fun FragmentManager.addFragment(
    containerViewId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false
) {
    this.beginTransaction()
        .add(containerViewId, fragment)
        .apply { if (addToBackStack) addToBackStack(null) }
        .commitAllowingStateLoss()
}

internal fun FragmentManager.replaceFragment(
    containerViewId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false
) {
    this.beginTransaction()
        .replace(containerViewId, fragment)
        .apply { if (addToBackStack) addToBackStack(null) }
        .commitAllowingStateLoss()
}

internal fun FragmentManager.detachFragment(fragment: Fragment, popBackStack: Boolean = false) {
    this.beginTransaction()
        .detach(fragment)
        .commitAllowingStateLoss()
    if (popBackStack) popBackStack()
}