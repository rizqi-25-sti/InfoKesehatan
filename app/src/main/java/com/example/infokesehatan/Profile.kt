package com.example.infokesehatan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.infokesehatan.ui.theme.InfoKesehatanTheme

@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Halaman Profile")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = { navController.navigate("homescreen") },
        ) {
            Text("Kembali ke Home")
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun ProfilePreview() {
//    InfoKesehatanTheme {
//        HomeScreen()
//
//    }
//}