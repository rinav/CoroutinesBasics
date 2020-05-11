package dev.rinav.room_sample

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import dev.rinav.R

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }
}