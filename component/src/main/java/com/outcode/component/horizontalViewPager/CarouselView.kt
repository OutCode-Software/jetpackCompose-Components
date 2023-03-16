package com.outcode.component.horizontalViewPager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CarouselView(modifier: Modifier = Modifier, imageList: List<String>) {
    val pagerState = rememberPagerState()
    Column(
    ) {
        HorizontalPager(
            count = imageList.size,
            state = pagerState,
            modifier = modifier
                .fillMaxWidth(),
        ) {
            Box() {
                Image(
                    painter = rememberAsyncImagePainter(model = imageList[it]),
                    contentDescription = "",
                    modifier = Modifier
                        .width(360.dp)
                        .height(240.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                )
            }

        }

    }
}



@OptIn(ExperimentalPagerApi::class)
@Composable
fun CarouselSlider( modifier: Modifier = Modifier, imageList: List<String>) {
    val pagerState = rememberPagerState(initialPage = 0)

    HorizontalPager(
        count = imageList.size, state = pagerState,
        contentPadding = PaddingValues(horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) { page ->
        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = modifier
                .fillMaxWidth()
                .graphicsLayer {

                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageList[page])
                    .crossfade(true)
                    .scale(Scale.FILL)
                    .build(),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .offset {
                        // Calculate the offset for the current page from the
                        // scroll position
                        val pageOffset =
                            this@HorizontalPager.calculateCurrentOffsetForPage(page)
                        // Then use it as a multiplier to apply an offset
                        IntOffset(
                            x = (70.dp * pageOffset).roundToPx(),
                            y = 0,
                        )
                    }
            )
        }

    }
}


