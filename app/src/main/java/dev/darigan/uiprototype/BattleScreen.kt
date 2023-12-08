package dev.darigan.uiprototype

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BattleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Opponent Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Opponent Health Bar
            Column {
                Text(
                    text = "Opponent Name", // Replace with actual name
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                HealthBar(health = 70) // Pass opponent's health here
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "100 / 100", // Replace with actual name
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
            }

            // Opponent Avatar
            Avatar()
        }

        Spacer(modifier = Modifier.weight(1f, fill = true))
        // Player Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            // Player Avatar
            Avatar()

            // Player Health Bar
            Column {
                Text(
                    text = "Player Name", // Replace with actual name
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                HealthBar(health = 90)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "100 / 100", // Replace with actual name
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
            }
//            HealthBar(health = 90) // Pass player's health here
        }


        Spacer(modifier = Modifier.height(24.dp))

        // Six Circles Representing Spells
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SpellCircle()
            SpellCircle(R.drawable.earthmage_1)
            SpellCircle(R.drawable.earthmage_2)
            SpellCircle(R.drawable.earthmage_3)
            SpellCircle(R.drawable.engineer_1)
            SpellCircle(R.drawable.firemage_1)
        }
    }
}

@Composable
fun HealthBar(health: Int) {
    Surface(
        modifier = Modifier
            .width(240.dp)
            .height(20.dp),
        color = Color.Gray,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green, shape = RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun Avatar() {
    // Replace with actual avatar image or placeholder
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = "Avatar", // Placeholder or image
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun SpellCircle(image: Int = R.drawable.firemage_6) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(Color.Red, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview()
@Composable
fun Game() {
    BattleScreen()
}