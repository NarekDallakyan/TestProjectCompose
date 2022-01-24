package narek.testproject.ui.main.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import narek.testproject.ui.main.viewmodel.CarViewModel

@Composable
fun CirclesViews(
    size: Dp,
    padding: Dp = 5.dp,
    content: @Composable (position: Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val circleSize = (size / 2) - (padding * 5)
        Box(
            modifier = Modifier
                .width(circleSize)
                .height(circleSize)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            content.invoke(0)
        }
        Spacer(Modifier.width(padding))
        Box(
            modifier = Modifier
                .width(circleSize)
                .height(circleSize)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            content.invoke(1)
        }
    }
}