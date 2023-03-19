package com.example.preprof_project;

public class User {
    int v;
    int maxV = 2;
    int sh;
    int oxygen = 7;
    int nuclearOil = 10;
    int oxygenK;
    int nuclearOilK;
    int W;
    int T;
    int m = 192000;
    int mSh = 1000;
    int G0;

    int Oxi;
    float p = (float) 3.14;
    double k = Math.sin((-p / 2) + (p * (T + 0.5*Oxi)/40));
    double G = G0 + G0*k;

    public int getMaxV() {
        return maxV;
    }

    public int getNuclearOil() {
        return nuclearOil;
    }

    public int getNuclearOilK() {
        return nuclearOilK;
    }

    public double getG() {
        return G;
    }

    public double getK() {
        return k;
    }

    public int getM() {
        return m;
    }

    public int getOxygenK() {
        return oxygenK;
    }

    public int getOxygen() {
        return oxygen;
    }

    public int getW() {
        return W;
    }

    public int getT() {
        return T;
    }

    public int getSh() {
        return sh;
    }

    public int getOxi() {
        return Oxi;
    }

    public int getG0() {
        return G0;
    }

    public int getV() {
        return v;
    }

    public int getmSh() {
        return mSh;
    }

    public void setG(double g) {
        G = g;
    }

    public void setG0(int g0) {
        G0 = g0;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setK(double k) {
        this.k = k;
    }



    public void setOxygenK(int oxygenK) {
        this.oxygenK = oxygenK;
    }

    public void setT(int t) {
        T = t;
    }

    public void setW(int w) {
        W = w;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public void setNuclearOilK(int nuclearOilK) {
        this.nuclearOilK = nuclearOilK;
    }
}
