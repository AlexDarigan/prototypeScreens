package dev.darigan.uiprototype

import android.graphics.drawable.shapes.RectShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpellBookScreen() {
    // Sample data for the spell belt images

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Spell Details Card with Image
        SpellView()
        SpellBelt()
        SpellBook()
    }
}

@Composable
fun SpellBook() {
    val spellBookItems = listOf(
        R.drawable.earthmage_1, R.drawable.earthmage_2, R.drawable.earthmage_3,
        R.drawable.firemage_1, R.drawable.firemage_2, R.drawable.firemage_6,
        R.drawable.engineer_1, R.drawable.engineer_2, R.drawable.engineer_3
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Spell Book",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider(thickness = 4.dp, modifier = Modifier.padding(2.dp), color = Color.White)
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(spellBookItems.size) { index ->
                    Box(modifier = Modifier
                        .weight(1f / 3)
                        .padding(4.dp)) {
                        Image(
                            painter = painterResource(id = spellBookItems[index]),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(2.dp, Color.Black)
                                .size(80.dp)
                        )
                    }

                }
            }
        }
    }
}


@Composable
fun SpellView() {
    // Sample data for the spell details
    val spellDetails = SpellDetails(
        name = "Fireball",
        type = "Attack",
        element = "Fire",
        basePower = 50,
        additionalEffects = "Burns the target",
        amount = 15,
        image = R.drawable.firemage_6
    )

    // Spell Details Card with Image and Basic Details
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f / 2.2f)
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Image
                Image(
                    painter = painterResource(id = spellDetails.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                // Basic Details
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = spellDetails.name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Text(text = "Type: ${spellDetails.type}")
                    Text(text = "Element: ${spellDetails.element}")
                    Text(text = "Base Power: ${spellDetails.basePower}")
                    Text(text = "Amount: ${spellDetails.amount}")
                }
            }
            Divider(thickness = 4.dp, modifier = Modifier.padding(2.dp), color = Color.White)

            // Additional Details Section (Scrollable)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                    Text(text = "25% chance to inflict Burn for 3 turns")
                    Spacer(modifier = Modifier.weight(.5f))
                    Text(text = "Don't play with Fire if you can't handle the heat", fontStyle = FontStyle.Italic)
            }
        }
    }
}


@Composable
fun SpellBelt() {
    // Sample data for the spell book grid
    val spellBeltItems = listOf(
        R.drawable.engineer_1, R.drawable.engineer_2, R.drawable.engineer_3,
        R.drawable.earthmage_3, R.drawable.firemage_6, R.drawable.firemage_2
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Spell Belt",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider(thickness = 4.dp, modifier = Modifier.padding(2.dp), color = Color.White)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                spellBeltItems.take(6).forEach { spellImage ->
                    Image(
                        painter = painterResource(id = spellImage),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f / 6)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                    )
                }
            }
        }
    }
}


data class SpellDetails(
    val name: String,
    val type: String,
    val element: String,
    val amount: Int,
    val basePower: Int,
    val additionalEffects: String,
    val image: Int
)
