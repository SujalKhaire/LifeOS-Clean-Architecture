package com.sujalkhaire.lifeos.Presentation.Focus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FocusScreen(viewModel: FocusViewModel= hiltViewModel()){

    val avgScore by viewModel.avgScore.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        
        Text(text = "FocusMode", fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(22.dp))
        Text(text = "$avgScore", fontWeight = FontWeight.ExtraBold, color = Color.Red, fontSize = 33.sp)
        Spacer(modifier = Modifier.height(22.dp) )
        Button(onClick = { viewModel.saveSession(25, (15..25).random())}) {
            Text(text = "Get AverageScore", fontWeight = FontWeight.Bold)
        }


        
    }
}