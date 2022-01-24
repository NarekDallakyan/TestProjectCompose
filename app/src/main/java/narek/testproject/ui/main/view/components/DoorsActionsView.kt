package narek.testproject.ui.main.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import narek.testproject.ui.main.model.DoorsItemModel
import narek.testproject.ui.main.viewmodel.CarViewModel
import task.domain.model.Result

@Composable
fun DoorsActionsView(
    size: Dp,
    padding: Dp,
    pageItemModel: DoorsItemModel,
    carViewModel: CarViewModel
) {
    // States
    val openDialog = remember { mutableStateOf(false) }
    val lockActionState = carViewModel.doorsLockState
    val lockImageAlpha = if (lockActionState is Result.Loading) 0f else 1f
    val lockCircleBackgroundColor: Color = when (lockActionState) {
        is Result.Loading -> Color.Transparent
        is Result.Non -> Color.Black
        is Result.Success -> Color.Red
        else -> Color.Black
    }
    val unLockCircleBackgroundColor: Color = when (lockActionState) {
        is Result.Loading -> Color.Gray
        is Result.Non -> Color.Black
        is Result.Success -> Color.Black
        else -> Color.Black
    }
    if (lockActionState is Result.Loading) Color.Transparent else Color.Black


    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Title:") },
            text = {
                Text(
                    text = "Description:"
                )
            },

            confirmButton = {
                Button(onClick = {
                    openDialog.value = false
                    carViewModel.lockDoors()
                }) {
                    Text(text = "Yes")
                }
            },

            dismissButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    }

    Box(
        modifier = Modifier
            .width(size)
            .height(size)
            .clip(CircleShape)
            .background(lockCircleBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        if (lockActionState is Result.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Image(
                painter = painterResource(id = pageItemModel.lockIcon),
                contentDescription = null,
                modifier = Modifier
                    .alpha(lockImageAlpha)
                    .clickable {
                        openDialog.value = true
                    }
            )
        }
    }
    Spacer(Modifier.width(padding))
    Box(
        modifier = Modifier
            .width(size)
            .height(size)
            .clip(CircleShape)
            .background(unLockCircleBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = pageItemModel.unLockIcon),
            contentDescription = null
        )
    }
}