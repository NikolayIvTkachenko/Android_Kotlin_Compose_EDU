package com.example.appjetpacktest001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

import com.example.appjetpacktest001.ui.theme.AppJetPackTest001Theme

class MainActivity03 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                    MainScreenDemo008()
                }
            }
        }

    }
}

@Composable
fun MainScreenDemo008() {

}

@Composable
fun MainScreenDemo007() {
    Column {
        LazyColumn {
            items(10) {index ->
                Text(text = "Text sample = $index")
            }
        }

        val colorNameList = listOf("Red", "Green", "Blue", "Indigo")

        LazyColumn {
            itemsIndexed(colorNameList) {index, item ->
                Text(text = "$index = $item")
            }
        }
    }
}

@Composable
fun MainScreenDemo006() {
    Column {
        Row {
            repeat(100){
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
    Text(text = "Test")
}


@Composable
fun TestTextField03(text: String, onTextChange : (String) -> Unit) {
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
            Box(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
                .background(Color.Blue))
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

    ConstraintLayout(modifier =  Modifier.size(width = 550.dp, height = 220.dp)) {
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

        FirstButton(text = "Button3", modifier = Modifier.constrainAs(button3){
            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(button1.end, parent.end, startMargin = 30.dp, endMargin = 8.dp)
            start.linkTo(barrier, margin = 30.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

        val constraints = testConstraintSet(margin = 15.dp)
        FirstButton(text = "Button4", modifier = Modifier
            .size(200.dp)
            .layoutId("button4"))

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
    ConstraintLayout(modifier =  Modifier.size(width = 400.dp, height = 250.dp)) {
        val (button1, button2, button3) = createRefs()

        val guide = createGuidelineFromStart(fraction = 0.60f)

        FirstButton(text = "Button 1", modifier = Modifier.constrainAs(button1){
            top.linkTo(parent.top, margin = 30.dp)
            end.linkTo(guide, margin = 30.dp)
        })

        FirstButton(text = "Button 2", modifier = Modifier.constrainAs(button2){
            top.linkTo(button1.bottom, margin = 20.dp)
            start.linkTo(guide, margin = 40.dp)
        })

        FirstButton(text = "Button 3", modifier = Modifier.constrainAs(button3){
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
    ConstraintLayout(modifier =  Modifier.size(width = 400.dp, height = 100.dp)) {
        val (button1, button2, button3) = createRefs()


        //Version 02
        createHorizontalChain(button1, button2, button3)

        FirstButton(text = "Button 1", modifier = Modifier.constrainAs(button1){
            centerVerticallyTo(parent)
        })

        FirstButton(text = "Button 2", modifier = Modifier.constrainAs(button2){
            centerVerticallyTo(parent)
        })

        FirstButton(text = "Button 3", modifier = Modifier.constrainAs(button3){
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
fun MainScreenDemo001(){
    ConstraintLayout(
        Modifier
            .size(width = 200.dp, height = 300.dp)
            .background(Color.Green)) {
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



@Preview(showSystemUi = true)
@Composable
fun DemoPreview() {
    //MainScreenDemo001()
    //MainScreenDemo002()
    //MainScreenDemo003()
    //MainScreenDemo004()
    //MainScreenDemo005()
    //MainScreenDemo006()
    //MainScreenDemo007()
    MainScreenDemo008()
}