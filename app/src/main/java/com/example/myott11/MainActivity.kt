package com.example.myott11

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var newView: ImageView
    lateinit var arrayListOfImageView: ArrayList<ImageView>
    lateinit var otts:ArrayList<Ott>
    private var contor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        otts=ArrayList()

        firstWord()
      //  createTwoView()
    }



    private fun firstWord() {
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
        contor++
        withContext(Dispatchers.Main) {
            //  val view = helper.getView(index) as ImageView
            createView(index, letter)


            /* val address = Helper(this).getAnimation(letter)

     individiualPatam(view)





         delay(DelayBetweenLetters)

         view.setImageResource(address)
         val avd = view.drawable as AnimatedVectorDrawable
         avd.start()*/
        }
    }


    private fun createView(index: Int,letter:String){

        val imageView = ImageView(this)
        val ott=Ott(imageView)
     //   imageView.id = View.generateViewId()
        val adress=Helper(this).getAnimation1(letter)
        imageView.setImageResource(adress)
        ott.imageView=imageView
        ott.letter=letter
        ott.index=index
        ott.wight=400
        ott.hight=400
        otts.add(ott)
        drawOtt(ott)

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
    }

    private fun drawOtt(ott: Ott) {
        val imageView=ott.imageView

        mainLayout.addView(imageView)
        imageView.id = View.generateViewId()

        imageView.layoutParams.height = ott.hight.toPx()
        imageView.layoutParams.width = ott.wight.toPx()

        val set = ConstraintSet()
        set.clone(mainLayout)
        set.connect(
            imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID,
            ConstraintSet.TOP,ott.marginTop.toPx())
        set.connect(imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID,
             ConstraintSet.START,ott.marginLeft.toPx())
        set.connect(imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID,
            ConstraintSet.BOTTOM,ott.marginBottom.toPx())
        set.connect(imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID,
            ConstraintSet.END,ott.marginRight.toPx())
        set.applyTo(mainLayout)


    }

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()


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
        arrayListOfImageView= ArrayList()

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
        arrayListOfImageView.add(newView)
    }






}