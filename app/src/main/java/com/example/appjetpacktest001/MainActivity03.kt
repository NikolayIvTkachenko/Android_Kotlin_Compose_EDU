package com.example.appjetpacktest001

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter

import com.example.appjetpacktest001.ui.theme.AppJetPackTest001Theme
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language


//https://metanit.com/kotlin/jetpack/2.10.php
//https://developer.android.com/develop/ui/compose/components/chip?hl=ru
//https://www.ebookfrenzy.com/retail/compose/index.php

class MainActivity03 : ComponentActivity() {

    private var itemArray: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemArray = resources.getStringArray(R.array.car_array)

        setContent {
            AppJetPackTest001Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MainScreenDemo001()
                    //MainScreenDemo002()
                    //MainScreenDemo003()
                    //MainScreenDemo004()
                    //MainScreenDemo005()
                    //MainScreenDemo006()
                    //MainScreenDemo007()
                    //MainScreenDemo008()
                    //MainScreenDemo009()
                    //MainScreenDemo011()
                    //MainScreenDemo012()
                    //MainScreenDemo013()
                    //MainScreenDemo014(itemArray = itemArray as Array<out String>)
                    MainScreenDemo015(itemArray = itemArray as Array<out String>)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreenDemo015(itemArray: Array<out String>) {
    val context = LocalContext.current
    val groupedItems = itemArray.groupBy { it.substringBefore(' ') }

    val onListItemClick = { text : String ->
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    LazyColumn{
        groupedItems.forEach{ (manufacturer, models) ->
            stickyHeader {
                Text(
                    text = manufacturer,
                    color = Color.White,
                    modifier = Modifier.background(Color.Gray)
                        .padding(5.dp)
                        .fillMaxWidth()
                )
            }


            items(models) { model ->
                Test02ListItem(
                    item = model,
                    onItemClick = onListItemClick
                )
            }
        }

    }

}


@Composable
fun Test02ListItem(item: String, onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(item)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ImageLoader(item = item)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = item,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun MainScreenDemo014(itemArray: Array<out String>) {

    //ImageLoader("Plymouth GTX")
    //Test02ListItem("Buick Roadmaster")

    val context = LocalContext.current

    val onListItemClick = { text : String ->
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    LazyColumn{
        items(itemArray) { model ->
            Test02ListItem(
                item = model,
                onItemClick = onListItemClick
            )
        }
    }

}

@Composable
fun ImageLoader(item: String) {
    val url = "https://www.ebookfrenzy.com/book_examples/car_logos/" + item.substringBefore(" ") + "_logo.png"
    Image(
        painter = rememberImagePainter(url),
        contentDescription = "Car Image",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(75.dp)
    )
}


//List Demo Project

@Composable
fun RowList() {
    val scrollState = rememberScrollState()

    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        repeat(50) {index ->
            Text(
                text = " $index",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}


@Composable
fun ColumnList() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        RowList()
        Row {
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(2.dp),
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(0)
                    }
                }
            ) {
                Text(text = "Top")
            }
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(2.dp),
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(scrollState.maxValue)
                    }
                }
            ) {
                Text(text = "End")
            }
        }

