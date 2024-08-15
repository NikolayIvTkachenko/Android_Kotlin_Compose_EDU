package com.example.appjetpacktest001

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appjetpacktest001.ui.theme.AppJetPackTest001Theme
import kotlin.math.roundToInt

class MainActivity02 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppJetPackTest001Theme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MainScreen()
                    //DemoScreen000()
                    //MainScreen02()
                    //MainScreen03()
                    //MainScreen04()
                    MainScreen05()
                }
            }
        }

    }
}



@Composable
fun MainScreen05() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(120.dp, 80.dp)
    ) {
        Column {
            ColorBox(modifier = Modifier.exampleLayout(0f).background(Color.Blue))
            ColorBox(modifier = Modifier.exampleLayout(0.25f).background(Color.Green))
            ColorBox(modifier = Modifier.exampleLayout(0.5f).background(Color.Yellow))
            ColorBox(modifier = Modifier.exampleLayout(0.25f).background(Color.Red))
            ColorBox(modifier = Modifier.exampleLayout(0.0f).background(Color.Magenta))
        }
    }
}


@Composable
fun MainScreen04() {
    Box(modifier = Modifier.size(120.dp, 80.dp)) {
        ColorBox(
            modifier = Modifier
                .exampleLayout(200, 120)
                .background(Color.Blue)
        )
    }

}

@Composable
fun ColorBox(modifier: Modifier) {
    Box(
        Modifier
            .padding(1.dp)
            .size(width = 50.dp, height = 10.dp)
            .then(modifier))
}

//Create a custom layout modifier
fun Modifier.exampleLayout(
    x: Int,
    y: Int
): Modifier = this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, y)
    }
}

fun Modifier.exampleLayout(
    fraction: Float
): Modifier = this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    val x = -(placeable.width * fraction).roundToInt()

    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x = x, y = 0)
    }
}



@Composable
fun MainScreen03() {



    Column {

        Box(
            Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Blue))
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Blue))
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            Modifier
                .size(100.dp)
                .clip(CutCornerShape(15.dp))
                .background(Color.Blue))

        Box(
            modifier = Modifier.size(height = 90.dp, width = 290.dp)
        ){
            Text(text = "TopStart", Modifier.align(Alignment.TopStart))
            Text(text = "TopCenter", Modifier.align(Alignment.TopCenter))
            Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))

            Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
            Text(text = "Center", Modifier.align(Alignment.Center))
            Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))

            Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
            Text(text = "BottomCenter", Modifier.align(Alignment.BottomCenter))
            Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
        }


        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.size(400.dp, 400.dp)
        ) {
            val height = 200.dp
            val width = 200.dp

            TextCellV3(text = "1", modifier = Modifier.size(width = width, height = height))
            TextCellV3(text = "2", modifier = Modifier.size(width = width, height = height))
            TextCellV3(text = "3", modifier = Modifier.size(width = width, height = height))
        }
    }



}

@Composable
fun TextCellV3(text: String, modifier: Modifier = Modifier, fontSize: Int = 150) {
    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 5.dp, color = Color.Black)
    Surface {
        Text(
            text = text,
            cellModifier.then(modifier),
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }


}


