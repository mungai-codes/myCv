package com.mungai_codes.mycv.presentation.editscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mungai_codes.mycv.presentation.theme.MyCVTheme

@Composable
fun BioEditItem(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
    desc: String? = null,
    onEditText: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif
        )
        OutlinedTextField(
            value = text,
            onValueChange = { onEditText(it) },
            textStyle = TextStyle(fontSize = 14.sp),
            supportingText = {
                desc?.let { desc ->
                    Text(
                        text = desc,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            },
            shape = MaterialTheme.shapes.medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BioEditItemPreview() {
    MyCVTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            BioEditItem(
                label = "Edit your bio",
                text = "A dedicated and highly skilled Android Developer experienced in designing, developing, and maintaining cutting-edge Android applications. Adept at collaborating with cross-functional teams to deliver high-quality, user-friendly mobile solutions. Proficient in Java, Kotlin, and the latest Android technologies, with a passion for staying updated on industry trends.",
                modifier = Modifier.padding(horizontal = 16.dp),
                desc = "bio editing",
                onEditText = {},
            )
        }
    }
}