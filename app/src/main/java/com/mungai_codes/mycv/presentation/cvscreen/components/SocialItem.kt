package com.mungai_codes.mycv.presentation.cvscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import com.mungai_codes.mycv.domain.model.Social
import com.mungai_codes.mycv.presentation.theme.MyCVTheme

@Composable
fun SocialItem(social: Social, modifier: Modifier = Modifier) {
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
            Text(
                text = social.handle,
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview
@Composable
fun SocialItemPreview() {
    MyCVTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            SocialItem(
                social = Social(
                    name = "Slack",
                    icon = R.drawable.ic_slack,
                    handle = "Moses Mungai"
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}