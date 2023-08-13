package com.example.jetpackcomposelessons.widgets.profilecard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelessons.models.UserProfile
import com.example.jetpackcomposelessons.models.userProfileList
import com.example.jetpackcomposelessons.ui.theme.JetpackComposeLessonsTheme

@Composable
fun UserProfileDetailScreen(userName: String){
    var userProfile = userProfileList.first{p-> p.name == userName}
    JetpackComposeLessonsTheme() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column (modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment =Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(userProfile, size = 200.dp)
                ProfileContent(userProfile,
                    nameStyle = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 20.sp, color = Color.Black),
                    activeStyle = TextStyle(fontSize = 16.sp,color = if(userProfile.status) Color.Green else Color.Red),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailScreenPreview(){
    UserProfileDetailScreen(userName = userProfileList[0].name)
}