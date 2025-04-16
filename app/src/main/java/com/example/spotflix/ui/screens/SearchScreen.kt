package com.example.spotflix.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    Column {
        Box(modifier = Modifier
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
                value = searchText,
                onValueChange = {  },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
                    .border(width = 1.5.dp, color = Color(0xFFE5E8EB)),
                shape = RoundedCornerShape(10.dp),
                placeholder = { Text("Search your movie") },
            )
            
            LazyColumn {
                items(5) {
                    MovieCard(title = "Little Man Town", rating = "5.8", date = "2022-05-11", image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaBlEMlTddNboEvHUefVn0RkoJSGa0kvIXNQ&s")
                }
            }
        }
    }
}

@Composable
fun MovieCard(title: String, rating: String, date: String, image: String) {
    Row (
        modifier = Modifier
            .padding(bottom = 15.dp)
            .border(width = 0.2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = image,
                contentDescription = "Google Image",
            )
            Column (
                modifier = Modifier.padding(horizontal = 10.dp),
            ) {
                Text(
                    text = title, style = TextStyle(fontWeight = FontWeight.SemiBold))
                Row (
                    modifier = Modifier.padding(vertical = 5.dp)
                ) {
                    Text(text = rating, style = TextStyle(fontSize = 13.sp))
                    Text(text = " | ", style = TextStyle(fontSize = 13.sp))
                    Text(text = date, style = TextStyle(fontSize = 13.sp))
                }

                Surface(
                    color = Color.Red,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(10.dp),
                    shadowElevation = 0.dp
                ) {
                    Box(
                        modifier = Modifier
                            .clickable { }
                            .padding(horizontal = 7.dp, vertical = 5.dp)
                        ,
                    ) {
                        Text(
                            text = "Share",
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
        AsyncImage(
            model = "https://static.vecteezy.com/system/resources/thumbnails/019/040/388/small_2x/red-empty-heart-png.png",
            contentDescription = "Google Image",
            modifier = Modifier.size(18.dp)
        )
    }
}