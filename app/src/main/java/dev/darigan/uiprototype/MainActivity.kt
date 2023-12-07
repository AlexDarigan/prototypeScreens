package dev.darigan.uiprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.darigan.uiprototype.ui.theme.UiprototypeTheme

// TODO
// Battle
// Note: If time; Recheck Settings and Theming.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiprototypeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //TrainingScreen()
                    //LoginScreen()
                    //SignUpScreen()
                    //SpellBookScreen()
                    //LeaderboardScreen()
                    // SettingsScreen()
                    BattleScreen()
                    //SideDrawer(drawerState = DrawerState(DrawerValue.Open), onMenuItemClicked = {})

                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSliderWithValuesAndTitle() {
    TrainingScreen()
}

