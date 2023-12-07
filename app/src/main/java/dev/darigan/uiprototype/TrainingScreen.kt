package dev.darigan.uiprototype

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SliderWithValuesAndTitle(
    title: String,
    sliderValue: Float,
    onValueChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "0", // Replace with your min value
                color = Color.Gray,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "50", // Replace with your max value
                color = Color.Gray,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }

        Slider(
            value = sliderValue,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            valueRange = 0f..50f
        )

        Text(
            text = sliderValue.toInt().toString(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}




@Composable
fun TrainingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {

        Text(text = "50 XP Available", fontWeight = FontWeight.Bold)
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            SliderWithValuesAndTitle(title = "Health", sliderValue = 5f, onValueChange = {})
            SliderWithValuesAndTitle(title = "Defense", sliderValue = 5f, onValueChange = {})
            SliderWithValuesAndTitle(title = "Speed", sliderValue = 5f, onValueChange = {})
            SliderWithValuesAndTitle(title = "Evasion", sliderValue = 5f, onValueChange = {})
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Train for 25 XP")
        }
    }
}