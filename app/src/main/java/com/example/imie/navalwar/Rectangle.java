package com.example.imie.navalwar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by imie on 22/10/14.
 */
public class Rectangle implements Serializable{

    static final long serialVersionUid = -1L;
    int x_start;
    int x_stop;
    int y_start;
    int y_stop;
    private transient Paint paint;
    private transient Rect rectangle;

    public Rectangle(int x_start, int y_start, int x_stop, int y_stop, int color){
        this.x_start = x_start;
        this.x_stop = x_stop;
        this.y_start = y_start;
        this.y_stop = y_stop;

        paint = new Paint();
        paint.setColor(color);

        rectangle = new Rect(x_start, y_start, x_stop, y_stop);
        Log.i("Rectangle", "" + rectangle.toString());
    }

    public void drawRectangle(Canvas canvas) {
        canvas.drawRect(rectangle, paint);
    }
}
