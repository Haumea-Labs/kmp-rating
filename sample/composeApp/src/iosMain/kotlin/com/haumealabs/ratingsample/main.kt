import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.haumealabs.ratingsample.App
import com.haumealabs.rating.RatingManager

fun MainViewController(): UIViewController = ComposeUIViewController {
    val ratingManager = RatingManager()
    App(ratingManager)
}