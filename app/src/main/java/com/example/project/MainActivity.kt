package com.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Header(
                        modifier = Modifier.padding(innerPadding)
                    )
                    microphoneandtext(modifier=Modifier, context = this)
                }
            }
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.header),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic
    )
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HeaderPreview() {
//    ProjectTheme {
//        Header()
//        microphoneandtext(modifier = Modifier, context = this)
//    }
//}