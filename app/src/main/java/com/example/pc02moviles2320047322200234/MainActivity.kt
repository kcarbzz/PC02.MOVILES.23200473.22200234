package com.example.pc02moviles2320047322200234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier
import com.example.pc02moviles2320047322200234.presentation.home.ListadoScreen

import com.example.pc02moviles2320047322200234.ui.theme.PC02MOVILES2320047322200234Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PC02MOVILES2320047322200234Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListadoScreen()

                }
            }
        }
    }
}