        Column(modifier = Modifier.verticalScroll(scrollState)) {
            repeat(500) {
                Text(
                    text = "List Item $it",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }


}
@Composable
fun MainScreenDemo013() {
    ColumnList()
}


@Composable
fun MainScreenDemo012() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(15) {index ->
            Card(
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
//                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Blue,
                ),
                modifier = Modifier
                    .size(width = 240.dp, height = 100.dp)
                    .padding(5.dp)
            ) {
                Text(
                    text = "$index",
                    fontSize = 35.sp,
                    color = Color.White,
//                    modifier = Modifier
//                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

}


@Composable
fun MainScreenDemo011() {

    LazyVerticalGrid(
        //columns = GridCells.Adaptive(minSize = 60.dp),
        columns = GridCells.Fixed(5),
        contentPadding = PaddingValues(10.dp),
        content = {
            items(500) { index ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Item $index",
                        fontSize = 15.sp,
                        color = Color.White, textAlign = TextAlign.Center
                    )
                }
            }
        })

//    val langs = listOf(Language("Kotlin", 0xff16a085),
//        Language("Java", 0xff2980b9),
//        Language("JavaScript", 0xff8e44ad),
//        Language("Python", 0xff2c3e50),
//        Language("Rust",0xffd35400),
//        Language("C#",0xff27ae60),
//        Language("C++",0xfff39c12),
//        Language("Go",0xff1abc9c))
//    LazyVerticalGrid(
//        columns = GridCells.FixedSize(size=140.dp),
//        modifier = Modifier.fillMaxSize(),
//        horizontalArrangement = Arrangement.Center
//    ){
//        items(langs) {lang ->
//            Column(Modifier.padding(7.dp), horizontalAlignment = Alignment.CenterHorizontally){
//                Box(Modifier.size(100.dp).background(Color(lang.hexColor)))
//                Text(lang.name, fontSize = 24.sp)
//            }
//        }
//    }

//    val langs = listOf(Language("Kotlin", 0xff16a085),
//        Language("Java", 0xff2980b9),
//        Language("JavaScript", 0xff8e44ad),
//        Language("Python", 0xff2c3e50),
//        Language("Rust",0xffd35400),
//        Language("C#",0xff27ae60),
//        Language("C++",0xfff39c12),
//        Language("Go",0xff1abc9c))
//    LazyHorizontalGrid(
//        rows = GridCells.Fixed(2),
//        modifier = Modifier.fillMaxSize(),
//        horizontalArrangement = Arrangement.Center
//    ){
//        items(langs) {lang ->
//            Column(Modifier.padding(8.dp).size(125.dp), horizontalAlignment = Alignment.CenterHorizontally){
//                Box(Modifier.size(100.dp).background(Color(lang.hexColor)))
//                Text(lang.name, fontSize = 24.sp,modifier= Modifier.padding(5.dp))
//            }
//        }
//    }

//    val itemsList = (0..12).toList()
//    LazyHorizontalGrid(
//        rows = GridCells.Fixed(3),
//        modifier = Modifier.fillMaxSize()
//    ){
//        items(itemsList) {item ->
//            Text("Item $item", fontSize = 28.sp,modifier= Modifier.padding(8.dp))
//        }
//    }

//    val listState = rememberLazyListState()
//    val coroutineScope = rememberCoroutineScope()
//    LazyColumn(state=listState) {
//        item{Text("В конец", Modifier.padding(8.dp).background(Color.DarkGray).padding(5.dp).clickable {
//            coroutineScope.launch() {
//                listState.animateScrollToItem(19)
//            }
//        }, fontSize = 28.sp, color = Color.White)
//        }
//        items(20){
//            Text("Item $it", Modifier.padding(8.dp), fontSize = 28.sp)
//        }
//    }
}

//https://metanit.com/kotlin/jetpack/2.11.php
//https://metanit.com/kotlin/jetpack/2.10.php

//val phones = listOf("Apple iPhone 12", "Google Pixel 4", "Google Pixel 6", "Samsung Galaxy 6s", "Samsung Galaxy 6s", "Google Pixel 4a", "Apple iPhone 8")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreenDemo010() {
    val phones = listOf(
        "Apple iPhone 15 Pro",
        "Realme 11 PRO",
        "Google Pixel 5",
        "Samsung Galaxy S24 Ultra",
        "Google Pixel 6",
        "Samsung Galaxy S21 FE",
        "Apple iPhone 15 Pro Max",
        "Xioami Redmi Note 12",
        "Xiaomi Redmi 12",
        "Apple iPhone 13",
        "Google Pixel 6",
        "Apple iPhone 14",
        "Realme C30s",
        "Realme Note 50"
    )
    // создаем группы
    val groups = phones.groupBy { it.substringBefore(" ") }
    LazyColumn(
        contentPadding = PaddingValues(5.dp)
    ) {
        groups.forEach { (brand, models) ->
            stickyHeader {
                Text(
                    text = brand,
                    fontSize = 28.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.Gray)
                        .padding(5.dp)
                        .fillMaxWidth()
                )
            }
            items(models) { model ->
                Text(model, Modifier.padding(5.dp), fontSize = 28.sp)
            }
        }
    }
}

