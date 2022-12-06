package com.example.gitflow;

import static com.example.gitflow.MainActivity.EXTRA_CREATOR;
import static com.example.gitflow.MainActivity.EXTRA_LIKES;
import static com.example.gitflow.MainActivity.EXTRA_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gitflow.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likes = intent.getIntExtra(EXTRA_LIKES, 0);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(binding.imageViewDetail);
        binding.textViewCreatorDetail.setText(creatorName);
        binding.textViewDownloadsDetail.setText("Like: " + likes);
    }
}