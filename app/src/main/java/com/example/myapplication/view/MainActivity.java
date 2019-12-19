package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.viewModel.MainviewModel;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainviewModel model= ViewModelProviders.of(this).get(MainviewModel.class);
        binding.setViewModel(model);
        model.mainActivityView=this;

    }

    @Override
    public void Success(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Failed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(int v) {
        binding.progressId.setVisibility(v);
    }

    @Override
    public void hideProgress(int v) {
        binding.progressId.setVisibility(v);
    }
}
