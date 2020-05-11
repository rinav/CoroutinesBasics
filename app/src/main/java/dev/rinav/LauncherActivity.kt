package dev.rinav

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dev.rinav.retrofit_sample.ui.RetrofitActivity
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        btn_img_processing.setOnClickListener(this)
        btn_retrofit.setOnClickListener(this)
        btn_room.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id) {
            btn_img_processing.id -> {
                startActivity(Intent(this@LauncherActivity, ImageProcessingActivity::class.java))
            }
            btn_retrofit.id -> {
                startActivity(Intent(this@LauncherActivity, RetrofitActivity::class.java))
            }

            btn_room.id -> {
                //startActivity(Intent(this@LauncherActivity,  ))
            }
        }
    }
}