@Composable
fun MainScreenDemo009() {
    val scrollState = rememberScrollState()
    //animateScrollTo
    //scrollTo
    val maxScrollPosition = scrollState.maxValue
    val listState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()

    Column {

        Button(onClick = {
            coroutinesScope.launch {
                scrollState.animateScrollTo(maxScrollPosition)
            }
        }) {
            Text(text = "Press Me")
        }

        LazyColumn(state = listState) {
            items(100) { index ->
                Text(text = "Text sample = $index")
            }
        }
    }


//    Row(modifier = Modifier.horizontalScroll(scrollState)) {
//        repeat(100) {
//            TestListItem()
//        }
//    }
}

@Composable
fun MainScreenDemo008() {
    val scrollState = rememberScrollState()

    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        repeat(100) {
            TestListItem()
        }
    }

//    Column(modifier = Modifier.verticalScroll(scrollState)) {
//        repeat(100) { index ->
//            Text(text = "Text sample = $index")
//        }
//    }
}


@Composable
fun MainScreenDemo007() {
    Column {
        LazyColumn {
            items(10) { index ->
                Text(text = "Text sample = $index")
            }
        }

        val colorNameList = listOf("Red", "Green", "Blue", "Indigo")

        LazyColumn {
            itemsIndexed(colorNameList) { index, item ->
                Text(text = "$index = $item")
            }
        }
    }
}

@Composable
fun MainScreenDemo006() {
    Column {
        Row {
            repeat(100) {
                TestListItem()
            }
        }
        repeat(100) {
            TestListItem()
        }
    }
}


@Composable
fun TestListItem() {
    Text(text = "Test N ")
}


@Composable
fun TestTextField03(text: String, onTextChange: (String) -> Unit) {
    TextField(value = text, onValueChange = onTextChange)
}

@Composable
fun MainScreenDemo005() {
    var textState by remember {
        mutableStateOf("")
    }

    val onTextChange = { text: String ->
        textState = text
    }

    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(5.dp)
    ) {
        Column(
            //modifier = Modifier.width(IntrinsicSize.Max)
            modifier = Modifier.width(IntrinsicSize.Min)
        ) {
            Text(modifier = Modifier.padding(start = 4.dp), text = textState)
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            )
        }
        TestTextField03(text = textState, onTextChange = onTextChange)
    }


//    Row(modifier = Modifier.width(IntrinsicSize.Min)) {
//        Column(modifier = Modifier.width(IntrinsicSize.Max)) {
//        }
//    }
}

