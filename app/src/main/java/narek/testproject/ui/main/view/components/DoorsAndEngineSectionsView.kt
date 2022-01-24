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
import narek.testproject.ui.main.model.SectionItemModel
import narek.testproject.ui.main.viewmodel.CarViewModel
import task.domain.model.Result


@Composable
internal fun DoorsAndEngineSectionsView(
    page: Int,
    sectionItemPair: Pair<SectionItemModel, SectionItemModel>,
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
        val firsItem = sectionItemPair.first
        val secondItem = sectionItemPair.second
        val itemWidth = ((screenWidth - 20.dp) / 2)
        val doorsTitle = when (carViewModel.doorsLockState) {
            is Result.Non -> {
                "Doors"
            }
            is Result.Loading -> {
                "Doors |"
            }
            is Result.Success -> {
                "Doors | locked"
            }
            is Result.Failure -> {
                "Doors | can't lock"
            }
        }

        /**
         *  First Item view
         */
        Column(verticalArrangement = Arrangement.Top) {
            Text(
                text = doorsTitle,
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
                // Circle container
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    val padding = 5.dp
                    val circleSize = (itemWidth / 2) - (padding * 5)

                    when (firsItem) {
                        is DoorsItemModel -> {
                            DoorsActionsView(
                                size = circleSize,
                                padding = padding,
                                pageItemModel = firsItem,
                                carViewModel = carViewModel
                            )
                        }
                        is EngineItemModel -> {
                            EngineActionsView(
                                size = circleSize,
                                padding = padding,
                                pageItemModel = firsItem
                            )
                        }
                    }
                }
            }
        }

        /**
         *  Second Item view
         */
        Column(verticalArrangement = Arrangement.Top) {
            Text(
                text = secondItem.defaultTitle,
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
                // Circle container
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    val padding = 5.dp
                    val circleSize = (itemWidth / 2) - (padding * 5)

                    when (secondItem) {
                        is DoorsItemModel -> {
                            DoorsActionsView(
                                size = circleSize,
                                padding = padding,
                                pageItemModel = secondItem,
                                carViewModel = carViewModel
                            )
                        }
                        is EngineItemModel -> {
                            EngineActionsView(
                                size = circleSize,
                                padding = padding,
                                pageItemModel = secondItem
                            )
                        }
                    }
                }
            }
        }
    }
}