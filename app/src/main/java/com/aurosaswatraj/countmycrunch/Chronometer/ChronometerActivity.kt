package com.aurosaswatraj.countmycrunch.Chronometer

import android.animation.ObjectAnimator
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aurosaswatraj.countmycrunch.Dialogs.UserDarkModeDialog
import com.aurosaswatraj.countmycrunch.R
import kotlinx.android.synthetic.main.activity_chronometer2.*

class ChronometerActivity : AppCompatActivity() {


    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronometer2)
        val window = this.window
        window.statusBarColor = Color.parseColor("#2f3640")
        val darkModeDialog = UserDarkModeDialog()
        darkModeDialog.darkModeDialog(this, this)
        requestedOrientation =ActivityInfo.SCREEN_ORIENTATION_PORTRAIT // Fixed portrait orientation

        val laps:ArrayList<Laps> = ArrayList()
        var counter = 0



        lap_Rv.layoutManager=LinearLayoutManager(applicationContext,RecyclerView.VERTICAL,false)
        lap_Rv.adapter=ChronometerLapAdapter(laps)


        val objectAnimator = ObjectAnimator.ofFloat(i_canchor, "rotation", 0f, 360f)
        objectAnimator.setDuration(4000)
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE)

        btn_stop_.alpha= 0F

        btn_start_.setOnClickListener {

//                passing Animation
            objectAnimator.start()
            //    icanchor.startAnimation(roundingalone);
            btn_stop_.animate().alpha(1f).translationY(-80f).setDuration(300).start()
            btn_start_.animate().alpha(0f).setDuration(300).start()
//                start time
            //   start time
            time_Here.base = SystemClock.elapsedRealtime()
            time_Here.start()
        }

        reset_btn.setOnClickListener {
            it.startAnimation(rotateOpen)
            laps.clear()
            lap_Rv.adapter?.notifyDataSetChanged()
            counter=0

        }

        btn_stop_.setOnClickListener {

            laps.add(Laps(counter++,time_Here.text.toString()))
            lap_Rv.adapter?.notifyDataSetChanged()
            objectAnimator.pause()
            btn_start_.animate().alpha(1f).translationY(-80f).setDuration(300).start()
            btn_stop_.animate().alpha(0f).setDuration(300).start()
            time_Here.stop()
        }



    }
}