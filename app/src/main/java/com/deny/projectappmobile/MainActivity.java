package com.deny.projectappmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNovel;
    private ArrayList<Novel> list = new ArrayList<>();
    String title = "Let's Read";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        rvNovel = findViewById(R.id.rv_novel);
        rvNovel.setHasFixedSize(true);

        list.addAll(NovelData.getListData());
        showRecyclerViewGrid();
        setBarTitle(title);
    }
    private void showRecyclerViewGrid() {
        rvNovel.setLayoutManager(new GridLayoutManager(this, 2));
        MainAdapter mainAdapter = new MainAdapter(list);
        rvNovel.setAdapter(mainAdapter);

        mainAdapter.setOnItemClickCallback(new MainAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Novel data) {
                showSelectedNovel(data);
            }
        });
    }

    private void setBarTitle(String title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedNovel(Novel novel) {
        Toast.makeText(this, "Anda memilih " + novel.getJudul(), Toast.LENGTH_SHORT).show();
    }
}