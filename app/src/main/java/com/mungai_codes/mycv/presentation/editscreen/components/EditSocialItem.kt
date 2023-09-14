package com.mungai_codes.mycv.presentation.editscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mungai_codes.mycv.domain.model.Social

@Composable
fun EditSocialItem(
    social: Social,
    onSocialUpdate: (Social) -> Unit,
    modifier: Modifier = Modifier
) {

    var editedSocial by remember {
        mutableStateOf(social)
    }
    val focusManager = LocalFocusManager.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        social.icon?.let { icon ->
            Icon(
                painter = painterResource(id = icon),
                contentDescription = social.name,
                modifier = Modifier.size(30.dp)
            )
        }
        Column {
            Text(
                text = social.name,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
                fontSize = 13.sp
            )
            BasicTextField(
                value = editedSocial.handle,
                onValueChange = {
                    editedSocial = editedSocial.copy(handle = it)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onSocialUpdate(editedSocial)
                        focusManager.clearFocus()
                    }
                ),
                modifier = Modifier
            )
        }
    }
}
