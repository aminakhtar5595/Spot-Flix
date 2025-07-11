package com.example.spotflix.ui.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotflix.ui.navigation.Screen
import com.example.spotflix.ui.theme.Blue
import com.example.spotflix.ui.theme.Red

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        // Header
        Text(
            "Welcome Home",
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .background(color = Blue)
                .fillMaxWidth()
                .padding(20.dp)
        )

//        Home button
        Column(
            modifier = Modifier.padding(horizontal = 15.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                text = "Search Movies",
                color = Red,
                onClick = { navController.navigate(Screen.Search.route) }
            )

            Spacer(Modifier.height(20.dp))

            OutlinedButton(
                text = "Favorite Movies",
                color = Blue,
                onClick = { navController.navigate(Screen.Favorite.route) }
            )

        }
    }
}

@Composable
fun OutlinedButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(vertical = 15.dp),
        border = BorderStroke(1.5.dp, color),
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W500,
                fontSize = 18.sp,
            )
        )
    }
}
