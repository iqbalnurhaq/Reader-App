package com.nurhaq.reader.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.nurhaq.reader.R
import com.nurhaq.reader.data.MBook
import com.nurhaq.reader.navigation.ReaderScreens

@Composable
fun Home(navController: NavController = NavController(LocalContext.current)) {
    Scaffold(
        topBar = {
            ReaderAppBar(
                title = "A.Reader",
                navController = navController,
            )
        },
        floatingActionButton = {
            FABContent() {

            }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeContent(navController)
        }
    }
}

@Composable
fun HomeContent(
    navController: NavController
) {
    Column(
        Modifier.padding(2.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.align(alignment = Alignment.Start)
        ) {
            TitleSection(
                label = "Your reading \n" + "activity right now...",
            )

            Column{
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable { }
                        .size(45.dp),
                    tint = MaterialTheme.colors.secondaryVariant
                )
                Text(
                    text = "Name",
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.overline,
                    color = Color.Red,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Divider()
            }
        }
    }
}

@Composable
fun ReaderAppBar(
    title: String,
    showProfile: Boolean = true,
    navController: NavController
){
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (showProfile) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "icon",
                        modifier = Modifier.clip(RoundedCornerShape(12.dp))
                    )
                }
                Text(
                    text = title,
                    color = Color.Red.copy(alpha = 0.7f),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }
        },
        actions = {
                  IconButton(
                      onClick = {
                        FirebaseAuth.getInstance().signOut().run {
                            navController.navigate(ReaderScreens.LoginScreen.name)
                        }
                      },
                  ) {
                      Icon(
                          imageVector = Icons.Filled.Logout,
                          contentDescription = "Logout",
//                          tint = Color.Green.copy(alpha = 0.4f)
                      )
                  }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}


@Composable
fun TitleSection(
    modifier: Modifier = Modifier,
    label: String
){
    Surface(
        modifier = modifier.
                padding(
                    start = 5.dp,
                    top = 1.dp
                )
    ) {
        Column{
            Text(
                text = label,
                fontSize = 19.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Left

            )
        }
    }
}

@Composable
fun ReadingRightNowArea(
    books: List<MBook>,
    navController: NavController
){

}


@Composable
fun FABContent(
    onTap: () -> Unit
) {
    FloatingActionButton(
        onClick = {onTap()},
        shape = RoundedCornerShape(50.dp),
        backgroundColor = Color(0xFF92CBDF)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a Book",
            tint = Color.White
        )
    }
}
