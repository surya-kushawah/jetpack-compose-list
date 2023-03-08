package com.compose.listexample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Preview
@Composable
fun ListItem(
  actor: Actor = Actor(1, "Surya", "New Delhi, IN", "https://androidwave.com"),
  backgroundColor:Color=Color.LightGray,
  onItemClick: () -> Unit= {},
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .clip(RoundedCornerShape(5.dp))
      .clickable { onItemClick() }
      .padding(8.dp)
      .background(backgroundColor)
  ) {
    Row(
      modifier = modifier
        .padding(16.dp)
    ) {
      AsyncImage(
        model = actor.photo,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .size(80.dp)
          .border(
            width = 1.dp,
            color = Color.LightGray,
            shape = CircleShape
          )
          .padding(3.dp)
          .clip(CircleShape)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Column(
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = actor.name,
          fontWeight = FontWeight.SemiBold,
          fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = actor.birthPlace,
          fontSize = 16.sp,
          fontWeight = FontWeight.Light
        )
      }
    }
  }
}