package io.github.droidkaigi.confsched2022.designsystem.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KaigiTopAppBar(
    showNavigationIcon: Boolean,
    onNavigationIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    title: (@Composable RowScope.() -> Unit),
    trailingIcons: (@Composable RowScope.() -> Unit)? = null,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                title()
                Spacer(modifier = Modifier.weight(1F))
                trailingIcons?.invoke(this)
            }
        },
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(
                    onClick = onNavigationIconClick
                ) {
                    Icon(imageVector = Icons.Default.Menu, "menu")
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme
                .colorScheme
                .surfaceColorAtElevation(elevation)
        )
    )
}
