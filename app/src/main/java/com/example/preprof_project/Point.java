package com.example.preprof_project;

public class Point {
    public Integer s;
    public Integer c;
    public Integer id;
    public Point(Integer id, Integer c, Integer s){
        this.c = c;
        this.s = s;
        this.id = id;
    }

    public Integer getId() {
        return id;
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
