package com.example.signup

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import com.example.signup.ui.theme.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterialApi
@Composable
fun GoogleButton(
    text: String = "Sign up with Google",
    loadingText: String = "Creating Google Account"
){
    var clicked by remember{ mutableStateOf(false)}

    Surface(
        onClick = {clicked=!clicked},
        shape = Shapes.medium,
        border = BorderStroke(1.dp, color = Color.LightGray),
        color = MaterialTheme.colors.surface
    ) {
        Row(modifier=Modifier
            .padding(
                start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp,
            )
            .animateContentSize (animationSpec = tween(
                durationMillis = 350,
                easing = LinearOutSlowInEasing)
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Icon(painter = painterResource(id = R.drawable.google_logo), contentDescription ="Google Button",tint=Color.Unspecified)
            Spacer(modifier = Modifier.width(12.dp))
            Text(if (clicked) loadingText else text, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(12.dp))
            if (clicked){
                CircularProgressIndicator(modifier = Modifier
                    .width(16.dp)
                    .height(16.dp), strokeWidth = 5.dp, color = MaterialTheme.colors.primary)
            }
        }
    }

}

@ExperimentalMaterialApi
@Composable
@Preview
private fun GoogleButtonPreview(){
    GoogleButton()
}