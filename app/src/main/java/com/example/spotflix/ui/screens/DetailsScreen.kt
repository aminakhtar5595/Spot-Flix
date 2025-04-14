package com.example.spotflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun DetailsScreen(navController: NavController) {
    Column {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF4F7CCB))
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { navController.popBackStack() },
                tint = Color.White
            )

            Text(
                text = "Movie Info",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaBlEMlTddNboEvHUefVn0RkoJSGa0kvIXNQ&s",
                contentDescription = "Google Image",
                modifier = Modifier.size(150.dp)
            )

            Text(text = "Little Man Town", style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp), modifier = Modifier.padding(vertical = 5.dp))

            Text(text = "5.8", style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.Red),)

            Text(text = "2022-05-11", style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.Red), modifier = Modifier.padding(vertical = 5.dp))
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Text(text = "Little Man Town", style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp), modifier = Modifier.padding(bottom = 5.dp))
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas vestibulum cursus velit, at cursus sapien interdum sit amet. Nunc egestas quam et mauris vestibulum, eget fermentum urna fringilla. Cras sit amet auctor augue. Duis placerat, sapien nec pulvinar ultricies, augue est maximus magna, eleifend mattis turpis est quis erat. Quisque sed auctor elit, in accumsan augue. ", style = TextStyle(fontSize = 14.sp))
        }
    }
}