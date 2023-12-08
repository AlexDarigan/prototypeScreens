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
import androidx.compose.ui.graphics.Color
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
            HealthBar(health = 70) // Pass opponent's health here

            // Opponent Avatar
            Avatar()

        }
        Spacer(modifier = Modifier.height(8.dp))

        // Opponent Name
        BasicText(
            text = "Opponent Name", // Replace with actual name
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Player Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            // Player Avatar
            Avatar()

            // Player Health Bar
            HealthBar(health = 90) // Pass player's health here
        }

        // Player Name
        BasicText(
            text = "Player Name", // Replace with actual name
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Six Circles Representing Spells
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(6) {
                SpellCircle()
            }
        }
    }
}

@Composable
fun HealthBar(health: Int) {
    Surface(
        modifier = Modifier
            .width(120.dp)
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
fun SpellCircle() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(Color.Red, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Spell", // Placeholder for spell representation
            fontSize = 16.sp,
            color = Color.White
        )
    }
}


@Preview()
@Composable
fun Game() {
    BattleScreen()
}