package com.outcode.jetpackcomponents.ui.horizontalViewPager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Niken Maharjan on 2023/2/27.
 */

class CarouselViewPageScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarouselViewImpl()
        }
    }
}

@Composable
fun CarouselViewImpl() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CarouselView(Modifier.padding(8.dp), getImageList(5))
        Spacer(modifier = Modifier.height(60.dp))
        CarouselSlider(imageList = getImageList(5))
    }
}

fun getImageList(size: Int): List<String> {
    val imageList = arrayListOf<String>()
    for (i in 0..size) {
        val url = "https://picsum.photos/200/200?random=${i+1}"

        imageList.add(url)
    }
    return imageList
}