package com.hadimusthafa.apiresponseparcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Adapter mAdapter;
    private RecyclerView recyclerViewUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUserList = findViewById(R.id.recycler);

        Intent intent = getIntent();

        UserModel userModel = intent.getParcelableExtra("userModel");

        Log.e("response----Main", String.valueOf(userModel.data.get(5).gender));

        mAdapter = new Adapter(this, userModel.data);
        recyclerViewUserList.setAdapter(mAdapter);
        recyclerViewUserList.setLayoutManager(new LinearLayoutManager(this));
    }
}