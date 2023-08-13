package com.example.jetpackcomposelessons.widgets.profilecard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.jetpackcomposelessons.models.UserProfile
import com.example.jetpackcomposelessons.models.userProfileList
import com.example.jetpackcomposelessons.ui.theme.JetpackComposeLessonsTheme

@Composable
fun ProfileScreen(userProfiles: List<UserProfile>, navController: NavHostController){
    JetpackComposeLessonsTheme() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(){
                items(userProfiles){
                    userProfile -> ProfileCard(userProfile){
                        navController.navigate("users_detail/${userProfile.name}")
                    }
                }
            }

        }
    }
}
@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
     Card (
         colors = CardDefaults.cardColors(
             containerColor = MaterialTheme.colorScheme.surface,
         ),
         shape= CutCornerShape(topEnd = 24.dp),
         modifier = Modifier
             .padding(16.dp)
             .fillMaxWidth()
             .wrapContentHeight(align = Alignment.Top)
             .clickable {  clickAction?.invoke()  },
         elevation = cardElevation(defaultElevation = 8.dp),

     ) {
      Row (modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Start
      ) {
          ProfilePicture(userProfile, size = 100.dp)
          ProfileContent(userProfile,
              nameStyle = TextStyle(
              fontFamily = FontFamily.Cursive,
              fontSize = 16.sp, color = Color.Black),
              activeStyle = TextStyle(
              fontSize = 12.sp,color = if(userProfile.status) Color.Green else Color.Red)
          ) }
    }
}
@Composable
fun ProfilePicture(userProfile: UserProfile, size: Dp){
       Card(
           shape = CircleShape,
           border = BorderStroke(width = 2.dp,color = if(userProfile.status) Color.Green else Color.Red)
       ) {
           AsyncImage(
               modifier = Modifier.size(size),
               contentScale = ContentScale.Crop,
               model = userProfile.pictureUrl,
               contentDescription = "",
           )
//           Image(
//               contentScale = ContentScale.Crop,
//               modifier= Modifier
//                   .width(60.dp)
//                   .height(60.dp),
//               painter = painterResource(id = R.drawable.profile_picture ),
//               contentDescription = "User 1")
       }
}

@Composable
fun ProfileContent(
    userProfile: UserProfile,
    nameStyle: TextStyle,
    activeStyle: TextStyle,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
){
 Column(modifier = Modifier
     .padding(8.dp)
     .fillMaxWidth(),
     horizontalAlignment = horizontalAlignment
 ) {
     Text(userProfile.name,
         modifier = Modifier.padding(10.dp),
         style = nameStyle,
     )
     Text(text = if(userProfile.status) "Active now" else "Inactive",
         modifier = Modifier.padding(start = 10.dp),
         style = activeStyle
     )
 }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    JetpackComposeLessonsTheme() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(){
                items(userProfileList){
                        userProfile -> ProfileCard(userProfile){
                   }
                }
            }

        }
    }
}