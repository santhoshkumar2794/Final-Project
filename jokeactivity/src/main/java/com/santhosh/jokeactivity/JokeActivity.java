package com.santhosh.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * Created by santhosh-3366 on 08/05/17.
 */

public class JokeActivity extends AppCompatActivity{

    @BindView(R2.id.joke_view)
    TextView jokeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");
        Log.e("joke","view "+joke);
        jokeView.setText(joke);
    }
}
