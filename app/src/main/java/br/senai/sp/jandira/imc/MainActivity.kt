package br.senai.sp.jandira.imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.imc.screens.BMIResultScreen
import br.senai.sp.jandira.imc.screens.HomeScreen
import br.senai.sp.jandira.imc.screens.UserDataScreen
import br.senai.sp.jandira.imc.ui.theme.IMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMCTheme {
                var navegacao = rememberNavController()
                NavHost(
                    navController = navegacao,
                    startDestination = "home"
                ){
                    composable(route = "home"){ HomeScreen(navegacao) }
                    composable(route = "dados"){ UserDataScreen(navegacao) }
                    composable(route = "result"){ BMIResultScreen(navegacao) }

                }
            }
        }
    }
}
