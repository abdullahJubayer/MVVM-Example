package com.example.myapplication.Repo;

import android.view.View;

import com.example.myapplication.Network.Api;
import com.example.myapplication.Network.RetrofitCall;
import com.example.myapplication.viewModel.ViewModelView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private Api myApi;
    public ViewModelView viewModelView;

    public Repository(){
        myApi= RetrofitCall.getInstance().create(Api.class);
    }

    public  void getResponse(String email, String pass){
        viewModelView.showProgress(View.VISIBLE);
        myApi.login(email,pass).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    viewModelView.SuccessCall();
                    viewModelView.hideProgress(View.INVISIBLE);
                }else {
                    viewModelView.FailedCall();
                    viewModelView.hideProgress(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                viewModelView.FailedCall();
                viewModelView.hideProgress(View.INVISIBLE);
            }
        });

    }
}
