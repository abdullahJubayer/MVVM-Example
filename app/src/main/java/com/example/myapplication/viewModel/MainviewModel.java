package com.example.myapplication.viewModel;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.view.MainActivityView;
import com.example.myapplication.Repo.Repository;

public class MainviewModel  extends ViewModel implements ViewModelView {
    public String email;
    public String pass;
    public MainActivityView mainActivityView;
    private Repository repository;

    public MainviewModel(){
        repository=new Repository();
    }

    public void logIn(View view){
        if (email == null || pass == null || email.isEmpty() || pass.isEmpty()){
            mainActivityView.Failed("Error");
            return;
        }
        repository.viewModelView=this;
        repository.getResponse(email,pass);
    }

    @Override
    public void SuccessCall() {
        mainActivityView.Success("Call Success");
    }

    @Override
    public void FailedCall() {
        mainActivityView.Failed("Call Failed");
    }

    @Override
    public void showProgress(int val) {
        mainActivityView.showProgress(val);
    }

    @Override
    public void hideProgress(int val) {
        mainActivityView.hideProgress(val);
    }
}
