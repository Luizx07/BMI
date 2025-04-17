package br.senai.sp.jandira.imc.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.imc.R
import br.senai.sp.jandira.imc.calcs.bmiCalculate
import br.senai.sp.jandira.imc.model.BmiStatus
import br.senai.sp.jandira.imc.screens.components.BmiLevel
import br.senai.sp.jandira.imc.utils.convertNumberToLocale


@Composable
fun BMIResultScreen(navegacao: NavHostController) {

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)



    val userAge = userFile.getInt("user_age",0)
    val userWeight = userFile.getFloat("user_weight",0.0f)
    val userHeight = userFile.getFloat("user_height",0.0f)

    val  bmi = bmiCalculate(
        userWeight, userHeight.toDouble().div(100))

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
            ),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.BMIResult),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Card(
                modifier = Modifier
                .fillMaxSize()
                .weight(5f),
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                ),
                ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color(color = 0xFF621313)),
                        colors = CardDefaults.cardColors(
                            containerColor = bmi.bmiColor
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = String.format(
                                    java.util.Locale.getDefault(),
                                   "%.1f",
                                    bmi.bmi.second
                                ),
                                color = bmi.bmiColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp
                            )
                        }
                    }
                     Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = bmi.bmi.first,
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .width(85.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF621313)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp)

                        ) {
                            Column(
                                modifier = Modifier
                                    .width(95.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.Age2),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userAge",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                            VerticalDivider()
                            Column(
                                modifier = Modifier
                                    .width(125.dp)
                                    .width(120.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.weight2),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userWeight kg",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                            VerticalDivider()
                            Column(
                                modifier = Modifier
                                    .width(125.dp)
                                    .width(120.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.high),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = String.format(java.util.Locale.getDefault(), format = "%.2f", userHeight),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                        Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(start = 12.dp, end = 12.dp, top = 10.dp)
                    ){
                        BmiLevel(
                            bulletColor = colorResource(R.color.light_blue),
                            leftText = stringResource(R.string.underWeight),
                            rightText = "< ${convertNumberToLocale(18.5)}",
                            isFilled = if (bmi.bmiStatus == BmiStatus.UNDER_WEIGHT) true
                            else false

                        )
                        BmiLevel(
                            bulletColor = colorResource(R.color.light_green),
                            leftText = stringResource(R.string.normal),
                            rightText = " ${convertNumberToLocale(18.6 - 24.9)}",
                            isFilled = if (bmi.bmiStatus == BmiStatus.NORMAL) true
                            else false
                        )
                        BmiLevel(
                            bulletColor = colorResource(R.color.yellow),
                            leftText = stringResource(R.string.over),
                            rightText = " ${convertNumberToLocale(25.0 - 29.9)}",
                            isFilled = if (bmi.bmiStatus == BmiStatus.OVER_WEIGHT) true
                            else false
                        )
                        BmiLevel(
                            bulletColor = colorResource(R.color.light_orange),
                            leftText = stringResource(R.string.obesi1),
                            rightText = " ${convertNumberToLocale(30.0 - 34.9)}",
                            isFilled = if (bmi.bmiStatus == BmiStatus.OBSESITY_1) true
                            else false
                        )
                        BmiLevel(
                            bulletColor = colorResource(R.color.dark_orange),
                            leftText = stringResource(R.string.obesi2),
                            rightText = " ${convertNumberToLocale(35.0 - 39.9)}",
                            isFilled = if (bmi.bmiStatus == BmiStatus.OBSESITY_2) true
                            else false
                        )
                        BmiLevel(
                            bulletColor = colorResource(R.color.red),
                            leftText = stringResource(R.string.obesi3),
                            rightText = "> ${convertNumberToLocale(39.9)}",
                            isFilled = if (bmi.bmiStatus == BmiStatus.OBSESITY_3) true
                            else false
                        )
                    }
                    HorizontalDivider()
                    Button(
                        onClick = {
                            navegacao.navigate(route = "home")
                        },
                        modifier = Modifier
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
                            text = stringResource(R.string.NewCalc),
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi =  true)
@Composable
private fun BMIResultScreenPreview() {
    //BMIResultScreen()
}