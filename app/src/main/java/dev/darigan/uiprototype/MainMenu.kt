package dev.darigan.uiprototype

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SideDrawer(
    drawerState: DrawerState,
    onMenuItemClicked: (String) -> Unit
) {
    val drawerContentItems = listOf(
        DrawerMenuItem("World Map", R.drawable.earth_europe_solid),
        DrawerMenuItem("Spell Book", R.drawable.book_solid),
        DrawerMenuItem("Training", R.drawable.dumbbell_solid),
        DrawerMenuItem("Leaderboard", R.drawable.ranking_star_solid),
        DrawerMenuItem("Settings", R.drawable.gear_solid),
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(modifier = Modifier.background(Color.Black).fillMaxHeight().padding(16.dp)) {
                drawerContentItems.forEach { item ->
                    DrawerItem(item, onMenuItemClicked)
                    Spacer(modifier = Modifier.height(32.dp))
                }
                Spacer(modifier = Modifier.weight(1f))
                DrawerItem(DrawerMenuItem("Logout", R.drawable.right_from_bracket_solid), {})
                Spacer(modifier = Modifier.weight(0.1f))
            }
        },
        content = {
            // Main content of the screen
            // Your main content goes here
        }
    )
}

@Composable
fun DrawerItem(
    item: DrawerMenuItem,
    onMenuItemClicked: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onMenuItemClicked(item.title)
        }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

data class DrawerMenuItem(val title: String, val icon: Int)
