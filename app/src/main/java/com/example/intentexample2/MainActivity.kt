package com.example.intentexample2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext

import com.example.intentexample2.IntentHandler


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current // Access the Context using LocalContext
            Scaffold(
                content = { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 64.dp),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            HomeScreen(context)
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun HomeScreen(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        IntentButton(text = "Facebook", onClick = { IntentHandler.onFacebookButtonClick(context) }, modifier = Modifier.fillMaxWidth())
        IntentButton(text = "Instagram", onClick = { IntentHandler.onInstagramButtonClick(context) }, modifier = Modifier.fillMaxWidth())
        IntentButton(text = "Twitter", onClick = { IntentHandler.onTwitterButtonClick(context) }, modifier = Modifier.fillMaxWidth())
        IntentButton(text = "Google", onClick = { IntentHandler.onGoogleButtonClick(context) }, modifier = Modifier.fillMaxWidth())
        IntentButton(text = "Camera", onClick = { IntentHandler.onCameraButtonClick(context) }, modifier = Modifier.fillMaxWidth())
        IntentButton(text = "Photos", onClick = { IntentHandler.onPhotosButtonClick(context) }, modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun IntentButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF224CD6))
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxSize(),
            colors = ButtonDefaults.buttonColors(Color(0xFF224CD6)),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text, color = Color.White, fontSize = 20.sp)
        }
    }
}

