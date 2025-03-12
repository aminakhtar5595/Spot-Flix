package com.example.spotflix.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column {
        Text(
            text = "Welcome Home",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .background(color = Color(0xFF4F7CCB))
                .fillMaxWidth()
                .padding(20.dp)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
        Button(
            onClick = { },
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(vertical = 15.dp),
            border = BorderStroke(1.5.dp, Color(0xFFe95f25)),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFFe95f25),
                containerColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
        ) {
            Text(
                text = "Search Movies",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500
                )
            )
        }

            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(vertical = 15.dp),
                border = BorderStroke(1.5.dp, Color(0xFF4F7CCB)),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFF4F7CCB),
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Favorite Movies",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500
                    )
                )
            }

        }

    }
}