package com.example.tecnostore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    // Declarando os CardViews para as categorias
    private CardView cardLaptops, cardSmartphones, cardAccessories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os CardViews definidos no activity_main.xml
        cardLaptops = findViewById(R.id.cardLaptops);
        cardSmartphones = findViewById(R.id.cardSmartphones);
        cardAccessories = findViewById(R.id.cardAccess);

        // Configurando os cliques nos CardViews para abrir as respectivas atividades
        cardLaptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir a tela de Laptops
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("category", "Laptops");
                startActivity(intent);
            }
        });

        cardSmartphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir a tela de Smartphones
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("category", "Smartphones");
                startActivity(intent);
            }
        });

        cardAccessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir a tela de Acessórios
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("category", "Accessórios");
                startActivity(intent);
            }
        });
    }
}
