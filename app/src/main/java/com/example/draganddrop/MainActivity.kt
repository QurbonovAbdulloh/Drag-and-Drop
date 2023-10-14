package com.example.draganddrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.draganddrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var x: Float? = null
    private var y: Float? = null
    private var dx: Float? = null
    private var dy: Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event!!.action == MotionEvent.ACTION_DOWN) {
            x = event.x
            y = event.y
        }

        if (event.action == MotionEvent.ACTION_MOVE) {
            dx = event.x - x!!
            dy = event.y - y!!

            binding.imageView.x = binding.imageView.x + dx!!
            binding.imageView.y = binding.imageView.y + dy!!
            binding.textViewX.text = dx.toString()
            binding.textViewY.text = dy.toString()

            x = event.x
            y = event.y


        }

        return super.onTouchEvent(event)
    }
}