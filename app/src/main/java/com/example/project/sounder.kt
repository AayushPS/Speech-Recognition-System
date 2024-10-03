package com.example.project

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun microphoneandtext(modifier: Modifier=Modifier, context: Context){
    val au: MediaPlayer = MediaPlayer.create(context,R.raw.clicksound)
    var stateofmic by remember { mutableStateOf(0) }
    var img: Int by remember { mutableStateOf(R.drawable.baseline_mic_off_24) }
    var cont: String by remember { mutableStateOf("Nothing here yet!") }
    when(stateofmic){
        1->img= R.drawable.baseline_mic_24
        else->img= R.drawable.baseline_mic_off_24
    }
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                if(stateofmic==1){
                    stateofmic = 0
                }else{
                    stateofmic = 1
                }
                au.start()
            },
            colors = ButtonColors(
                contentColor = Color.Transparent,
                containerColor = Color.Transparent,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.LightGray
            ),
            shape = ButtonDefaults.shape

        ) {
            Image(
                painter = painterResource(id = img),
                modifier = modifier,
                contentDescription = stringResource(R.string.micstate),
                contentScale = ContentScale.Fit
            )
        }
        TextField(value = cont,
            onValueChange = {},
            readOnly = true,

            )
    }
}