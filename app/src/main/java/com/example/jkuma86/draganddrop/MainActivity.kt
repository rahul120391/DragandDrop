package com.example.jkuma86.draganddrop

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
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
    private lateinit var mSourceImageView: RoundedImageView
    private lateinit var mDestImageView: RoundedImageView
    private var mSourceImageResource: Int?=null
    private var mDestImageResource: Int? = null
    private val mMap by lazy { HashMap<String,Int>() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirstImage.setOnLongClickListener(this)
        mFirstImage.setOnDragListener(this)
        mFirstImage.tag = "First Image"
        mMap[mFirstImage.tag.toString()]=R.drawable.nature1
        mSecondImage.setOnLongClickListener(this)
        mSecondImage.setOnDragListener(this)
        mSecondImage.tag = "Second Image"
        mMap[mSecondImage.tag.toString()]=R.drawable.nature2
        mThirdImage.setOnLongClickListener(this)
        mThirdImage.setOnDragListener(this)
        mThirdImage.tag = "Third Image"
        mMap[mThirdImage.tag.toString()]=R.drawable.nature3
        mFourImage.setOnLongClickListener(this)
        mFourImage.setOnDragListener(this)
        mFourImage.tag = "Four Image"
        mMap[mFourImage.tag.toString()]=R.drawable.nature4
        mFiveImage.setOnLongClickListener(this)
        mFiveImage.setOnDragListener(this)
        mFiveImage.tag = "Five Image"
        mMap[mFiveImage.tag.toString()]=R.drawable.nature5
        mSixImage.setOnLongClickListener(this)
        mSixImage.setOnDragListener(this)
        mSixImage.tag = "Six Image"
        mMap[mSixImage.tag.toString()]=R.drawable.nature6
    }


    override fun onLongClick(view: View): Boolean {

        when (view.id) {
            R.id.imgFirst,
            R.id.imgSecond,
            R.id.imgThird,
            R.id.imgFour,
            R.id.imgFive,
            R.id.imgSix -> {
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
                    view.startDragAndDrop(dragData, myShadow, null, 0)
                }
                mSourceImageResource= mMap[view.tag.toString()]
                mSourceImageView = view as RoundedImageView
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
                if (mSourceImageView != mDestImageView) {
                    mSourceImageResource?.let { mDestImageView.setImageResource(it) }
                    mDestImageResource?.let { mSourceImageView.setImageResource(it) }
                    mMap[mSourceImageView.tag.toString()] = mDestImageResource!!
                    mMap[mDestImageView.tag.toString()] = mSourceImageResource!!
                }
                return true
            }
            ACTION_DRAG_EXITED -> {

            }
            ACTION_DRAG_ENTERED -> {
                mDestImageResource= mMap[view?.tag.toString()]
                mDestImageView = view as RoundedImageView
                return true
            }
        }
        return false
    }

}
