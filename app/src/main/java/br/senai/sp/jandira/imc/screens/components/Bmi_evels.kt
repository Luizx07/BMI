package br.senai.sp.jandira.imc.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BmiLevel(
    bulletColor: Color,
    leftText : String,
    rightText : String,
    isFilled : Boolean
){

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(40.dp),
                shape = CircleShape,
                colors = CardDefaults
                    .cardColors(
                        containerColor = bulletColor
                    )
            ) { }
            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )
            Card(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                colors = CardDefaults
                    .cardColors(
                        containerColor =
                        if (isFilled) bulletColor
                        else Color.Transparent
                    ),
                shape = RoundedCornerShape(6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = leftText)
                    Text(text = rightText)
                }
            }
        }
}

@Preview(showSystemUi =  true)
@Composable
private fun ResultPreview() {
    //BmiLevel()
}