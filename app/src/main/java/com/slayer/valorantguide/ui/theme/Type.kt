package com.slayer.valorantguide.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.slayer.valorantguide.R

object AppFont {
    private val fontName = GoogleFont("Bowlby One SC")

    private val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val fontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider)
    )
}

private val defaultTypography = Typography()

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.fontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.fontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.fontFamily),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.fontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.fontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.fontFamily),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.fontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.fontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.fontFamily),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.fontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.fontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.fontFamily),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.fontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.fontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.fontFamily)
)