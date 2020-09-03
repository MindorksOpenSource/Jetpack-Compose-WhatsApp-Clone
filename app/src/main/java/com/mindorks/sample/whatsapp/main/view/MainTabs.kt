package com.mindorks.sample.whatsapp.main.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ConfigurationAmbient
import androidx.compose.ui.unit.dp
import androidx.core.os.ConfigurationCompat
import com.mindorks.sample.whatsapp.main.util.TabScreen

@Composable
fun MainTabs(
    modifier: Modifier = Modifier,
    titles: List<String>,
    tabSelected: TabScreen,
    onTabSelected: (TabScreen) -> Unit
) {
    TabRow(
        selectedTabIndex = tabSelected.ordinal,
        modifier = modifier,
        contentColor = MaterialTheme.colors.onSurface,
        indicator = { },
        divider = { }
    ) {
        titles.forEachIndexed { index, title ->
            val selected = index == tabSelected.ordinal

            var textModifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            if (selected) {
                textModifier =
                    Modifier.border(BorderStroke(2.dp, Color.White), RoundedCornerShape(16.dp))
                        .then(textModifier)
            }

            Tab(
                selected = selected,
                onClick = { onTabSelected(TabScreen.values()[index]) }
            ) {
                Text(
                    modifier = textModifier,
                    text = title.toUpperCase(
                        ConfigurationCompat.getLocales(ConfigurationAmbient.current)[0]
                    )
                )
            }
        }
    }
}
