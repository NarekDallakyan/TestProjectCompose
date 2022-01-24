package narek.testproject.ui.main.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import narek.testproject.ui.main.model.EngineItemModel

@Composable
fun EngineActionsView(
    size: Dp,
    padding: Dp,
    pageItemModel: EngineItemModel
) {

    Box(
        modifier = androidx.compose.ui.Modifier
            .width(size)
            .height(size)
            .clip(CircleShape)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = pageItemModel.firstEngineText,
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Spacer(androidx.compose.ui.Modifier.width(padding))
    Box(
        modifier = androidx.compose.ui.Modifier
            .width(size)
            .height(size)
            .clip(CircleShape)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = pageItemModel.secondEngineText,
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}