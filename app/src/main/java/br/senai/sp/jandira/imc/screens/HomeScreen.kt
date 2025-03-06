package br.senai.sp.jandira.imc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
fun HomeScreen(modifier: Modifier = Modifier) {

    var nameState = remember {
        mutableStateOf("")
    }

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
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(
                    R.drawable.img
                ),
                contentDescription = stringResource(
                    R.string.logo
                ),
                modifier = Modifier
                    .padding(top = 40.dp)
            )
            Text(
                text = stringResource(
                    R.string.welcome
                ),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                )
            ) { Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ){Column(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(
                        R.string.your_name
                    ),
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                TextField(
                    value = nameState.value,
                    onValueChange = {
                        nameState.value = it
                    },
                    label = { Text("digite seu nome") },
                    textStyle = TextStyle(color = Color.White,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .background(color = Color.Black),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =  KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "",
                            tint = Color(0xFFAF1515)
                        )
                    }
                )
            }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF621313)
                    )

                ) {
                    Text(
                        text = stringResource(
                            R.string.Next
                        )
                    )
                }
            }
            }
        }
    }
}

@Preview(showSystemUi =  true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}