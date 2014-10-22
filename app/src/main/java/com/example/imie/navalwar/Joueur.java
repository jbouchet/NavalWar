package com.example.imie.navalwar;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by imie on 22/10/14.
 */
public class Joueur implements Serializable{

    static final long serialVersionUid = -1L;
    private int num;
    private String name;
    LinkedList<Rectangle> rectangles;

    public String getName() {
        return name;
    }

    public Joueur(int num, String name){
        this.num = num;
        this.name = name;
    }

    public void setRectangles(LinkedList<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public LinkedList<Rectangle> getRectangles() {
        return rectangles;
    }

    public int getNum() {
        return num;
    }
}
