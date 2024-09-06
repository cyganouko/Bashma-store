

package com.example.bashmastore.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bashmastore.R
import com.example.bashmastore.navigation.ADD_PRODUCTS_URL
import com.example.bashmastore.navigation.ROUT_LADSWEAR
import com.example.bashmastore.navigation.ROUT_LOGIN
import com.example.bashmastore.navigation.ROUT_MENSOUTFIT
import com.example.bashmastore.navigation.ROUT_NIKE
import com.example.bashmastore.navigation.ROUT_SIGNUP
import com.example.bashmastore.navigation.ROUT_SNEAKERS
import com.example.bashmastore.ui.theme.brown
import com.example.bashmastore.ui.theme.screens.login.LoginScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()){
        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = brown
                ) {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {

                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },
            topBar = {
                TopAppBar(title = { Text(text = "Bienvenue", fontFamily = FontFamily.Cursive, fontSize = 40.sp)},
                    colors = TopAppBarDefaults.mediumTopAppBarColors(brown),
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "menu",
                                tint = Color.DarkGray
                            )


                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Notifications, contentDescription = "")

                        }

                    }
                    )


            },


            floatingActionButton = {
                FloatingActionButton(onClick = { ADD_PRODUCTS_URL}) {
                    IconButton(onClick = { ADD_PRODUCTS_URL }){
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(top = 80.dp, start = 20.dp),

                    ) {
                    val mContext = LocalContext.current
//search bar)
                    var search by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = search, onValueChange = { search = it },
                        label = { Text(text = "Search on Bashma Store") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "search"
                            )

                        }


                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .horizontalScroll(rememberScrollState())
                            .height(150.dp)


                    ) {


                        //CARD1
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.flash),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD2
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.flash2),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD3
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.flash3),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.flash4),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card

                    }



                    //ROW 2

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .horizontalScroll(rememberScrollState())
                            .height(80.dp)


                    ) {


                        //CARD1
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SNEAKERS) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD2
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_NIKE) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner2),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD3
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_MENSOUTFIT) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner3),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_LADSWEAR) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner4),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card

                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)

                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner5),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }

                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)

                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner6),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }

                    }

                    //ROW 3


                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .horizontalScroll(rememberScrollState())
                            .height(120.dp)


                    ) {


                        //CARD1
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SNEAKERS) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.sneak1),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text ="Sneakers",
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.ExtraBold


                                )


                            }


                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD2
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_MENSOUTFIT) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.men2),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text ="Men's Outfit",
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.ExtraBold


                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD3
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_LADSWEAR) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.lad11),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text ="Ladies Wear",
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.ExtraBold


                                )
                            }


                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SNEAKERS) }
                        ) {
                            Box(
                                modifier = Modifier

                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner4),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text ="Nike",
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.ExtraBold


                                )
                            }

                        }
                        //End of card

                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_MENSOUTFIT) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.men11),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }

                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_LADSWEAR) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner6),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }

                    }
                    //ROW 4
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .height(50.dp)
                            .background(brown)


                    ) {
                        Text(
                            text ="Top deals" +""+
                                    " up to 30% off",
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.Cursive,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )








            }

                    //ROW 5


                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .horizontalScroll(rememberScrollState())
                            .height(120.dp)


                    ) {


                        //CARD1
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SIGNUP) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.sneak12),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )



                            }


                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD2
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SIGNUP) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.men4),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD3
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SIGNUP) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.men5),
                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SIGNUP) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.banner4),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                        //End of card

                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SIGNUP) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.lad10),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }

                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                        //CARD4
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(100.dp)
                                .clickable { navController.navigate(ROUT_SIGNUP) }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.sneak10),

                                    contentDescription = "home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }

                    }

                }

            })
    }}















val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),

    BottomNavItem(
        title = "Cartegories",
        route="add_products",
        selectedIcon=Icons.Filled.Add,
        unselectedIcon=Icons.Outlined.Add,
        hasNews = true,
        badges=1
    ),

    BottomNavItem(
        title = "Account",
        route="detail",
        selectedIcon=Icons.Filled.AccountCircle,
        unselectedIcon=Icons.Outlined.AccountCircle,
        hasNews = true,
        badges=1
    ),

    BottomNavItem(
        title = "help",
        route="intent",
        selectedIcon=Icons.Filled.Call,
        unselectedIcon=Icons.Outlined.Call,
        hasNews = true,
        badges=1
    ),



    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController() )
}

