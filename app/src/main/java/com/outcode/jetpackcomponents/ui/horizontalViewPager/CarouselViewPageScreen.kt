package com.outcode.jetpackcomponents.ui.horizontalViewPager

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
@Composable
fun CarouselViewPageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Implementation of Carousel View", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 17.sp))
        Text(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 0.dp),
            style = TextStyle(fontWeight = FontWeight.SemiBold
            ),
            text =
            "1. CarouselView(Modifier.padding(8.dp))\n 2. CarouselSlider(imageList = getImageList(5))"
        )
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