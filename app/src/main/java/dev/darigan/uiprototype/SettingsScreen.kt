package dev.darigan.uiprototype

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun SettingsScreen() {
    val showDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Settings", color = Color.Black)
        DeleteAccountButton(onDeleteClicked = { showDialog.value = true })
    }

    if (showDialog.value) {
        DeleteAccountDialog(
            onConfirmDelete = {
                // Implement the logic to delete the account here
                // For example, show a toast or navigate to a confirmation screen
                // Remember to handle the deletion of the account securely
            },
            onDismiss = { showDialog.value = false }
        )
    }
}

@Composable
fun DeleteAccountButton(onDeleteClicked: () -> Unit) {
    Button(onClick = onDeleteClicked) {
        Text(text = "Delete Account")
    }
}

@Composable
fun DeleteAccountDialog(
    onConfirmDelete: () -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(text = "Delete Account")
        },
        text = {
            Text(text = "Are you sure you want to delete your account? This action cannot be undone.")
        },
        confirmButton = {
            Button(onClick = {
                onConfirmDelete()
                onDismiss()
            }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "Cancel")
            }
        }
    )
}
