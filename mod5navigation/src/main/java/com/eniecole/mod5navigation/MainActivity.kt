package com.eniecole.mod5navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.eniecole.mod5navigation.ui.screen.HomeScreen
import com.eniecole.mod5navigation.ui.screen.SignInScreen
import com.eniecole.mod5navigation.ui.theme.DemonstrationsTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//@Serializable
//object SignIn

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SignIn
    ){
        //Lors de la construction de la route,
        //envoyer l'email
        composable<Home>{ backStackEntry ->
            val home:Home =backStackEntry.toRoute()
            HomeScreen(email=home.email)
        }
        composable<SignIn>{
            SignInScreen(onClickSignIn = {email-> 
                navController.navigate(Home(email))
            })
        }
    }
}

@Serializable
data class Home(val email: String)

@Serializable
object  SignIn

