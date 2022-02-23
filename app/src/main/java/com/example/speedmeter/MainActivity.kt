package com.example.speedmeter

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.rive.runtime.kotlin.RiveAnimationView
import java.util.*

class MainActivity : AppCompatActivity() {

    var progress1= 1F;
    var buttonIncrement: Button? = null
    var buttonDecrement: Button? = null

    var textView: TextView? = null

    private val animationView2 by lazy(LazyThreadSafetyMode.NONE) {
        findViewById<RiveAnimationView>(R.id.my_rive_animation2)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDecrement = findViewById<View>(R.id.button_decr) as Button
        buttonIncrement = findViewById<View>(R.id.button_incr) as Button

        textView = findViewById<View>(R.id.speed) as TextView

        animationView2.setNumberState("OctaState2", "progress", progress1)
        animationView2.setNumberState("OctaState", "progress", progress1)
        animationView2.setNumberState("LeftState", "progress", progress1)
        animationView2.setNumberState("LeftBottom", "progress", progress1)

        buttonIncrement!!.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {

                    val handler = Handler(Looper.myLooper()!!)
                    val runnable : Runnable = object : Runnable {

                        override fun run() {
                            handler.removeCallbacks(this)

                            if (buttonIncrement!!.isPressed) {
                                if(progress1 <100F){
                                progress1 = progress1 + 1
                                    textView!!.text= progress1.toInt().toString()
//                                    animationView2.setNumberState("State Machine 1", "progress", progress1)
                                    animationView2.setNumberState("OctaState2", "progress", progress1)
                                    animationView2.setNumberState("OctaState", "progress", progress1)
                                    animationView2.setNumberState("LeftBottom", "progress", progress1)
                                animationView2.setNumberState("RightState", "progress", progress1)
                                    animationView2.setNumberState("LeftState", "progress", progress1)
                                Log.d("progress1" , progress1.toString());
                                handler.postDelayed(this, 45)
                                }
                            }

                        }
                    }
                    handler.postDelayed(runnable,0)
                return true
            }
        })

        buttonDecrement!!.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {

                val handler = Handler(Looper.myLooper()!!)
                val runnable : Runnable = object : Runnable {

                    override fun run() {
                        handler.removeCallbacks(this)
                        if (buttonDecrement!!.isPressed) {
                            if(progress1 >0F){
                                progress1 = progress1 - 1
                                textView!!.text= progress1.toInt().toString()
//                                animationView2.setNumberState("State Machine 1", "progress", progress1)
                                animationView2.setNumberState("OctaState2", "progress", progress1)
                                animationView2.setNumberState("OctaState", "progress", progress1)
                                animationView2.setNumberState("RightState", "progress", progress1)
                                animationView2.setNumberState("LeftBottom", "progress", progress1)
                                animationView2.setNumberState("LeftState", "progress", progress1)
                                Log.d("progress1" , progress1.toString());
                                handler.postDelayed(this, 25)
                            }
                        }

                    }
                }
                handler.postDelayed(runnable,0)
                return true
            }
        })






//        buttonDecrement!!.setOnClickListener { // If progress is greater than
//            // 10% then only it can be decreased
//            if (progress1 >= 0) {
//                progress1 -= 10
//                animationView2.setNumberState("RightState", "progress", progress1)
//                animationView2.setNumberState("LeftState", "progress", progress1)
//            }
//        }







    }




}

