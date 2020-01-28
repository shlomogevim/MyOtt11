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


/*  private fun firstWord() {
      //  setParams(worldLayout1, 250, 380, 0, 0, 0, 500)
      //  worldLayout1.background = ContextCompat.getDrawable(this, R.drawable.ic_launcher_background)
      CoroutineScope(Dispatchers.IO).launch {
          creadAVD(contor, "ה")
//            creadAVD(2, "א")
//            creadAVD(3, "ו")
//            creadAVD(4, "ר")
      }
  }


  private suspend fun creadAVD(index: Int, letter: String) {

      if (contor > 0) contor++
    //  val ott = createView(letter)
      withContext(Dispatchers.Main) {

        //  drawOtt(ott)

*//*       delay(DelayBetweenLetters)
         view.setImageResource(address)
         val avd = view.drawable as AnimatedVectorDrawable
         avd.start()*//*

        }
    }*/

/*  private suspend fun creadAVD(index: Int, letter: String) {
      contor++
      val view = helper.getView(index) as ImageView
      val address = Helper(this).getAnimation(letter)
      individiualPatam(view)



      withContext(Dispatchers.Main) {

          delay(DelayBetweenLetters)

          view.setImageResource(address)
          val avd = view.drawable as AnimatedVectorDrawable
          avd.start()
      }

  }*/


/* private fun createView(letter: String): Ott {

     val imageView = ImageView(this)
     val ott = Ott(imageView)


     val adress = Helper(this).getAnimation1(letter)
     imageView.setImageResource(adress)
     ott.imageView = imageView

     ott.width = ViewGroup.LayoutParams.WRAP_CONTENT
     ott.height = ViewGroup.LayoutParams.WRAP_CONTENT

     otts.add(ott)

     return ott

 }*/

/* val view = helper.getView(index) as ImageView
 val address = Helper(this).getAnimation(letter)
 individiualPatam(view)*/


/*  private fun drawOtt(ott: Ott) {
      val imageView = ott.imageView

      mainLayout.addView(imageView)
      imageView.id = View.generateViewId()

      imageView.setBackgroundColor(Color.GREEN)

      *//*val x=ott.width.toPx()
        val y=ott.height.toPx()*//*


        //  imageView.layoutParams=ConstraintLayout.LayoutParams(x,y)


        //  imageView.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
        *//*imageView.layoutParams.width = 200
        imageView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT*//*
        ImageView.ScaleType.FIT_XY

        imageView.requestLayout()


        val set = ConstraintSet()
        set.clone(mainLayout)
        set.connect(
            imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID,
            ConstraintSet.TOP, ott.marginTop.toPx()
        )
        set.connect(
            imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID,
            ConstraintSet.START, ott.marginLeft.toPx()
        )
        set.connect(
            imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID,
            ConstraintSet.BOTTOM, ott.marginBottom.toPx()
        )
        set.connect(
            imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID,
            ConstraintSet.END, ott.marginRight.toPx()
        )
        set.applyTo(mainLayout)

    }*/

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()


/* private fun createView1(letter: String): Ott {

     val ott = Ott(imageView)
     val imageView = ImageView(this)
     val adress = Helper(this).getAnimation1(letter)
     imageView.setImageResource(adress)
     ott.imageView = imageView


     ott.width = 150
     ott.height = 150

     otts.add(ott)

     return ott


     // setParams(imageView, 150, 340, 0, 500, 0, 0)
 }*/

    private fun setParams(
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


    private fun individiualPatam(view: View) {
        /*  when (contor) {
              1 -> setParams(view, 150, 150, 0, 0, 15, 35)
              2 -> setParams(view, 180, 180, 0, 0, 110, 55)
              3 -> setParams(view, 170, 170, 0, 0, 170, 50)
              4 -> setParams(view, 160, 160, 0, 0, 230, 10)

              5 -> setParams(view, 50, 50, 0, 0, 10, 10)
              6 -> setParams(view, 50, 50, 0, 0, 30, 10)
              7 -> setParams(view, 55, 55, 0, 0, 50, 15)

              8 -> setParams(view, 50, 50, 0, 0, 90, 10)
              9 -> setParams(view, 40, 40, 0, 0, 120, 15)
              10 -> setParams(view, 40, 40, 0, 0, 137, 10)
              11 -> setParams(view, 50, 50, 0, 0, 155, 10)

              12 -> setParams(view, 50, 50, 0, 0, 205, 15)
              13 -> setParams(view, 50, 50, 0, 0, 230, 5)
              14 -> setParams(view, 55, 55, 0, 0, 260, 15)
              15 -> setParams(view, 45, 45, 0, 0, 290, 8)
              16 -> setParams(view, 50, 50, 0, 0, 307, 10)
              17 -> setParams(view, 50, 50, 0, 0, 330, 5)

              18 -> setParams(view, 120, 120, 0, 0, 15, 35)
              19 -> setParams(view, 140, 140, 0, 0, 75, 20)
              20 -> setParams(view, 120, 120, 0, 0, 135, 38)
              21 -> setParams(view, 110, 110, 0, 0, 175, 25)
              22 -> setParams(view, 120, 120, 0, 15, 230, 0)


              23 -> setParams(view, 50, 50, 0, 0, 0, 50)
              24 -> setParams(view, 50, 50, 0, 0, 20, 50)
              25 -> setParams(view, 50, 50, 0, 0, 40, 50)
              26 -> setParams(view, 48, 48, 0, 0, 80, 50)
              27 -> setParams(view, 50, 50, 0, 0, 105, 50)
              28 -> setParams(view, 50, 50, 0, 0, 130, 50)
              29 -> setParams(view, 50, 50, 0, 0, 163, 50)
              30 -> setParams(view, 50, 50, 0, 0, 200, 50)
              31 -> setParams(view, 50, 50, 0, 0, 230, 40)
              32 -> setParams(view, 50, 50, 0, 0, 248, 50)

              33 -> setParams(view, 45, 45, 0, 0, 272, 50)

    //            34 -> setParams(view, 50, 50, 0, 0, 305, 20)
    //            35 -> setParams(view, 50, 50, 0, 0, 323, 12)
          }*/
    }

/*
*     var imageView = ImageView(this)
imageView.id = View.generateViewId()
imageView.setImageResource(R.drawable.ic_launcher_background)
//imageView.marginStart=500
constraintLayout.addView(imageView)
var set = ConstraintSet()
set.clone(constraintLayout)
set.connect(imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,600.toPx())
set.connect(imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,300.toPx())
set.connect(imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
set.connect(imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
set.applyTo(constraintLayout)
*/

/*
*  private fun setParams(
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
 }*/


    private fun createTwoView() {
        /*arrayListOfImageView = ArrayList()

        newView = ImageView(this)

        mainLayout.addView(newView)
        newView.layoutParams.height = 200
        newView.layoutParams.width = 200
        newView.x = 300F
        newView.y = 500F
        newView.setBackgroundColor(Color.MAGENTA)
        arrayListOfImageView.add(newView)
        newView = ImageView(this)

        mainLayout.addView(newView)
        newView.layoutParams.height = 200
        newView.layoutParams.width = 200
        newView.x = 100F
        newView.y = 100F
        newView.setBackgroundColor(Color.RED)
        arrayListOfImageView.add(newView)*/
    }


}