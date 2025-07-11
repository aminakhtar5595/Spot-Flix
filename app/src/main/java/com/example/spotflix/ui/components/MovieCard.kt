package com.example.spotflix.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.spotflix.ui.model.Movie

@Composable
fun MovieCard(movie: Movie, isFavorite: Boolean, onFavoriteClick: () -> Unit, onClick: () -> Unit) {
    Row (
        modifier = Modifier
            .padding(bottom = 15.dp)
            .border(width = 0.2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
                contentDescription = "Poster of ${movie.title}",
                modifier = Modifier
                    .height(100.dp)
                    .width(60.dp),
                contentScale = ContentScale.Fit
            )
            Column (
                modifier = Modifier.padding(horizontal = 10.dp),
            ) {
                Text(
                    text = movie.title, style = TextStyle(fontWeight = FontWeight.SemiBold)
                )
                Row (
                    modifier = Modifier.padding(vertical = 5.dp)
                ) {
                    Text(text = "${movie.vote_average} | ${movie.release_date}", fontSize = 13.sp)
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
            model = if (isFavorite) "https://static.vecteezy.com/system/resources/previews/018/842/695/non_2x/red-heart-shape-icon-like-or-love-symbol-for-valentine-s-day-3d-render-illustration-free-png.png"
            else "https://static.vecteezy.com/system/resources/thumbnails/019/040/388/small_2x/red-empty-heart-png.png",
            contentDescription = "Google Image",
            modifier = Modifier.size(18.dp)
                .clickable { onFavoriteClick() },

            )
    }
}