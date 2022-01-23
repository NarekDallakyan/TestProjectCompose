package narek.testproject.ui.main.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import narek.testproject.ui.main.model.DoorsItemModel
import narek.testproject.ui.main.viewmodel.CarViewModel
import task.domain.model.Result

@Composable
fun DoorsItemHandler(
    position: Int,
    pageItemModel: DoorsItemModel,
    carViewModel: CarViewModel
) {
    val lockUiState = carViewModel.doorsLockState

    if (position == 0) {
        if (lockUiState is Result.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Image(
                painter = painterResource(id = pageItemModel.lockIcon),
                contentDescription = null,
                modifier = Modifier.clickable {
                    carViewModel.lockDoors()
                }
            )
        }
    } else {
        Image(
            painter = painterResource(id = pageItemModel.unLockIcon),
            contentDescription = null
        )
    }
}