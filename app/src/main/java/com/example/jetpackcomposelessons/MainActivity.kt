package com.example.jetpackcomposelessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposelessons.models.UserProfile
import com.example.jetpackcomposelessons.models.userProfileList
import com.example.jetpackcomposelessons.ui.theme.JetpackComposeLessonsTheme
import com.example.jetpackcomposelessons.widgets.profilecard.ProfileScreen
import com.example.jetpackcomposelessons.widgets.profilecard.UserProfileDetailScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLessonsTheme {
                UsersApplication()
            }
        }
    }
}

@Composable
fun UsersApplication(userProfiles: List<UserProfile> = userProfileList){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list"){
        composable("users_list"){
            ProfileScreen(userProfiles = userProfiles, navController)
        }
        composable(route = "users_detail/{userName}",
            arguments = listOf(navArgument("userName"){
                type = NavType.StringType
            })
        ){nbe->
            nbe.arguments!!.getString("userName")?.let { UserProfileDetailScreen(it) }
        }
    }
}
