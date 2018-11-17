package com.example.jkuma86.draganddrop

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.DragEvent.*
import android.view.View
import android.widget.ImageView
import com.makeramen.roundedimageview.RoundedDrawable
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnLongClickListener, View.OnDragListener {


    private val mFirstImage by lazy { findViewById<RoundedImageView>(R.id.imgFirst) }
    private val mSecondImage by lazy { findViewById<RoundedImageView>(R.id.imgSecond) }
    private val mThirdImage by lazy { findViewById<RoundedImageView>(R.id.imgThird) }
    private val mFourImage by lazy { findViewById<RoundedImageView>(R.id.imgFour) }
    private val mFiveImage by lazy { findViewById<RoundedImageView>(R.id.imgFive) }
    private val mSixImage by lazy { findViewById<RoundedImageView>(R.id.imgSix) }
    private lateinit var mSourceImageView:RoundedImageView
    private lateinit var mDestImageView:RoundedImageView
    private var mSourceImageResource:Int = 0
    private var mDestImageResource:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirstImage.setOnLongClickListener(this)
        mFirstImage.setOnDragListener(this)
        mFirstImage.tag = "First Image"
        mSecondImage.setOnLongClickListener(this)
        mSecondImage.setOnDragListener(this)
        mSecondImage.tag = "Second Image"
        mThirdImage.setOnLongClickListener(this)
        mThirdImage.setOnDragListener(this)
        mThirdImage.tag = "Third Image"
        mFourImage.setOnLongClickListener(this)
        mFourImage.setOnDragListener(this)
        mFourImage.tag = "Four Image"
        mFiveImage.setOnLongClickListener(this)
        mFiveImage.setOnDragListener(this)
        mFiveImage.tag = "Five Image"
        mSixImage.setOnLongClickListener(this)
        mSixImage.setOnDragListener(this)
        mSixImage.tag = "Six Image"

    }


    override fun onLongClick(view: View): Boolean {

        when (view.id) {
            R.id.imgFirst -> {

                println("first image long click")
                val item = ClipData.Item(view.tag as CharSequence)
                val dragData = ClipData(
                    view.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item
                )
                // Instantiates the drag shadow builder.
                val myShadow = MyDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mSourceImageView=mFirstImage
                    mSourceImageResource=R.drawable.nature1
                    view.startDragAndDrop(dragData, myShadow, null, 0)
                }

            }
            R.id.imgSecond -> {
                println("second image long click")
                val item = ClipData.Item(view.tag as CharSequence)
                val dragData = ClipData(
                    view.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item
                )
                // Instantiates the drag shadow builder.
                val myShadow = MyDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mSourceImageView=mSecondImage
                    mSourceImageResource=R.drawable.nature2
                    view.startDragAndDrop(dragData, myShadow, null, 0)
                }

            }
            R.id.imgThird -> {
                println("third image long click")
                val item = ClipData.Item(view.tag as CharSequence)
                val dragData = ClipData(
                    view.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item
                )
                // Instantiates the drag shadow builder.
                val myShadow = MyDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mSourceImageView=mThirdImage
                    mSourceImageResource=R.drawable.nature3
                    view.startDragAndDrop(dragData, myShadow, null, 0)
                }

            }
            R.id.imgFour -> {
                println("fourth image long click")
                val item = ClipData.Item(view.tag as CharSequence)
                val dragData = ClipData(
                    view.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item
                )
                // Instantiates the drag shadow builder.
                val myShadow = MyDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mSourceImageView=mFourImage
                    mSourceImageResource=R.drawable.nature4
                    view.startDragAndDrop(dragData, myShadow, null, 0)
                }

            }
            R.id.imgFive -> {
                println("fifth image long click")
                val item = ClipData.Item(view.tag as CharSequence)
                val dragData = ClipData(
                    view.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item
                )
                // Instantiates the drag shadow builder.
                val myShadow = MyDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mSourceImageView=mFiveImage
                    mSourceImageResource=R.drawable.nature5
                    view.startDragAndDrop(dragData, myShadow, null, 0)
                }

            }
            R.id.imgSix -> {
                println("sixth image long click")
                val item = ClipData.Item(view.tag as CharSequence)
                val dragData = ClipData(
                    view.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item
                )
                // Instantiates the drag shadow builder.
                val myShadow = MyDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mSourceImageView=mSixImage
                    mSourceImageResource=R.drawable.nature6
                    view.startDragAndDrop(dragData, myShadow, null, 0)
                }

            }

        }

        return true
    }


    override fun onDrag(view: View?, dragEvent: DragEvent?): Boolean {
        when (dragEvent?.action) {
            ACTION_DRAG_STARTED -> {
                return true
            }
            ACTION_DRAG_ENDED -> {

            }
            ACTION_DROP -> {
                mSourceImageView.invalidate()
                mDestImageView.invalidate()
                mSourceImageView.setImageResource(mDestImageResource)
                mDestImageView.setImageResource(mSourceImageResource)
                return true
            }
            ACTION_DRAG_EXITED -> {

            }
            ACTION_DRAG_ENTERED -> {
                println("entered")
                when(view?.id){
                    R.id.imgFirst->{
                        mDestImageView=mFirstImage
                        mDestImageResource=R.drawable.nature1
                    }
                    R.id.imgSecond->{
                        mDestImageView=mSecondImage
                        mDestImageResource=R.drawable.nature2
                    }
                    R.id.imgThird->{
                        mDestImageView=mThirdImage
                        mDestImageResource=R.drawable.nature3
                    }
                    R.id.imgFour->{
                        mDestImageView=mFourImage
                        mDestImageResource=R.drawable.nature4
                    }
                    R.id.imgFive->{
                        mDestImageView=mFiveImage
                        mDestImageResource=R.drawable.nature5
                    }
                    R.id.imgSix->{
                        mDestImageView=mSixImage
                        mDestImageResource=R.drawable.nature6
                    }
                }

                return true
            }
        }
        return false
    }

}
