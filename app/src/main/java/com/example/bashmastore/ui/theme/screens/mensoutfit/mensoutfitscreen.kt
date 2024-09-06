package com.example.bashmastore.ui.theme.screens.mensoutfit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bashmastore.R
import com.example.bashmastore.ui.theme.brown
import com.example.bashmastore.ui.theme.nike.NikeScreen
import com.example.bashmastore.ui.theme.screens.home.BottomNavItem
import com.example.bashmastore.ui.theme.screens.home.bottomNavItems



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MensOutfitScreen(navController: NavController){


    Column(modifier = Modifier

        .fillMaxSize()){
        var selected by remember { mutableIntStateOf(0) }
        Column {
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

                                        Icon(
                                            imageVector =
                                            if (index == selected)
                                                bottomNavItem.selectedIcon
                                            else
                                                bottomNavItem.unselectedIcon,
                                            contentDescription = bottomNavItem.title
                                        )
                                    }

                                },
                                label = {
                                    Text(text = bottomNavItem.title)
                                })
                        }
                    }
                },
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Bashma Store", fontFamily = FontFamily.Cursive) },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(brown),

                        )


                },


                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "menu"
                            )
                        }
                    }
                },
                //Content Section
                content = @Composable {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                            .padding(top = 80.dp, start = 20.dp),

                        ) {
                        val mContext = LocalContext.current

                        //Start of Row
                        Row {
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
                                        painter = painterResource(id = R.drawable.men2),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 1350",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "321 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(15.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        //Start of Row 2
                        Row {
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
                                        painter = painterResource(id = R.drawable.men3),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 1450",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "562 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(20.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Start of Row
                        Row {
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
                                        painter = painterResource(id = R.drawable.men4),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 1750",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "879 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(22.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }
                        Spacer(modifier = Modifier.height(15.dp))


                        //Start of Row
                        Row {
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
                                        painter = painterResource(id = R.drawable.men6),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 2200",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "687 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(22.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Start of Row
                        Row {
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
                                        painter = painterResource(id = R.drawable.men6),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 1890",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "362 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(20.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Start of Row
                        Row {
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
                                        painter = painterResource(id = R.drawable.men7),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 1760",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "279 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(15.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        //Start of Row
                        Row {
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
                                        painter = painterResource(id = R.drawable.men9),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 1999",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "416 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(20.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        //Start of Row
                        Row {
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
                                        painter = painterResource(id = R.drawable.men10),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(10.dp),
                                        tint = Color.Red
                                    )
                                }

                            }
                            Column(modifier = Modifier.padding(start = 20.dp)) {
                                Text(text = "Limited Edition", fontSize = 20.sp)
                                Text(
                                    text = "ksh 1899",
                                    fontFamily = FontFamily.Cursive,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "star",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Text(text = "512 Orders")
                                Button(
                                    onClick = {
                                        val callIntent = Intent(Intent.ACTION_DIAL)
                                        callIntent.data = "tel:0741697594".toUri()

                                        mContext.startActivity(callIntent)
                                    },
                                    colors = ButtonDefaults.buttonColors(brown),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    //CALL

                                    Button(
                                        onClick = {
                                            val callIntent = Intent(Intent.ACTION_DIAL)
                                            callIntent.data = "tel:0741697594".toUri()
                                            mContext.startActivity(callIntent)
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 20.dp)
                                            .height(50.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Black),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone,
                                            contentDescription = "Phone",
                                            tint = Color.White,
                                            modifier = Modifier.size(70.dp)
                                        )

                                    }

                                }
                            }

                        }
                        //End of Row
                        Spacer(modifier = Modifier.height(15.dp))

                        //STK

                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 20.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "STK")

                        }

                    }

                })


        }


    }








    val bottomNavItems = listOf(
        BottomNavItem(
            title = "Home",
            route="home",
            selectedIcon= Icons.Filled.Home,
            unselectedIcon= Icons.Outlined.Home,
            hasNews = false,
            badges=0
        ),



        BottomNavItem(
            title = "Details",
            route="detail",
            selectedIcon= Icons.Filled.Info,
            unselectedIcon= Icons.Outlined.Info,
            hasNews = true,
            badges=1
        ),

        BottomNavItem(
            title = "Property",
            route="intent",
            selectedIcon= Icons.Filled.FavoriteBorder,
            unselectedIcon= Icons.Outlined.Favorite,
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















}

@Composable
@Preview(showBackground = true)
fun MensOutfitScreenPreview(){
    MensOutfitScreen(rememberNavController() )
}