package br.senai.sp.jandira.imc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssistWalker
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.imc.R

@Composable
fun UserDataScreen(modifier: Modifier = Modifier) {

    var nomeAge = remember {
        mutableStateOf(value = "")
    }

    var nomeWeight = remember {
        mutableStateOf(value = "")
    }

    var nomeHeight = remember {
        mutableStateOf(value = "")
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
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
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
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(25.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                ) {
                    Card(
                        modifier = modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        )
                    ) {
                        Row(
                            modifier = modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth()
                                .background(Color.Black),
                            horizontalArrangement = Arrangement.SpaceEvenly

                        ) {
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
                            ) {
                                Image(
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
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                                .background(color = Color.Black)
                        ) {
                            OutlinedTextField(
                                value = nomeAge.value,
                                onValueChange = { nome ->
                                    nomeAge.value = nome
                                },
                                modifier = Modifier
                                    .padding(top = 50.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                label = { Text(text = stringResource(R.string.Age)) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.AssistWalker,
                                        contentDescription = "",
                                        tint = Color(color = 0xFFAF1515)
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Next
                                ),
                                textStyle = TextStyle(fontSize = 24.sp)
                            )
                            OutlinedTextField(
                                value = nomeWeight.value,
                                onValueChange = { nome ->
                                    nomeWeight.value = nome
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 12.dp),
                                shape = RoundedCornerShape(16.dp),
                                label = { Text(text = stringResource(R.string.weight)) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Balance,
                                        contentDescription = "",
                                        tint = Color(color = 0xFFAF1515)
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Next
                                ),
                                textStyle = TextStyle(fontSize = 24.sp)
                            )
                            OutlinedTextField(
                                value = nomeHeight.value,
                                onValueChange = { nome ->
                                    nomeHeight.value = nome
                                },
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                label = { Text(text = stringResource(R.string.height)) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Height,
                                        contentDescription = "",
                                        tint = Color(color = 0xFFAF1515)
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Decimal,
                                    imeAction = ImeAction.Done
                                ),
                                textStyle = TextStyle(fontSize = 24.sp)
                            )
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .padding(top = 80.dp)
                                .height(60.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(color = 0xFF621313)
                            ),
                            shape = RoundedCornerShape(16.dp),
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                text = stringResource(R.string.calculate),
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi =  true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen()
}