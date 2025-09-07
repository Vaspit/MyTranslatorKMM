package com.example.my_translator_kmm.android.translate.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.my_translator_kmm.android.R
import com.example.my_translator_kmm.android.core.theme.LightBlue
import com.example.my_translator_kmm.core.presentation.LanguageUi

@Composable
fun LanguageDropDown(
    language: LanguageUi,
    isExpanded: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onSelect: (LanguageUi) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismiss,
        ) {
            LanguageUi.allLanguages.forEach { language ->
                LanguageDropDownItem(
                    language = language,
                    onClick = {
                        onSelect(language)
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = language.drawableRes,
                contentDescription = language.language.langName,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = language.language.langName,
                color = LightBlue
            )
            Icon(
                imageVector = if (isExpanded)
                    {
                        Icons.Default.KeyboardArrowUp
                    } else {
                        Icons.Default.KeyboardArrowUp
                    },
                contentDescription = if (isExpanded) {
                    stringResource(id = R.string.expanded)
                } else {
                    stringResource(id = R.string.folded)
                },
                tint = LightBlue,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}