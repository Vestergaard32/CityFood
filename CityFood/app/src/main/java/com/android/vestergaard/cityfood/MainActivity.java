package com.android.vestergaard.cityfood;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button ShareButton;
    Button FeedMeButton;
    TextView RecipeView;
    FoodRandomizer randomizer;

    String type = "image/*";
    String mediaPath;
    Uri imageUri;
    private final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShareButton = (Button) findViewById(R.id.share_btn);
        FeedMeButton = (Button) findViewById(R.id.feedme_btn);
        RecipeView = (TextView) findViewById(R.id.recipe_textview);

        Date Date = new Date();
        String filename = "/CityFood_" + Date.getMinutes()+".jpg";
        mediaPath = Environment.getExternalStorageDirectory() + filename;
        imageUri = Uri.fromFile(new File(mediaPath));

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
                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.citywok);
                mp.start();
            }
        });
    }

    public void FeedMe()
    {
        String recipe = generateRecipe();
        RecipeView.setText(recipe);
    }

    public void Share()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            takePictureIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_IMAGE_CAPTURE:
                if(resultCode == RESULT_OK){
                    createInstagramIntent();
                }
        }
    }

    private void createInstagramIntent(){

        // Create the new Intent using the 'Send' action.
        Intent share = new Intent(Intent.ACTION_SEND);

        // Set the MIME type
        share.setType(type);

        // Create the URI from the media
        File file = new File(mediaPath);
        Uri uri = Uri.fromFile(file);

        // Add the URI to the Intent.
        share.putExtra(Intent.EXTRA_STREAM, uri);
        share.setPackage("com.instagram.android");

        // Broadcast the Intent.
        startActivity(Intent.createChooser(share, "Share to"));
    }

    private String generateRecipe()
    {
        randomizer = new FoodRandomizer();
        String cookingMethod = randomizer.getCookingMethod();
        int getCookingTime = randomizer.getCookingTime();
        String getCookingUnit = randomizer.getCookingUnit();
        int meatWeight = randomizer.getWeight();
        int veggieWeight = randomizer.getWeight();
        String veggieMethod = randomizer.getVeggiestuff();
        String meat = randomizer.getMeat();
        String spice1 = randomizer.getSpice();
        String spice2 = randomizer.getSpice();
        String vegetable = randomizer.getFruitNVeggie();
        String base = randomizer.getBase();
        int baseWeight = randomizer.getWeight();
        int baseCookingTime = randomizer.getCookingTime();
        String baseCookingUnit = randomizer.getCookingUnit();
        String baseCookingMethod = randomizer.getBaseCookingMethod();
        String sauce = randomizer.getSauce();
        String sideDish = randomizer.getSideDish();

        String Ingredients = "INGREDIENTS: \n" + meatWeight + " grams of " + meat + "\n" +
                veggieWeight + " grams of " + vegetable + "\n" +
                baseWeight + " grams of " + base + "\n" +
                spice1 + ", " + spice2 + "\n" +
                sauce + "\n" + sideDish;

        String recipe = cookingMethod+ " the " + meatWeight + " grams of " + meat + " for " + getCookingTime + " " + getCookingUnit + "\n"+
                "Season the " + meat + " with a sprinkle of " + spice1 + " and a dash of " + spice2 + "\n" +
                "Boil first and then " + baseCookingMethod + " the " + baseWeight + " grams of " + base + " for " + baseCookingTime + " " + baseCookingUnit + "\n" +
                "Add " + veggieWeight + " grams of " + veggieMethod + " " + vegetable + "\n"+
                "Serve fresh with " + sauce + " and a side dish of " + sideDish;

        return Ingredients + "\n\n" + recipe;
    }
}
