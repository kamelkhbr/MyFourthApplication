package com.americanairlines.myfourthapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.americanairlines.myfourthapplication.R;
import com.americanairlines.myfourthapplication.model.Pizza;
import com.americanairlines.myfourthapplication.view.adapter.PizzaItemAdapter;
import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PizzaItemAdapter.PizzaDelegate {

    //Imagine this was from a web server - We will be creating mock data
    Pizza extravaganza = new Pizza(
            "Extravaganza",
            24.99,
            1000,
            "Mushrooms, Pepperoni, Goat Cheese, Truffles, Spanish Cheese, Gold Flakes, Made with Fiji Water",
            "https://www.thevintagenews.com/wp-content/uploads/2019/04/italian-pizza-with-tomatoes-cheese-and-spices-picture-id514937122-1280x720.jpg");

    Pizza chickenCheese = new Pizza(
            "Chicken Cheese",
            29.99,
            780,
            "Mushrooms, Chicken, Goat Cheese, Calamari, Dried Tuna, Spanish Cheese, Edible Diamond Dust",
            "https://blog.williams-sonoma.com/wp-content/uploads/2019/01/rcp_w19d1_buffalo-chicken-pizza.jpg");

    Pizza vegan = new Pizza(
            "Vegan",
            23.99,
            560,
            "Spinach from Thailand, Goat Cheese, Spanish Cheese, Gold Flakes, Made with Fiji Water",
            "https://cookieandkate.com/images/2016/01/kale-pesto-pizza-recipe-2-1100x1650.jpg");


    //With Base Adapter - more complex items (like custom data classes)
    private Pizza[] pizzas = new Pizza[]{extravaganza, chickenCheese, vegan};
    private List<Pizza> availablePizzas = Arrays.asList(pizzas);
    //EOF mock data setup..

    private ListView pizzaView;
    //private ArrayAdapter<String> pizzaAdapter; //ArrayAdapter

    private PizzaItemAdapter pizzaAdapter = new PizzaItemAdapter(availablePizzas, this);

    private ImageView pizzaImageView;
    private Button detailsButton;
    private TextView pizzaName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizzaView = findViewById(R.id.pizza_listview);
        pizzaImageView = findViewById(R.id.pizza_imageview);
        detailsButton = findViewById(R.id.details_button);
        pizzaName= findViewById(R.id.pizza_name);



        //With Base Adapter
        pizzaView.setAdapter(pizzaAdapter);

    }

    @Override
    public void selectPizza(Pizza selectedPizza) {
        Toast.makeText(HomeActivity.this, selectedPizza.getPizzaFlavor(), Toast.LENGTH_SHORT).show();
        pizzaName.setText(selectedPizza.getPizzaFlavor());

        Glide.with(this)
                .load(selectedPizza.getImageUrl())
                .into(pizzaImageView);

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this , DetailsActivity.class);
                intent.putExtra("parc_pizza",selectedPizza);
                startActivity(intent);
            }
        });

    }
}





















