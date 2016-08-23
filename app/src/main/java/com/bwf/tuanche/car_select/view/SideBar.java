package com.bwf.tuanche.car_select.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin on 2016/8/23.
 */
public class SideBar extends View {
    //SideBar上显示的字母和#号
    private int choose = -1;// 选中
    private Paint paint = new Paint();
    public static String[] CHARACTERS = {"#","A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    //SideBar的高度
    private int width;
    //SideBar的宽度
    private int height;
    //SideBar中每个字母的显示区域的高度
    private float cellHeight;
    //画字母的画笔
    private Paint characterPaint;
    //SideBar上字母绘制的矩形区域
    private Rect textRect;
    //手指触摸在SideBar上的横纵坐标
    private float touchY;
    private float touchX;

    private OnSelectListener listener;

    public SideBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public SideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SideBar(Context context) {
        super(context);
        init(context);
    }

    //初始化操作
    private void init(Context context){
        textRect = new Rect();
        characterPaint = new Paint();
        characterPaint.setColor(Color.parseColor("#6699ff"));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(changed){ //在这里测量SideBar的高度和宽度
            width = getMeasuredWidth();
            height = getMeasuredHeight();
            //SideBar的高度除以需要显示的字母的个数，就是每个字母显示区域的高度
            cellHeight = height * 1.0f / CHARACTERS.length;
            //根据SideBar的宽度和每个字母显示的高度，确定绘制字母的文字大小，这样处理的好处是，对于不同分辨率的屏幕，文字大小是可变的
            int textSize = (int) ((width > cellHeight ? cellHeight : width) * (3.0f / 4));
            characterPaint.setTextSize(textSize);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取焦点改变背景颜色.
        int height = getHeight();// 获取对应高度
        int width = getWidth(); // 获取对应宽度
        int singleHeight = height / CHARACTERS.length;// 获取每一个字母的高度

        for (int i = 0; i < CHARACTERS.length; i++) {
            paint.setColor(Color.rgb(33, 65, 98));
            // paint.setColor(Color.WHITE);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);
            paint.setTextSize(40);
            // 选中的状态
            if (i == choose) {
                paint.setColor(Color.parseColor("#3399ff"));
                paint.setFakeBoldText(true);
            }
            // x坐标等于中间-字符串宽度的一半.
            float xPos = width / 2 - paint.measureText(CHARACTERS[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(CHARACTERS[i], xPos, yPos, paint);
            paint.reset();// 重置画笔
        }

    }

    //根据手指触摸的坐标，获取当前选择的字母
    private String getHint(){
        int index = (int) (touchY / cellHeight);
        if(index >= 0 && index < CHARACTERS.length){
            return CHARACTERS[index];
        }
        return null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                //获取手指触摸的坐标
                touchX = event.getX();
                touchY = event.getY();
                if(listener != null && touchX > 0){
                    listener.onSelect(getHint());
                }
                if(listener != null && touchX < 0){
                    listener.onMoveUp(getHint());
                }
                return true;
            case MotionEvent.ACTION_UP:
                touchY = event.getY();
                if(listener != null){
                    listener.onMoveUp(getHint());
                }
                return true;
        }
        return super.onTouchEvent(event);
    }

    //监听器，监听手指在SideBar上按下和抬起的动作
    public interface OnSelectListener{
        void onSelect(String s);
        void onMoveUp(String s);
    }

    //设置监听器
    public void setOnSelectListener(OnSelectListener listener){
        this.listener = listener;
    }
}
