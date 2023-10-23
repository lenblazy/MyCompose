package com.lenibonje.mycompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Large Font",
    group = "Large Font Group",
    fontScale = 1.5f,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Normal Font",
    group = "Normal Font Group",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Small Font",
    group = "Small Font Group",
    fontScale = 0.5f,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
annotation class FontScalePreviews

@Preview(name = "Pixel XL", group = "Devices", showSystemUi = true, device = Devices.PIXEL_XL,)
@Preview(name = "Pixel 2", group = "Devices", showSystemUi = true, device = Devices.PIXEL_2,)
@Preview(name = "Pixel 3", group = "Devices", showSystemUi = true, device = Devices.PIXEL_3,)
@Preview(name = "Pixel 4", group = "Devices", showSystemUi = true, device = Devices.PIXEL_4,)
annotation class DevicePreviews