package com.example.spotflix.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    Column {
        Row(
            modifier = Modifier
                .background(color = Color(0xFF4F7CCB))
                .padding(20.dp)
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
                text = "Find Movies",
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

        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            TextField(
                textStyle = TextStyle(
                    fontSize = 16.sp,
                ),
                value = "Search your movie",
                onValueChange = {  },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color(0xFFE5E8EB)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.5.dp, color = Color(0xFFE5E8EB)),
                shape = RoundedCornerShape(10.dp),
                placeholder = { Text("Search your movie") },
            )

        }

    }
}