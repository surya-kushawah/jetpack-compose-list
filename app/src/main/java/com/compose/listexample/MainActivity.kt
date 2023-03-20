package com.compose.listexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.listexample.ui.theme.ComposeListExampleTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeListExampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(), color = Color(0xFFF1F1F1)
        ) {
          val actorList = fetchActorList()
          ActorList(actorList)
        }
      }
    }
  }
}

@Composable
fun ActorList(actors: List<Actor>) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(8.dp)
  ) {
    LazyColumn {
      items(actors) { actor ->
        ListItem(
          actor,
          backgroundColor = Color.White,
          onItemClick = {
          Log.i("ActorList", "Info $actor")
          },
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ComposeListExampleTheme {
    //Greeting("Android")
  }
}