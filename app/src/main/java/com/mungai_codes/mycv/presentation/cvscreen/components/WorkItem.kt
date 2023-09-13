package com.mungai_codes.mycv.presentation.cvscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mungai_codes.mycv.domain.model.Work
import com.mungai_codes.mycv.presentation.theme.MyCVTheme

@Composable
fun WorkItem(work: Work, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(text = work.organisation, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "from : ${work.from}",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "to : ${work.to}",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        }
        Text(text = work.role, fontFamily = FontFamily.Serif, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = work.description, textAlign = TextAlign.Start,
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif
        )
    }
}

@Preview
@Composable
fun WorkItemPreview() {
    MyCVTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            WorkItem(
                work = Work(
                    from = "sept 2022",
                    to = "dec 2022",
                    organisation = "Mt Kenya University",
                    role = "IT Support",
                    description = "Ensuring the organization's technology operates seamlessly. Handling everything from configuring hardware and software to troubleshooting and resolving technical challenges that arise. Daily tasks involved assisting and educating users on technology issues, safeguarding our network's security, and implementing data backup and recovery measures."
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}