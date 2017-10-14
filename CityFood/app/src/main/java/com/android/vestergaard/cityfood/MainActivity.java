package com.android.vestergaard.cityfood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button ShareButton;
    Button FeedMeButton;
    TextView RecipeView;

    String type = "image/*";
    String filename = "/shittyFood.jpg";
    String mediaPath = Environment.getExternalStorageDirectory() + filename;

    private final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShareButton = (Button) findViewById(R.id.share_btn);
        FeedMeButton = (Button) findViewById(R.id.feedme_btn);
        RecipeView = (TextView) findViewById(R.id.recipe_textview);

        ShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share();
            }
        });

        FeedMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedMe();
            }
        });
    }


    public void FeedMe()
    {
        Toast.makeText(MainActivity.this, "Feed me has been clicked!", Toast.LENGTH_SHORT).show();
        String text = RecipeView.getText().toString();
        RecipeView.setText(text+" Feed me more!");

    }

    public void Share()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_IMAGE_CAPTURE:
                if(resultCode == RESULT_OK){
                    Bundle extras = data.getExtras();
                    
                }
        }
    }
}
