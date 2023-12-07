package dev.darigan.uiprototype

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class LeaderboardUser(
    val username: String,
    val wins: Int,
    val losses: Int,
    val draws: Int,
    val rank: Int
)

@Composable
fun Leaderboard(users: List<LeaderboardUser>, currentUser: LeaderboardUser) {
    LazyColumn {
        item {
            // Display the current user in a different color
            UserItem(user = currentUser, isCurrentUser = true)
        }
        items(users.size) { index ->
            if (users[index] != currentUser) {
                UserItem(user = users[index], isCurrentUser = false)
            }
        }
    }
}

@Composable
fun UserItem(user: LeaderboardUser, isCurrentUser: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(if (isCurrentUser) Color.Blue else Color.Transparent)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Rank
        Text(
            text = "${user.rank}",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 16.dp)
        )
        // Display round avatar
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        // Display username and W/L/D ratios
        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(
                text = user.username,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = if (isCurrentUser) FontWeight.Bold else FontWeight.Normal
            )
            Text(
                text = "W: ${user.wins} / L: ${user.losses} / D: ${user.draws}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}



@Composable
fun LeaderboardScreen() {
    val currentUser = LeaderboardUser("David Darigan", 10, 5, 3, 345)
    val users = listOf(
        LeaderboardUser("AnnieOakley", 8, 6, 2, 1),
        LeaderboardUser("ButchCassidy", 6, 8, 4, 2),
        LeaderboardUser("BillyTheGOAT", 7, 5, 3, 3),
        LeaderboardUser("BelleStar", 9, 4, 4, 4),
        LeaderboardUser("TumbleDoor", 8, 10, 2, 5),
        LeaderboardUser("MerlinMayhem", 6, 8, 4, 6),
        LeaderboardUser("JohnDSharpShooter", 3, 7, 3, 7),
        LeaderboardUser("BelleStar71", 1, 4, 4, 8)
    )
    Leaderboard(users = users, currentUser = currentUser)
}
