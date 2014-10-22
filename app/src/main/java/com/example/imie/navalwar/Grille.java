package com.example.imie.navalwar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grille extends View implements OnTouchListener {

    private Paint paint;
    int dx = 4;
    int squareWidth = 150;
    public static LinkedList<Rectangle> rectangles;

    public Grille(Context context) {
        super(context);
        rectangles = new LinkedList<Rectangle>();
        setOnTouchListener(this);
        init(context);
    }

    public Grille(Context context, AttributeSet attrs) {
        super(context, attrs);
        rectangles = new LinkedList<Rectangle>();
        setOnTouchListener(this);
        init(context);
    }

    public Grille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        rectangles = new LinkedList<Rectangle>();
        setOnTouchListener(this);
        init(context);
    }

    private abstract class Color {
        public static final int BLUE = 0xFF3333FF;
        public static final int WHITE = 0xFFFFFFFF;
        public static final int RED = 0xFFFF0000;
        public static final int GRAY = 0xFF333333;
    }

    public void init(Context context) {
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Trace la mer
        this.paint.setColor(Color.BLUE);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), this.paint);

        int width_ecran = this.getWidth();
        int height_ecran = this.getHeight();
        int width_grille = squareWidth * dx;
        int height_grille = squareWidth * dx;
        int padding_w = (width_ecran-width_grille)/2;
        int padding_h = (height_ecran-height_grille)/2;

        // Trace la grille
        this.paint.setColor(Color.WHITE);
        /*Log.i("width", ""+padding_w);
        Log.i("height", ""+padding_h);*/
        for (int i=0; i <= dx; i++) {
            canvas.drawLine(i*squareWidth+padding_w, padding_h, i*squareWidth+padding_w, squareWidth*dx+padding_h, this.paint);
            canvas.drawLine(padding_w, i*squareWidth+padding_h, squareWidth*dx+padding_w, i*squareWidth+padding_h, this.paint);
        }

        for (Rectangle rectangle : rectangles){
            rectangle.drawRectangle(canvas);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();
        List touch_coords = new ArrayList();
        touch_coords.add(0, x);
        touch_coords.add(1, y);

        Log.i("Coord", "x = "+x+" y = "+y );
        this.invalidate();

        int nb_casses = dx * dx;
        int width_ecran = this.getWidth();
        int height_ecran = this.getHeight();
        int width_grille = squareWidth * dx;
        int height_grille = squareWidth * dx;
        int padding_w = (width_ecran - width_grille) / 2;
        int padding_h = (height_ecran - height_grille) / 2;

        List grille = new ArrayList();

        for(int ii = 0; ii < dx; ii++) {
            for (int ee = 0; ee < dx; ee++) {
                List case_coords = new ArrayList();
                int x_start = ii * squareWidth + padding_w;
                int x_stop = ii * squareWidth + padding_w + squareWidth;
                int y_start = ee * squareWidth + padding_h;
                int y_stop = ee * squareWidth + padding_h + squareWidth;

                if(x > x_start && x < x_stop && y > y_start &&  y < y_stop){
                    Log.i("Case", "x="+(ii+1)+" y="+(ee+1));
                    int color = Color.GRAY;
                    Rectangle rectangle = new Rectangle(x_start, y_start, x_stop, y_stop, color);
                    rectangles.add(rectangle);
                }
            }
        }
        return true;
    }

}

