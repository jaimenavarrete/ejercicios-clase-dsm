package com.udb.dsm.apilabphp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.udb.dsm.apilabphp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PersonAdapter personAdapter;
    List<PeopleInfo> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
        getPeople();
    }

    private void initRecyclerView() {
        personAdapter = new PersonAdapter(people);
        binding.listPeople.setLayoutManager(new LinearLayoutManager(this));
        binding.listPeople.setAdapter(personAdapter);
    }

    private ApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dosydossoncuatro.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        return service;
    }


    private void getPeople() {
        final Call<PeopleResponse> batch = getApiService().getInfo();

        batch.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                if(response != null && response.body() != null) {
                    people.clear();
                    
                    List<PeopleInfo> peopleInfo = response.body().getPeopleInfo();

                    people.addAll(peopleInfo);
                    personAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                if(t != null) {
                    showError();
                }
            }
        });
    }

    private void showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
    }

}