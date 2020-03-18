package com.khpi.image_matcher.android.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.khpi.image_matcher.R

class SquareLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        const val VERTICAL = 0
        const val HORIZONTAL = 1
    }

    var orientation: Int = VERTICAL

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SquareLayout)
        orientation = typedArray.getInt(R.styleable.SquareLayout_layout_orientation, VERTICAL)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val sizeMeasureSpec = when (orientation) {
            VERTICAL -> heightMeasureSpec
            else -> widthMeasureSpec
        }
        super.onMeasure(sizeMeasureSpec, sizeMeasureSpec)
    }
}
