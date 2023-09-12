package com.mungai_codes.mycv.presentation.cvscreen.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mungai_codes.mycv.R
import com.mungai_codes.mycv.presentation.theme.MyCVTheme

@Composable
fun SectionItem(
    title: String,
    @DrawableRes
    imageResourceId: Int,
    expanded: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Surface(
            modifier = Modifier
                .clickable { onClick() },
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = title,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.CenterStart)
                )
                Text(
                    text = title,
                    modifier = Modifier.align(Alignment.Center),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp
                )
            }
        }
        AnimatedVisibility(visible = expanded) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SectionItemPreview() {
    MyCVTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            SectionItem(
                title = "Education",
                imageResourceId = R.drawable.ic_education,
                expanded = true,
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = {}
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(text = "Random Item")
                    Text(text = "Random Item")
                    Text(text = "Random Item")
                    Text(text = "Random Item")
                }
            }
        }
    }
}