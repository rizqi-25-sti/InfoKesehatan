package com.example.infokesehatan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = CyberBlue,
    secondary = CyberBlue,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = DarkNavy,             // Warna tombol utama, top bar, dll.
    secondary = CyberBlue,          // Warna aksen/highlight
    background = BackgroundLight,   // Warna latar belakang layar
    surface = SurfaceLight,         // Warna kartu (Card) atau SearchBar
    surfaceVariant = Color(0xFFE2E8F0), // Warna Navigasi Bawah (Abu-abu TI lembut)
    onPrimary = Color.White,        // Warna teks di atas warna primary
    onBackground = Color(0xFF1A202C), // Warna teks utama
    onSurface = Color(0xFF1A202C)
)

@Composable
fun InfoKesehatanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Kamu bisa matikan dulu dynamicColor (fitur Android 12+)
    // supaya warna yang kamu buat di atas tidak ditimpa oleh wallpaper HP.
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Tetap gunakan typography bawaanmu
        content = content
    )
}