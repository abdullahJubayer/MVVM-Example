package com.example.myapplication.viewModel;

public interface ViewModelView {
    void SuccessCall();
    void FailedCall();
    void showProgress(int val);
    void hideProgress(int val);
}
