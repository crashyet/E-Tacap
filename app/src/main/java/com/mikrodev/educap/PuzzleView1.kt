package com.mikrodev.educap


import android.content.Context
import android.content.Intent
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class PuzzleView : View {

    private var bitmap: Bitmap? = null
    private var pieceSize = 0
    private var pieces = mutableListOf<PuzzlePiece>()
    private var selectedPiece: PuzzlePiece? = null
    private var emptyPiece: PuzzlePiece? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)


//    private fun checkIfPuzzleSolved() {
//        val correctPieceOrder = mutableListOf<Int>()
//        for (i in 0 until 9) {
//            correctPieceOrder.add(i)
//        }
//        if (pieces.map { it.index } == correctPieceOrder) {
//            // Puzzle solved
//            showCongratulationMessage()
//        }
//    }
//
//    private fun showCongratulationMessage() {
//        Log.d("PuzzleView", "Menampilkan ucapan selamat!") // Log pesan ini akan muncul di Logcat
//        Toast.makeText(context, "Selamat! Anda telah menyelesaikan puzzle!", Toast.LENGTH_LONG).show()
//        val intent = Intent(context, PuzzleActivity::class.java)
//        context.startActivity(intent)
//    }


    fun setImage(bitmap: Bitmap) {
        this.bitmap = bitmap
        pieceSize = bitmap.width / 3 // Assume 3x3 grid
        createPieces()
        shufflePieces()
        invalidate()
    }

    private fun createPieces() {
        pieces.clear()
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val pieceBitmap = Bitmap.createBitmap(bitmap!!, j * pieceSize, i * pieceSize, pieceSize, pieceSize)
                val piece = PuzzlePiece(i * 3 + j, pieceBitmap, pieceSize)
                pieces.add(piece)
            }
        }
        emptyPiece = pieces.last()
        pieces.removeAt(pieces.size - 1)
    }

    private fun shufflePieces() {
        pieces.shuffle()
        pieces.add(emptyPiece!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        pieces.forEach { it.draw(canvas) }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val x = event.x
                val y = event.y
                selectedPiece = pieces.find { it.contains(x.toInt(), y.toInt()) }
            }
            MotionEvent.ACTION_MOVE -> {
                selectedPiece?.let {
                    it.move(event.x.toInt(), event.y.toInt())
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                selectedPiece?.let {
                    if (emptyPiece!!.contains(it.x, it.y)) {
                        val emptyIndex = pieces.indexOf(emptyPiece)
                        val selectedIndex = pieces.indexOf(it)
                        pieces[emptyIndex] = it.apply { moveTo(emptyPiece!!.x, emptyPiece!!.y) }
                        pieces[selectedIndex] = emptyPiece!!
                        emptyPiece = it
                    }
                    selectedPiece = null
                    invalidate()
                }
            }
        }
        return true
    }
}

class PuzzlePiece(val index: Int, private val bitmap: Bitmap, private val pieceSize: Int) {

    var x = 0
    var y = 0
    private val rect = RectF()
    private val paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.isFilterBitmap = true
    }

    fun draw(canvas: Canvas) {
        rect.set(x.toFloat(), y.toFloat(), (x + pieceSize).toFloat(), (y + pieceSize).toFloat())

        // Draw shadow
        paint.setShadowLayer(10f, 0f, 0f, Color.BLACK)

        // Draw border
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        paint.color = Color.BLACK

        canvas.drawBitmap(bitmap, null, rect, paint)

        // Reset paint
        paint.setShadowLayer(0f, 0f, 0f, Color.BLACK)
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 0f
    }

    fun contains(x: Int, y: Int): Boolean {
        return x >= this.x && x < this.x + pieceSize && y >= this.y && y < this.y + pieceSize
    }

    fun move(newX: Int, newY: Int) {
        x = newX - pieceSize / 2
        y = newY - pieceSize / 2
    }

    fun moveTo(newX: Int, newY: Int) {
        x = newX
        y = newY
    }
}
