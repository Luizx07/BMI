package br.senai.sp.jandira.imc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.imc.R

@Composable
fun UserDataScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFFAF1515),
                        Color(0xFF621313)

                    )
                )
            )
    ) { Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = stringResource(
                R.string.hi
            ),
            modifier = modifier
                .padding(top = 45.dp)
                .padding(horizontal = 20.dp),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 35.dp),
            shape = RoundedCornerShape(
                topStart = 24.dp,
                topEnd = 24.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            )
        ) { Column(
            modifier = modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End,
        ){
            Card(
                modifier = modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(Color.Black),
                    horizontalArrangement = Arrangement.SpaceEvenly

                ){
                    Column(
                        modifier = modifier
                    ) {
                        Card(
                            modifier = modifier
                                .size(170.dp)
                                .padding(horizontal = 20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black
                            )
                        ) {
                            Image(
                                painter = painterResource(
                                    R.drawable.macho
                                ),
                                contentDescription = stringResource(
                                    R.string.genM
                                ),
                            )
                            Button(
                                modifier = modifier
                                    .padding(2.dp)
                                    .width(210.dp),
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF621313)
                                )
                            ) {
                                Text(
                                    text = stringResource(
                                        R.string.genreM
                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = modifier
                            .size(170.dp)
                            .padding(horizontal = 20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        )
                    ) {Image(
                        painter = painterResource(
                            R.drawable.femea
                        ),
                        contentDescription = stringResource(
                            R.string.genF
                        ),
                    )
                        Button(
                            modifier = modifier
                                .padding(2.dp)
                                .width(210.dp),
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF621313)
                            )
                        ) {
                            Text(
                                text = stringResource(
                                    R.string.genreM
                                )
                            )
                        }
                    }
                }}
            }
        } }
    } }

@Preview(showSystemUi =  true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen()
}