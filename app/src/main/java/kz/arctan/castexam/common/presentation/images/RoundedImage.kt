package kz.arctan.castexam.common.presentation.images

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kz.arctan.castexam.R

@Composable
fun RoundedImage(
    modifier: Modifier = Modifier,
    image: Painter,
    contentDescription: String? = null
) {
    Image(
        painter = image,
        contentDescription = contentDescription,
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}


@Preview(showBackground = false)
@Composable
fun RoundedImagePreview() {
    RoundedImage(
        image = painterResource(id = R.drawable.registration_image)
    )
}