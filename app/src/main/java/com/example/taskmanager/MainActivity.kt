package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TasksCompleted(
                        stringResource(R.string.complete_text),
                        stringResource(R.string.compliment_text))
                }
            }
        }
    }
}

@Composable
fun TasksCompleted(completeText: String, complement: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Box (modifier = modifier
        .fillMaxSize()
        .wrapContentSize()
    ) {
        Column (modifier = modifier.align(Alignment.Center)){
            Image(
                painter = image,
                contentDescription = null
            )
            Text(
                text = completeText,
                fontWeight = Bold,
                modifier = modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 24.dp, bottom = 8.dp)


            )
            Text(
                text = complement,
                fontSize = 16.sp,
                modifier = modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TasksCompleted("All tasks completed", "Nice work!" )
    }
}