package dev.rinav

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val imageUrl =
        "https://images.unsplash.com/photo-1588605840431-a6d0f9af60b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1922&q=80"

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var originalBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coroutineScope.launch {

            val originalDeferred = coroutineScope.async(Dispatchers.IO) {
                getOriginalBitmap()
            }

            try {
                originalBitmap = originalDeferred.await()
                originalBitmap?.let { bitmap ->
                    loadImage(bitmap)

                    val filteredDeferred = coroutineScope.async(Dispatchers.Default) {
                        Filter.apply(bitmap)
                    }

                    val filteredBitmap = filteredDeferred.await()
                    loadImage(filteredBitmap)
                }
            } catch (e: Exception) {
                Log.e("XXX", "caught exception: ${e.message}", e)
            }
        }
    }

    private fun getOriginalBitmap(): Bitmap {

        return URL(imageUrl).openStream().use {
            BitmapFactory.decodeStream(it)
        }
    }

    private fun loadImage(bmp: Bitmap) {

        progressBar.visibility = View.GONE
        imageView.setImageBitmap(bmp)
        imageView.visibility = View.VISIBLE

    }
}