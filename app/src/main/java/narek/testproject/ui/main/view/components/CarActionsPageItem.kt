package narek.testproject.ui.main.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import narek.testproject.ui.main.model.DoorsItemModel
import narek.testproject.ui.main.model.EngineItemModel
import narek.testproject.ui.main.model.PageItemModel
import narek.testproject.ui.main.viewmodel.CarViewModel


@Composable
internal fun CarActionsPageItem(
    page: Int,
    pagePageItems: ArrayList<PageItemModel>,
    modifier: Modifier = Modifier,
    carViewModel: CarViewModel
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Row(
        modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        // Displays the page index
        pagePageItems.forEachIndexed { index, pageItemModel ->
            val itemWidth = ((screenWidth - 20.dp) / 2)
            Column(verticalArrangement = Arrangement.Top) {
                Text(
                    text = pageItemModel.defaultTitle,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(itemWidth)
                        .height(100.dp)
                        .padding(10.dp)
                        .background(Color.White),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CirclesViews(itemWidth) { circlePosition ->
                        when (pageItemModel) {
                            is DoorsItemModel -> {
                                DoorsItemHandler(
                                    position = circlePosition,
                                    pageItemModel = pageItemModel,
                                    carViewModel = carViewModel
                                )
                            }
                            is EngineItemModel -> {
                                EngineItemHandler(
                                    position = circlePosition,
                                    pageItemModel = pageItemModel
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}