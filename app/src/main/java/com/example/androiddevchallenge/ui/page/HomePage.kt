package com.example.androiddevchallenge.ui.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.util.ComposeContent

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.Model
import com.example.androiddevchallenge.data.Repository
import com.example.androiddevchallenge.ui.theme.elevationCard
import com.google.accompanist.glide.GlideImage
import org.intellij.lang.annotations.JdkConstants

@Composable
fun CardItem(modifier: Modifier = Modifier, model: Model) {
    Card(
        modifier = modifier
            .size(136.dp),
        shape = MaterialTheme.shapes.small,
        elevation = elevationCard,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column {
            GlideImage(
                data = model.url,
                contentDescription = model.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = model.title,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(start = 16.dp)
                    .paddingFromBaseline(top = 24.dp),
                maxLines = 1
            )
        }
    }
}

@Composable
fun ListItem(modifier: Modifier = Modifier, model: Model) {
    var itemChecked by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .height(64.dp)
            .clickable {
                itemChecked = !itemChecked
            }
            .padding(start = 16.dp)
    ) {
        GlideImage(
            data = model.url,
            contentDescription = model.title,
            modifier = Modifier
                .fillMaxHeight()
                .width(64.dp)
                .align(Alignment.CenterVertically),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = model.title,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
            )
            Text(
                text = "This is a description",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .paddingFromBaseline(top = 16.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Checkbox(
            checked = itemChecked,
            onCheckedChange = { itemChecked = it },
            modifier = Modifier
                .padding(end = 16.dp)
                .size(24.dp)
                .align(Alignment.CenterVertically),
            colors = CheckboxDefaults.colors(
                checkmarkColor = MaterialTheme.colors.onSecondary
            )
        )
    }
}

@Composable
fun HomeFragment() {
    Column {
        var searchText by remember { mutableStateOf("") }

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Search,
                    "search",
                    modifier = Modifier.size(18.dp)
                )
            },
            label = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary
                )
            },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 16.dp, end = 16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colors.onPrimary,
                cursorColor = MaterialTheme.colors.onPrimary,
                focusedBorderColor = MaterialTheme.colors.onPrimary,
                unfocusedBorderColor = MaterialTheme.colors.onPrimary,
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {

                }
            )
        )

        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp)
                .padding(start = 16.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(top = 16.dp)
                .height(144.dp)
                .fillMaxWidth()
        ) {
            item {
                Repository.get().forEachIndexed { i, data ->
                    CardItem(
                        modifier = Modifier
                            .padding(start = if (i == 0) 16.dp else 0.dp, end = 8.dp)
                            .clickable {
                                //
                            },
                        model = data
                    )
                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .paddingFromBaseline(top = 24.dp)
                    .padding(start = 16.dp)
            )
            Icon(
                Icons.Outlined.FilterList,
                "filter",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp)
                    .size(24.dp)
                    .clickable {

                    }
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
        ) {
            item {
                Repository.get().forEachIndexed { i, data ->
                    ListItem(
                        modifier = Modifier.padding(
                            top = if (i == 0) 16.dp else 8.dp
                        ),
                        model = data
                    )
                }
            }
        }
    }
}

@Composable
fun SimpleFragment(title: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = title,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

class TabConfig(
    val name: String,
    val normal: ImageVector,
    val focus: ImageVector
)

val tabs = listOf(
    TabConfig("Home", Icons.Outlined.Home, Icons.Filled.Home),
    TabConfig("Favorites", Icons.Outlined.FavoriteBorder, Icons.Filled.Favorite),
    TabConfig("Profile", Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle),
    TabConfig("Cart", Icons.Outlined.ShoppingCart, Icons.Filled.ShoppingCart)
)

val HomePage: ComposeContent = {
    Column {
        var selectTab by remember {
            mutableStateOf(0)
        }
        Box(modifier = Modifier.weight(1f)) {
            if (selectTab == 0) {
                HomeFragment()
            } else {
                SimpleFragment(title = tabs[selectTab].name)
            }
        }

        BottomNavigation(
            modifier = Modifier
                .height(56.dp),
            backgroundColor = MaterialTheme.colors.primary
        ) {
            tabs.onEachIndexed { i, data ->
                BottomNavigationItem(
                    selected = (selectTab == i),
                    onClick = { selectTab = i },
                    selectedContentColor = MaterialTheme.colors.onPrimary,
                    icon = {
                        Icon(
                            imageVector = if (selectTab == i) data.focus else data.normal,
                            contentDescription = data.name,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = data.name,
                            style = MaterialTheme.typography.caption
                        )
                    })
            }
        }
    }

}

@Preview
@Composable
fun PreviewCardItem() {
    ListItem(model = Repository.get()[0])
}

@Preview
@Composable
fun PreviewListItem() {
    ListItem(model = Repository.get()[0])
}
