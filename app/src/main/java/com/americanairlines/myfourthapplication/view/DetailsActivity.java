package com.americanairlines.myfourthapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.americanairlines.myfourthapplication.R;
import com.americanairlines.myfourthapplication.model.Pizza;
import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private TextView pizzaFlavor;
    private TextView pizzaPrice;
    private TextView pizzaIngredients;
    private TextView pizzaCalories;
    private ImageView pizzaImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        pizzaFlavor = findViewById(R.id.pizza_flavor);
        pizzaPrice = findViewById(R.id.pizza_price);
        pizzaIngredients = findViewById(R.id.pizza_ingredients);
        pizzaCalories = findViewById(R.id.pizza_calories);
        pizzaImage = findViewById(R.id.pizza_imageview);

        Intent intent = getIntent();
        Pizza fromOrder = intent.getParcelableExtra("parc_pizza");

        if(intent!= null){

            if(fromOrder != null)
                Toast.makeText(this, fromOrder.getPizzaFlavor()+", "+fromOrder.getCalories(),Toast.LENGTH_SHORT).show();
        }
        String flavor = fromOrder.getPizzaFlavor();
        String ingredients = fromOrder.getIngredients();
        String image= fromOrder.getImageUrl();
        double price= fromOrder.getPizzaPrice();
        int calories= fromOrder.getCalories();

         //assigning the views
        pizzaFlavor.setText(flavor);
        pizzaPrice.setText(" Price: $"+String.valueOf(price));
        pizzaIngredients.setText("Ingredients: "+ingredients);
        pizzaCalories.setText(" Calories: "+String.valueOf(calories));
        Glide.with(this).load(fromOrder.getImageUrl()).into(pizzaImage);

    }
}