package com.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.project.ui.theme.ProjectTheme

class BusinessActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        from = "Essaouira",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Essaouira is a charming coastal city in Morocco, known for its UNESCO-listed medina, 18th-century ramparts, and vibrant harbor.",
            fontSize = 25.sp,
            lineHeight = 30.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun GreetingImage(from: String, modifier: Modifier = Modifier) {
    // List of image resources to randomly choose from
    val imageList = listOf(R.drawable.essaouira, R.drawable.essaouira_3, R.drawable.essaouira_4)

    // Remember the current image and initialize with the first image in the list
    var currentImage by remember { mutableStateOf(R.drawable.essaouira) }

    Box(modifier) {
        // Image is clickable, changing the image on click
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    // Randomly choose a new image from the list
                    currentImage = imageList.random()
                }
        )
        GreetingText(
            from = from,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    ProjectTheme {
        GreetingImage(
            from = "Essaouira"
        )
    }
}
