package narek.testproject.ui.main.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import narek.testproject.R
import narek.testproject.ui.main.model.DoorsItemModel
import narek.testproject.ui.main.model.EngineItemModel
import narek.testproject.ui.main.viewmodel.CarViewModel

@ExperimentalPagerApi
@Composable
fun CarActionsView(carViewModel: CarViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        val pagerState = rememberPagerState()
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .padding(16.dp),
        )
        // Display 10 items
        HorizontalPager(
            count = 2,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
        ) { page ->
            if (page == 0) {
                DoorsAndEngineSectionsView(
                    page = page,
                    sectionItemPair = Pair(
                        DoorsItemModel(
                            lockIcon = R.drawable.ic_act_lock,
                            unLockIcon = R.drawable.ic_act_unlock
                        ),
                        EngineItemModel(
                            firstEngineText = "START",
                            secondEngineText = "STOP"
                        )
                    ),
                    carViewModel = carViewModel
                )
            }
        }
    }

}
