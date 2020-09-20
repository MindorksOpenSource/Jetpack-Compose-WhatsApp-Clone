package com.mindorks.sample.whatsapp.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.FrameManager
import androidx.compose.runtime.onCommit
import androidx.compose.runtime.stateFor
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.graphics.drawscope.drawCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun ImageLoader(
    model: Any,
    onImageReady: (() -> Unit)? = null,
    customize: RequestBuilder<Bitmap>.() -> RequestBuilder<Bitmap> = { this }
) {
    WithConstraints {
        val image = stateFor<ImageAsset?>(null) { null }
        val drawable = stateFor<Drawable?>(null) { null }
        val context = ContextAmbient.current

        onCommit(model) {
            val glide = Glide.with(context)
            var target: CustomTarget<Bitmap>? = null
            val job = CoroutineScope(Dispatchers.Main).launch {
                target = object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                        image.value = null
                        drawable.value = placeholder
                    }

                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        FrameManager.ensureStarted()
                        image.value = resource.asImageAsset()
                        onImageReady?.invoke()
                    }
                }

                val width =
                    if (constraints.maxWidth > 0 && constraints.maxWidth < Int.MAX_VALUE) {
                        constraints.maxWidth
                    } else {
                        SIZE_ORIGINAL
                    }

                val height =
                    if (constraints.maxHeight > 0 && constraints.maxHeight < Int.MAX_VALUE) {
                        constraints.maxHeight
                    } else {
                        SIZE_ORIGINAL
                    }

                glide
                    .asBitmap()
                    .load(model)
                    .override(width, height)
                    .circleCrop()
                    .let(customize)
                    .into(target!!)
            }

            onDispose {
                image.value = null
                drawable.value = null
                glide.clear(target)
                job.cancel()
            }
        }

        val theImage = image.value
        val theDrawable = drawable.value
        if (theImage != null) {
            Image(asset = theImage)
        } else if (theDrawable != null) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCanvas { canvas, _ -> theDrawable.draw(canvas.nativeCanvas) }
            }
        }
    }
}

@Composable
fun DrawableLoader(
    model: Any,
    onImageReady: (() -> Unit)? = null,
    customize: RequestBuilder<Bitmap>.() -> RequestBuilder<Bitmap> = { this }
) {
    WithConstraints {
        val image = stateFor<ImageAsset?>(null) { null }
        val drawable = stateFor<Drawable?>(null) { null }
        val context = ContextAmbient.current

        onCommit(model) {
            val glide = Glide.with(context)
            var target: CustomTarget<Bitmap>? = null
            val job = CoroutineScope(Dispatchers.Main).launch {
                target = object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                        image.value = null
                        drawable.value = placeholder
                    }

                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        FrameManager.ensureStarted()
                        image.value = resource.asImageAsset()
                        onImageReady?.invoke()
                    }
                }

                val width =
                    if (constraints.maxWidth > 0 && constraints.maxWidth < Int.MAX_VALUE) {
                        constraints.maxWidth
                    } else {
                        SIZE_ORIGINAL
                    }

                val height =
                    if (constraints.maxHeight > 0 && constraints.maxHeight < Int.MAX_VALUE) {
                        constraints.maxHeight
                    } else {
                        SIZE_ORIGINAL
                    }

                glide
                    .asBitmap()
                    .load(model)
                    .override(width, height)
                    .let(customize)
                    .into(target!!)
            }

            onDispose {
                image.value = null
                drawable.value = null
                glide.clear(target)
                job.cancel()
            }
        }

        val theImage = image.value
        val theDrawable = drawable.value
        if (theImage != null) {
            Image(asset = theImage)
        } else if (theDrawable != null) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCanvas { canvas, _ -> theDrawable.draw(canvas.nativeCanvas) }
            }
        }
    }


}

@Composable
fun ImageLoader(@DrawableRes imageUrl: Int, modifier: Modifier) {

    val vectorAsset = loadVectorResource(imageUrl)
    vectorAsset.resource.resource?.let {
        Image(
            asset = it,
            modifier = Modifier.size(12.dp) + modifier,
            contentScale = ContentScale.Fit
        )
    }
}
@Composable
fun ImageLoader(@DrawableRes imageUrl: Int,modifier: Modifier,onClick:()->Unit) {

    val vectorAsset = loadVectorResource(imageUrl)
    vectorAsset.resource.resource?.let {
        Image(
            asset = it,
            modifier = Modifier.size(24.dp)+modifier.clickable {
                onClick()
            },
            contentScale = ContentScale.Fit
        )
    }

}