package com.kaaneneskpc.cmpnativeioscomponents

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import io.github.alexzhirkevich.cupertino.adaptive.CupertinoThemeSpec
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.adaptive.MaterialThemeSpec
import io.github.alexzhirkevich.cupertino.adaptive.Theme
import io.github.alexzhirkevich.cupertino.theme.CupertinoTheme

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppTheme(
            theme = if(getPlatform().name == "Android") Theme.Material3 else Theme.Cupertino,
        ) {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun AppTheme(
    theme: Theme,
    content: @Composable () -> Unit
) {
    AdaptiveTheme(
        target = theme,
        material = MaterialThemeSpec.Default(),
        cupertino = CupertinoThemeSpec.Default(
            CupertinoTheme.colorScheme.copy(
                accent = Color.Red
            )
        ),
        content = content
    )

}