@Composable
fun MainScreenDemo004() {

    ConstraintLayout(modifier = Modifier.size(width = 550.dp, height = 220.dp)) {
        val (button1, button2, button3, button4) = createRefs()

        val barrier = createEndBarrier(button1, button2)

        FirstButton(text = "Button1", modifier = Modifier
            .width(150.dp)
            .constrainAs(button1) {
                top.linkTo(parent.top, margin = 30.dp)
                start.linkTo(parent.start, margin = 8.dp)
            })

        FirstButton(text = "Button2", modifier = Modifier
            .width(100.dp)
            .constrainAs(button2) {
                top.linkTo(button1.bottom, margin = 20.dp)
                start.linkTo(parent.start, margin = 8.dp)
            })

        FirstButton(text = "Button3", modifier = Modifier.constrainAs(button3) {
            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(button1.end, parent.end, startMargin = 30.dp, endMargin = 8.dp)
            start.linkTo(barrier, margin = 30.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

        val constraints = testConstraintSet(margin = 15.dp)
        FirstButton(
            text = "Button4", modifier = Modifier
                .size(200.dp)
                .layoutId("button4")
        )

    }
}

private fun testConstraintSet(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button1 = createRefFor("button4")

        constrain(button1) {
            linkTo(parent.top, parent.bottom, topMargin = margin, bottomMargin = margin)
            linkTo(parent.start, parent.end, startMargin = margin, endMargin = margin)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}

@Composable
fun MainScreenDemo003() {
    ConstraintLayout(modifier = Modifier.size(width = 400.dp, height = 250.dp)) {
        val (button1, button2, button3) = createRefs()

        val guide = createGuidelineFromStart(fraction = 0.60f)

        FirstButton(text = "Button 1", modifier = Modifier.constrainAs(button1) {
            top.linkTo(parent.top, margin = 30.dp)
            end.linkTo(guide, margin = 30.dp)
        })

        FirstButton(text = "Button 2", modifier = Modifier.constrainAs(button2) {
            top.linkTo(button1.bottom, margin = 20.dp)
            start.linkTo(guide, margin = 40.dp)
        })

        FirstButton(text = "Button 3", modifier = Modifier.constrainAs(button3) {
//            top.linkTo(button2.bottom, margin = 40.dp)
//            end.linkTo(guide, margin = 20.dp)
            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(button1.end, parent.end, startMargin = 30.dp, endMargin = 8.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

    }
}

@Composable
fun MainScreenDemo002() {
    ConstraintLayout(modifier = Modifier.size(width = 400.dp, height = 100.dp)) {
        val (button1, button2, button3) = createRefs()


        //Version 02
        createHorizontalChain(button1, button2, button3)

        FirstButton(text = "Button 1", modifier = Modifier.constrainAs(button1) {
            centerVerticallyTo(parent)
        })

        FirstButton(text = "Button 2", modifier = Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        })

        FirstButton(text = "Button 3", modifier = Modifier.constrainAs(button3) {
            centerVerticallyTo(parent)
        })

        //Version 01
//        FirstButton(text = "Button 1", modifier = Modifier.constrainAs(button1){
//            top.linkTo(parent.top, margin = 60.dp)
//            linkTo(parent.start, parent.end, bias = 0.2f)
////            start.linkTo(parent.start)
////            end.linkTo(parent.end)
//        })
//
//        FirstButton(text = "Button 2", modifier = Modifier.constrainAs(button2){
//            top.linkTo(button1.bottom)
//            linkTo(parent.start, parent.end, bias = 0.75f)
//        })
//
//        FirstButton(text = "Button 3", modifier = Modifier.constrainAs(button3){
//            top.linkTo(button2.bottom)
//            //centerHorizontallyTo(parent)
//            linkTo(parent.start, parent.end, startMargin = 50.dp, endMargin = 30.dp, bias = 1f)
//        })

    }
}


@Composable
fun MainScreenDemo001() {
    ConstraintLayout(
        Modifier
            .size(width = 200.dp, height = 300.dp)
            .background(Color.Green)
    ) {
        val text001 = createRef()
        Text(text = "Test 01 Constraints", modifier = Modifier.constrainAs(text001) {
            top.linkTo(parent.top, margin = 16.dp)
            //bottom.linkTo(parent.bottom, margin = 16.dp)
        })

        val text002 = createRef()
        Text(text = "Test 02 Constraints", modifier = Modifier.constrainAs(text002) {
            top.linkTo(text001.bottom, margin = 16.dp)
            //bottom.linkTo(parent.bottom, margin = 16.dp)
        })

        val text003 = createRef()
        Text(text = "Test 03 Constraints", modifier = Modifier.constrainAs(text003) {
            centerAround(text002.bottom)
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        })
    }
}

@Composable
fun FirstButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier
    ) {
        Text(text = text)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DemoPreview() {
    //MainScreenDemo001()
    //MainScreenDemo002()
    //MainScreenDemo003()
    //MainScreenDemo004()
    //MainScreenDemo005()
    //MainScreenDemo006()
    //MainScreenDemo007()
    //MainScreenDemo008()
    //MainScreenDemo009()
    //MainScreenDemo011()
    //MainScreenDemo012()
    //MainScreenDemo013()

    val itemArray: Array<String> = arrayOf("Cadillac Eldorado", "Ford Fairlane", "Plymouth Fury")
    //MainScreenDemo014(itemArray = itemArray)
    MainScreenDemo015(itemArray = itemArray)
}