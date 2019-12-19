package com.example.myapplication.view;


public interface MainActivityView {
    void Success(String message);
    void Failed(String error);
    void showProgress(int v);
    void hideProgress(int v);
}
