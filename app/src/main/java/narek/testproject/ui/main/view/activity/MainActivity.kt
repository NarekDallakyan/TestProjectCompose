package narek.testproject.ui.main.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import narek.testproject.R
import narek.testproject.ui.main.view.components.CarActionsView
import narek.testproject.ui.main.view.components.CarPicturePreview
import narek.testproject.ui.main.view.components.TopBarView
import narek.testproject.ui.main.viewmodel.CarViewModel
import narek.testproject.ui.theme.Gray200
import narek.testproject.ui.theme.TestProjectTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val carViewModel: CarViewModel by viewModels()

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val backHandlingEnabled by remember { mutableStateOf(true) }

            // Handle back press
            BackHandler(backHandlingEnabled) {
                Toast.makeText(this, "$backHandlingEnabled", Toast.LENGTH_SHORT).show()
            }

            TestProjectTheme {
                MainActivityParentBox(Gray200) {
                    Column(verticalArrangement = Arrangement.Top) {
                        TopBarView()
                        CarPicturePreview(R.drawable.car_image)
                        CarActionsView(carViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun MainActivityParentBox(
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
    ) {
        content.invoke()
    }
}