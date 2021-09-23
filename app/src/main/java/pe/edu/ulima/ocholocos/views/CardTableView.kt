package pe.edu.ulima.ocholocos.views

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import pe.edu.ulima.ocholocos.R

class CardTableView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    private var size : Int = 0

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        size = Math.min(width, height)
        setMeasuredDimension(size, size)
    }
}