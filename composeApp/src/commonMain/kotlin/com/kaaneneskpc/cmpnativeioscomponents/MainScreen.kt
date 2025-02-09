package com.kaaneneskpc.cmpnativeioscomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveButton
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveDatePicker
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveIconButton
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveNavigationBar
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveNavigationBarItem
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveScaffold
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveTopAppBar
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.adaptive.icons.AdaptiveIcons
import io.github.alexzhirkevich.cupertino.adaptive.icons.Home
import io.github.alexzhirkevich.cupertino.adaptive.icons.Person
import io.github.alexzhirkevich.cupertino.adaptive.icons.Settings
import io.github.alexzhirkevich.cupertino.rememberCupertinoDatePickerState

@OptIn(ExperimentalAdaptiveApi::class, ExperimentalCupertinoApi::class)
@Composable
fun MainScreen() {
    AdaptiveScaffold(
        topBar = {
            AdaptiveTopAppBar(
                title = { Text(text = "Home") },
                actions = {
                    AdaptiveIconButton(onClick = {}) {
                        Icon(
                            imageVector = AdaptiveIcons.Outlined.Settings,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            AdaptiveNavigationBar {
                AdaptiveNavigationBarItem(
                    selected = true,
                    alwaysShowLabel = false,
                    icon = {
                        AdaptiveIconButton(onClick = {}) {
                            Icon(
                                imageVector = AdaptiveIcons.Outlined.Home,
                                contentDescription = null
                            )
                        }
                    },
                    onClick = {}
                )
                AdaptiveNavigationBarItem(
                    selected = false,
                    alwaysShowLabel = false,
                    icon = {
                        AdaptiveIconButton(onClick = {}) {
                            Icon(
                                imageVector = AdaptiveIcons.Outlined.Person,
                                contentDescription = null
                            )
                        }
                    },
                    onClick = {}
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AdaptiveDatePicker(
                state = rememberCupertinoDatePickerState()
            )
            AdaptiveButton(onClick = {}) {
                Text("Button Text")
            }
        }
    }
}