@Composable
fun MainScreen02() {
    Column {

        Row {
            TextCell(text = "1", modifier = Modifier.weight(weight = 0.2f, fill = true))
            TextCell(text = "2", modifier = Modifier.weight(weight = 0.4f, fill = true))
            TextCell(text = "3", modifier = Modifier.weight(weight = 0.3f, fill = true))
        }
        Row {
            TextCell(text = "4", modifier = Modifier.weight(weight = 0.2f, fill = true))
            TextCell(text = "5", modifier = Modifier.weight(weight = 0.2f, fill = true))
            TextCell(text = "6", modifier = Modifier.weight(weight = 0.2f, fill = true))
        }

        Row {
            Text(
                text = "Large Text",
                //modifier = Modifier.alignByBaseline(),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Small Text",
                //modifier = Modifier.alignByBaseline(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier.height(350.dp)
        ){
            TextCell(text = "1",
                modifier = Modifier.align(Alignment.Top))
            TextCell(text = "2",
                modifier = Modifier.align(Alignment.CenterVertically))
            TextCell(text = "3",
                modifier = Modifier.align(Alignment.Bottom))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.size(width = 400.dp, height = 400.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(150.dp)
            ) {
                TextCell(text = "1")
                TextCell(text = "2")
                TextCell(text = "3")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextCell(text = "4")
                TextCell(text = "5")
                TextCell(text = "6")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextCell(text = "7")
                TextCell(text = "8")
                TextCell(text = "9")
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.size(width = 400.dp, height = 200.dp)
        ) {
            TextCell(text = "10")
            TextCell(text = "11")
            TextCell(text = "12")
        }
    }

}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier) {
    val cellModifier = Modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Black)

    Text(
        text = text,
        cellModifier.then(modifier),
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}


@Composable
fun CustomImage(image: Int) {
    Image(
        painter = painterResource(image),
        contentDescription = null
    )
}

@Composable
fun CustomImage(image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier
    )
}



@Composable
fun DemoScreen000() {
    val modifierText = Modifier
        .border(width = 2.dp, color = Color.Black)
        .padding(all = 10.dp)

    val secondModifierText = Modifier.height(100.dp)

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Test Data",
            modifier = modifierText.then(secondModifierText), //modifierText,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomImage(
            image = R.drawable.girl,
            Modifier
                .padding(16.dp)
                .width(270.dp)
                .clip(shape = RoundedCornerShape(30.dp))
        )
    }

}





@Composable
fun MainScreen() {
    var linearSelected by remember { mutableStateOf(true) }
    var imageSelected by remember { mutableStateOf(true) }

    val onLinearClick = { value : Boolean ->
        linearSelected = value
    }

    val onTitleClick = { value : Boolean ->
        imageSelected = value
    }


    ScreenContent(
        linearSelected = linearSelected,
        imageSelected = imageSelected,
        onLinearClick = onLinearClick,
        onTitleClick = onTitleClick,
        titleContent = {
            if(imageSelected) {
                TitleImage(drawing = R.drawable.download_app)
            } else {
                Text(
                    text = "Downloading",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(30.dp)
                )
            }
        },
        progressContent = {
            if(linearSelected) {
                LinearProgressIndicator(Modifier.height(40.dp))
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.size(200.dp),
                    strokeWidth =  18.dp
                )
            }
        }
    )

}

@Composable
fun ScreenContent(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onTitleClick: (Boolean) -> Unit,
    onLinearClick: (Boolean) -> Unit,
    titleContent: @Composable () -> Unit,
    progressContent: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        titleContent()
        progressContent()

        CheckBoxes(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onTitleClick = onTitleClick,
            onLinearClick = onLinearClick)
    }
}

@Composable
fun CheckBoxes (
    linearSelected: Boolean,
    imageSelected: Boolean,
    onTitleClick: (Boolean) -> Unit,
    onLinearClick: (Boolean) -> Unit
) {
    Row(
        Modifier.padding(20.dp)
    ) {
        Checkbox(
            checked = imageSelected,
            onCheckedChange = onTitleClick
        )
        Text("Image Title")
        Spacer(Modifier.width(20.dp))
        Checkbox(
            checked = linearSelected,
            onCheckedChange = onLinearClick
        )
        Text(text = "Linear Progress")
    }
}

@Composable
fun TitleImage(drawing: Int) {
    Image(
        painter = painterResource(id = drawing),
        contentDescription = "Title Image"
    )
}


@Preview(showSystemUi = true)
@Composable
fun DemoPreview() {
    //DemoScreen000()
    //MainScreen02()
    //MainScreen03()
    //MainScreen04()
    MainScreen05()

//    CheckBoxes(
//        linearSelected = true,
//        imageSelected = true,
//        onTitleClick = { },
//        onLinearClick = { }
//    )
}