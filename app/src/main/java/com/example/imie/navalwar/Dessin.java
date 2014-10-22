package com.example.imie.navalwar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.util.LinkedList;

public class Dessin extends View implements OnTouchListener {

    LinkedList<Cercle> cercles;


    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        cercles = new LinkedList<Cercle>() ;
        setOnTouchListener(this);
    }
    @Override
    public void onDraw(Canvas canvas) {
        for (Cercle cercle: cercles)
        {
            cercle.draw(canvas);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        Log.i("TOUCHE", "TOUCHE");
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // toucher en x,y
                cercles.add(new Cercle(x, y, 1));
                break;
            case MotionEvent.ACTION_MOVE:  // mouvement vers x,y
                Cercle cercle = cercles.getLast();
                cercle.rayon = (int)Math.sqrt((x-cercle.xc)*(x-cercle.xc) + (y-cercle.yc)*(y-cercle.yc));
                break;
        }
        this.invalidate();
        return true;
    }

    class Cercle {
        int xc, yc, rayon;
        private Paint paint;


        public Cercle(int x, int y, int r) {
            xc = x;
            yc = y;
            rayon = r;

            paint = new Paint();
            paint.setColor(Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        }

        public void draw(Canvas canvas)
        {
            canvas.drawCircle(xc, yc, rayon, paint);
        }
    }


}