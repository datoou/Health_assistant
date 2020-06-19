package com.example.a.health_assistant.User;

/**
 * Created by 大大大荣 on 2020/4/15.
 */

public class App {
    private String name;
    private  String hir;
    private String t;


    public App() {
        this.name = name;
        this.hir = hir;
        this.t =t;
    }

    public App(String name, String hir, String t) {
        this.name = name;
        this.hir = hir;
        this.t =t;

    }

    public String getName() {
        return name;

    }
    public String getHir() {
        return hir;

    }
    public String getT() {
        return t;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHir(String hir) {
        this.hir=hir;
        return hir;
    }

    public String getT(String t) {
        this.t=t;
        return t;
    }
}
