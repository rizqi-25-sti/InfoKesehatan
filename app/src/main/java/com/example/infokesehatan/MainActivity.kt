package com.example.infokesehatan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.infokesehatan.ui.theme.InfoKesehatanTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InfoKesehatanTheme {
                MyHealthApp(navController = rememberNavController())
            //   Scaffold(
            //       bottomBar = { BottomNavigation() },
                                                    //navController = rememberNavController()
            //   )  {
            //      padding ->
            //      HomeScreen(modifier = Modifier.padding(padding))
            //    }

            }
        }
    }
}


private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga,
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down,
).map { DrawableStringPair(it.first, it.second) }



@Composable
fun SearchBar(
    modifier: Modifier = Modifier ) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(text = stringResource(R.string.placeholder_search))
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
        ), modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 50.dp)

    )
}



@Composable
fun AlignYourBodyElement (
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
    ) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Image (
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size (88.dp)
                .clip (CircleShape)

        )
        Text ( //bisa tambah jarak
            text = stringResource(text),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp,
                bottom = 8.dp
            )
        )
    }
}


@Composable
fun AlignYourBodyRow (
    modifier: Modifier = Modifier
) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items (alignYourBodyData) { item ->
            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}


@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable : Int,
    @StringRes text : Int,
    modifier: Modifier = Modifier
) {
    Surface (
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ){
            Image (
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)

            )
            Text (
                text = stringResource(text),
                style =  MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@Composable
fun FavoriteCollectionsGrid (
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid (
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.height(160.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(80.dp)
            )
        }
    }
}


@Composable
fun HomeSection (
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column (modifier) {
        Text (
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.paddingFromBaseline(40.dp, 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}




@Composable
fun HomeScreen(
    modifier : Modifier = Modifier

    ) {
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}

@Composable
fun BottomNavigation (navController: NavController) {
    NavigationBar (
        containerColor = MaterialTheme.colorScheme.surfaceVariant

    ) {

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null)
                   },

            label = {
                Text(
                    stringResource(R.string.bottom_navigation_home))
                    },
            selected = true,
            onClick = {navController.navigate("homescreen") }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null)
                   },
            label = {
                Text(
                    stringResource(R.string.bottom_navigation_profile)) },
            selected = false,
            onClick = {navController.navigate("profilescreen")  }
        )

    }
}


@Composable
fun SampingNavigationRail(
    navController : NavController,
    modifier : Modifier = Modifier
) {
     NavigationRail(modifier = Modifier.padding(
         start = 8.dp,
         end = 8.dp,
     ),
         containerColor = MaterialTheme.colorScheme.background
     ){
         Column(
             modifier = Modifier.fillMaxHeight(),
             verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
         ) {
             NavigationRailItem(
                 icon = {
                     Icon(
                         imageVector = Icons.Default.Home,
                         contentDescription = null
                     )
                 },
                 label = {
                     Text(
                         stringResource(R.string.bottom_navigation_home)
                     )
                 },
                 selected = true,
                 onClick = { navController.navigate("homescreen") }
             )
             Spacer(modifier = Modifier.height(8.dp))
             NavigationRailItem(
                 icon = {
                     Icon(
                         imageVector = Icons.Default.AccountCircle,
                         contentDescription = null
                     )
                 },
                 label = {
                     Text(
                         stringResource(R.string.bottom_navigation_profile)
                     )
                 },
                 selected = false,
                 onClick = { navController.navigate("profilescreen") }
             )
         }
     }
}



@Composable
fun AppPreview(navController: NavController) {
    InfoKesehatanTheme {
        Scaffold(
            bottomBar = { BottomNavigation(navController) }
        ) { padding ->
            HomeScreen(
                modifier = Modifier.padding(padding))
        }
    }
}


//@Preview (
//device = Devices.AUTOMOTIVE_1024p,
//widthDp = 720,
//heightDp = 360,
//)


@Composable
fun AppLandscape(
    navController: NavController
) {
    Row {
        SampingNavigationRail(navController)
        AppPreview(navController)
    }
}


@Composable
fun MyHealthApp (
    navController: NavController
) {
    val windowSize = currentWindowAdaptiveInfo().windowSizeClass
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {AppPreview(navController)}
        WindowWidthSizeClass.Medium -> {AppPreview(navController)}
        WindowWidthSizeClass.Expanded -> {AppLandscape(navController)}
        else -> {AppPreview(navController)}
    }
}




//    Column(modifier = Modifier) {
//        SearchBar()
//        Spacer(modifier = Modifier.height(16.dp))
//        AlignYourBodyElement(
//            drawable = R.drawable.ab1_inversions,
//            text = R.string.ab1_inversions
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        FavoriteCollectionCard(
//            drawable = R.drawable.fc2_nature_meditations,
//            text = R.string.fc2_nature_meditations
//        )
//    }
//}

