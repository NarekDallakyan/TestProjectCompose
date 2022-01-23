package narek.testproject.ui.main.view.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import narek.testproject.ui.main.model.EngineItemModel

@Composable
fun EngineItemHandler(position: Int, pageItemModel: EngineItemModel) {
    if (position == 0) {
        Text(
            text = pageItemModel.firstEngineText,
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    } else {
        Text(
            text = pageItemModel.secondEngineText,
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}