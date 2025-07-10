package com.example.spotflix.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spotflix.ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(title: String, navController: () -> Unit) {
    CenterAlignedTopAppBar(
        modifier = Modifier.fillMaxWidth().background(color = Blue).padding(horizontal = 15.dp),
        title = {
            Text(title,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back Icon",
                modifier = Modifier.size(25.dp).clickable { navController() },
                tint = Color.White
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Blue)
    )
}
