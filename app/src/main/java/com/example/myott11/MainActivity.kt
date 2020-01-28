package com.example.myott11

import android.animation.AnimatorInflater
import android.content.res.Resources
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    var animationMode = true
    lateinit var otts: ArrayList<Ott>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       mainLayout.setOnClickListener {
            CoroutineScope(Main).launch {
                delay(1000)
                createOtt()
                drawAllOtts()
                lastApizode()
            }
        }
    }

    private suspend fun lastApizode() {
        delay(100)
        for (index in 25..29) {
            delay(750)
            val anim = AnimatorInflater.loadAnimator(this, R.animator.translate1)
            anim?.apply {
                setTarget(otts[index].iv)
                start()
            }
        }
    }

    private suspend fun drawAllOtts() {
        withContext(Main) {
            for (i in 0 until otts.size) {
                drawOneOtt(otts[i])
            }
        }
    }

    private suspend fun drawOneOtt(ott: Ott) {
        val image = ott.iv

        if (animationMode){
            if (ott.index > 0) delay(750)
            mainLayout.addView(image)
            setParameters(ott)
             val avd=image.drawable as AnimatedVectorDrawable
                    avd.start()
        }else {
            mainLayout.addView(image)
            setParameters(ott)
        }


    }

    private fun setParameters(ott: Ott) {
        with(ott) {
            if (width > 0) {
                iv.layoutParams.height = height.toPx()
                iv.layoutParams.width = width.toPx()
            }
            val imageView = ott.iv
            imageView.id = View.generateViewId()
            val set = ConstraintSet()
            set.clone(mainLayout)
            set.connect(
                imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID,
                ConstraintSet.TOP, ott.mT.toPx()
            )
            set.connect(
                imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID,
                ConstraintSet.START, ott.mL.toPx()
            )
            set.connect(
                imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM, ott.mB.toPx()
            )
            set.connect(
                imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID,
                ConstraintSet.END, ott.mR.toPx()
            )
            set.applyTo(mainLayout)
        }
    }
    private fun createOtt() {
        otts = ArrayList()
        val int0 = 70
        val int1 = 30
        val int2 = 200
        val scale1 = 75
        val scale2 = 125
        val button0 = 700 - int0
        val button1 = 480 - int0
        val button2 = 330 - int0
        val button3 = 100
        val top0 = 100
        otts = arrayListOf(
            Ott(mV("ה"), 0, 150, 150, 113 - int1, 0, 0, button0+35),
            Ott(mV("ח"), 1, 165, 165, 0, 0, 50 + int1, button0 - 25),
            Ott(mV("י"), 2, 165, 165, 0, 0, 155 + int1, button0 + 10),
            Ott(mV("י"), 3, 165, 165, 0, 0, 205 + int1, button0 + 10),
            Ott(mV("ם"), 4, 135, 135, 0, 0, 315 + int1, button0 - 20),

            Ott(mV("ז"), 5, scale1, scale1, 140, 0, 0, button1),
            Ott(mV("ה"), 6, scale1, scale1, 80, 0, 0, button1+10),

            Ott(mV("ה"), 7, scale1, scale1, 0, 0, 50, button1+10),
            Ott(mV("ד"), 8, scale1, scale1, 0, 0, 130, button1),
            Ott(mV("ב"), 9, scale1, scale1, 0, 0, 215, button1),
            Ott(mV("ר"), 10, scale1, scale1, 0, 0, 300, button1 - 10),

            Ott(mV("ה"), 11, scale1, scale1, 0, 0, 0 + int2, button2+20),
            Ott(mV("י"), 12, scale1, scale1, 0, 0, 60 + int2, button2),
            Ott(mV("ח"), 13, scale1, scale1, 0, 0, 110 + int2, button2 - 10),
            Ott(mV("י"), 14, scale1, scale1, 0, 0, 160 + int2, button2),
            Ott(mV("ד"), 15, scale1, scale1, 0, 0, 200 + int2, button2 + 10),
            Ott(mV("י"), 16, scale1, scale1, 0, 0, 260 + int2, button2),

            Ott(mV("ש"), 17, scale1, scale1, 140, 0, 0, button3),
            Ott(mV("מ"), 18, scale1, scale1, 70, 0, 0, button3),
            Ott(mV("פ"), 19, scale1, scale1, 0, 0, 20, button3),
            Ott(mV("ר"), 20, scale1, scale1, 0, 0, 100, button3),
            Ott(mV("י"), 21, scale1, scale1, 0, 0, 150, button3 + 20),
            Ott(mV("ע"), 22, scale1, scale1, 0, 0, 190, button3),

            Ott(mV("ל"), 23, scale1, scale1, 0, 0, 320, button3),
            Ott(mV("י"), 24, scale1, scale1, 0, 0, 370, button3),

            Ott(mV("ל"), 25, scale2, scale2, 0, top0, 0, 0),
            Ott(mV("ח"), 26, scale2, scale2, 0, top0 + 20, 120, 0),
            Ott(mV("י"), 27, scale2, scale2, 0, top0, 200, 0),
            Ott(mV("ו"), 28, scale2, scale2, 0, top0, 240, 0),
            Ott(mV("ת"), 29, scale2, scale2, 0, top0 + 30, 335, 0)
        )

    }

    private fun mV(letter: String): ImageView {
        val imageView = ImageView(this)
        val address = Helper(this).getAnimation1(letter)
        if (animationMode) {
            val address = Helper(this).getAnimation3(letter)
            imageView.setImageResource(address)
        } else {
            val address = Helper(this).getAnimation1(letter)
            imageView.setImageResource(address)
        }
        return imageView
    }

    private fun setParams2(
        view: View,
        scaleX: Int,
        scaleY: Int,
        mLeft: Int,
        mTop: Int,
        mRight: Int,
        mBottom: Int
    ) {
        if (scaleX > 0) {
            view.layoutParams.height = scaleX.toPx()
            view.layoutParams.width = scaleY.toPx()
        }
        val param = view.layoutParams as ConstraintLayout.LayoutParams
        param.setMargins(mLeft.toPx(), mTop.toPx(), mRight.toPx(), mBottom.toPx())
        view.layoutParams = param
        view.requestLayout()
    }

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

}