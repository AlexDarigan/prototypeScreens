package dev.darigan.uiprototype

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BattleScreen() {
    var playerHealth by remember { mutableStateOf(100) }
    var opponentHealth by remember { mutableStateOf(100) }
    var message by remember { mutableStateOf("Choose an action") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Battle!",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PlayerCard(
                name = "BelleStar",
                health = playerHealth,
                drawableRes = R.drawable.ic_launcher_foreground,
                onClick = {}
            )

            PlayerCard(
                name = "annieOakleyr",
                health = opponentHealth,
                drawableRes = R.drawable.ic_launcher_foreground,
                onClick = {}
            )
        }

        Divider(color = Color.Gray, modifier = Modifier.padding(vertical = 16.dp))

        Text(
            text = message,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = { /* Perform action */ }) {
            Text("Fight")
        }
    }
}

@Composable
fun PlayerCard(name: String, health: Int, drawableRes: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp)
    ) {
        Text(text = name, modifier = Modifier.padding(bottom = 8.dp))
        Surface(
            modifier = Modifier
                .clip(CircleShape)
                .clickable { onClick.invoke() }
                .size(120.dp)
                .background(Color.LightGray),
            shadowElevation = 4.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Pokemon image
                Image(
                    painter = painterResource(id = drawableRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        HealthBar(health)
    }
}

@Composable
fun HealthBar(health: Int) {
    Box(
        modifier = Modifier
            .height(16.dp)
            .width(120.dp)
            .background(Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .width((health * 1.2).dp)
        )
    }
}

