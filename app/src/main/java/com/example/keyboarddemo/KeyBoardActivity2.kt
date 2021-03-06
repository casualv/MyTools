package com.example.keyboarddemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.keyboarddemo.adapter.SimpleAdapter
import kotlinx.android.synthetic.main.activity_keyboard.*
import android.graphics.Rect
import android.view.LayoutInflater
import android.widget.LinearLayout


class KeyBoardActivity2 : AppCompatActivity() {
    val r = Rect()
    var viewbottom = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard)

//        inputLayout.visibility = View.GONE
//        addContentView(
//            inputLayout,
//            FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.MATCH_PARENT,
//                FrameLayout.LayoutParams.WRAP_CONTENT
//            ).apply {
//                gravity = Gravity.BOTTOM
//            })
//        //键盘弹起
//        var virtualKeyHeight = 0
//        val id = resources.getIdentifier("navigation_bar_height", "bool", "android")
//        if (id!=0&&resources.getBoolean(id)) {
//            virtualKeyHeight = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"))
//        }
//        recycler.getViewTreeObserver().addOnGlobalLayoutListener(OnGlobalLayoutListener //当键盘弹出隐藏的时候会 调用此方法。
//        {
//
//            //获取当前界面可视部分(键盘和虚拟键盘  不是可视化部分)
//            window.decorView.getWindowVisibleDisplayFrame(r)
//            //获取屏幕的高度
//            val screenHeight = window.decorView.rootView.height
//            //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
//            val heightDifference = screenHeight - r.bottom
//            val scrolly =heightDifference-( screenHeight - viewbottom-inputLayout.height)-virtualKeyHeight
//            Log.d("Keyboard", "Size: $heightDifference")
//            if (heightDifference == virtualKeyHeight || heightDifference == 0) {
//                //说明键盘已经隐藏
//                inputLayout.visibility = View.GONE
//            } else {
//
////                //说明键盘已经隐藏
//                inputLayout.visibility = View.VISIBLE
//                (inputLayout.layoutParams as FrameLayout.LayoutParams).apply {
//                    gravity = Gravity.BOTTOM
//                    bottomMargin = heightDifference - virtualKeyHeight
//                }
//                if(!inputLayout.isFocused){
//                    inputLayout.requestFocus()
//                }
//                recycler.smoothScrollBy(0,scrolly)
//            }
//        })
        recycler.adapter = SimpleAdapter().apply {
            setNewData(Array<String>(100, {
                it.toString()
            }).asList())
            setOnItemClickListener { adapter, view, position ->
                viewbottom = view.bottom
                val inputLayout = LayoutInflater.from(view.context).inflate(R.layout.layout_input, null)
                (view as LinearLayout).addView(inputLayout)
                inputLayout.requestFocus()
//                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

            }
        }
    }
}