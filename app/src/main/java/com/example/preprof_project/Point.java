package com.example.preprof_project;

public class Point {
    public int s;
    public int c;
    public int id;
    public Point(){}
    public Point(int id, int c, int s){
        this.c = c;
        this.s = s;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(int i) {
        this.id = id;
    }

    public Integer getC() {
        return c;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public Integer getS() {
        return s;
    }

    public void setC(Integer c) {
        this.c = c;
    }
}
