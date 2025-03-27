package br.senai.sp.jandira.imc.screens

import android.content.Context
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
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
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
import androidx.navigation.NavHostController
import br.senai.sp.jandira.imc.R

@Composable
fun UserDataScreen(navegacao: NavHostController) {

    var ageState = remember {
        mutableStateOf(value = "")
    }

    var weightState = remember {
        mutableStateOf(value = "")
    }

    var heightState = remember {
        mutableStateOf(value = "")
    }

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val editor = userFile.edit()

    val userName = userFile.getString("user_name", "User name not found!")

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
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(
                    R.string.hi
                ) + ", $userName!",
                modifier = Modifier
                    .padding(top = 45.dp)
                    .padding(horizontal = 10.dp),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth()
                                .background(Color.Black),
                            horizontalArrangement = Arrangement.SpaceEvenly

                        ) {
                            Column(
                                modifier = Modifier
                            ) {
                                Card(
                                    modifier = Modifier
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
                                        modifier = Modifier
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
                                modifier = Modifier
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
                                    modifier = Modifier
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
                                value = ageState.value,
                                onValueChange = { it ->
                                    ageState.value = it
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = Color.White
                                ),
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
                                value = weightState.value,
                                onValueChange = { it ->
                                    weightState.value = it
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = Color.White
                                ),
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
                                value = heightState.value,
                                onValueChange = { it ->
                                    heightState.value = it
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = Color.White
                                ),
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
                            onClick = {
                                editor.putInt("user_age", ageState.value.toInt())
                                editor.putFloat("user_weight", weightState.value.toFloat())
                                editor.putFloat("user_height", heightState.value.toFloat())
                                editor.apply()
                                navegacao.navigate(route = "result")
                            },
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
    //UserDataScreen()
}