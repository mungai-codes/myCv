package com.mungai_codes.mycv.presentation.cvscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mungai_codes.mycv.domain.model.Education
import com.mungai_codes.mycv.presentation.theme.MyCVTheme

@Composable
fun EducationItem(education: Education, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = education.institution,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "from : ${education.from}",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "to : ${education.to}",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 12.sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = education.qualification,
                fontFamily = FontFamily.Serif, fontSize = 14.sp
            )
            Text(
                text = education.grade,
                fontFamily = FontFamily.Serif, fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
fun EducationItemPreview() {
    MyCVTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            EducationItem(
                education = Education(
                    from = "2013",
                    to = "2017",
                    institution = "Kahuho Uhuru High School",
                    qualification = "KCPE",
                    grade = "B+"
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}