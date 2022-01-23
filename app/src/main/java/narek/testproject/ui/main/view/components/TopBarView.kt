package narek.testproject.ui.main.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import narek.testproject.R

@Composable
fun TopBarView() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        Text("ROGUE SPT ")
        Text(
            "",
            Modifier
                .height(25.dp)
                .width(1.dp)
                .background(Color.Black),

            )
        Icon(
            painter = painterResource(id = R.drawable.ic_notif_gas),
            contentDescription = null // decorative element
        )
        Text(
            text = "120mi",
            fontSize = 10.sp
        )
    }
}