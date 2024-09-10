package com.example.tecnostore;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName, productDescription, productPrice;
    private int imageId;

    EditText etName, etAddress, etProduct;
    Button btnSubmitOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productDescription = findViewById(R.id.productDescription);
        productPrice = findViewById(R.id.productPrice);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etProduct = findViewById(R.id.etProduct);
        btnSubmitOrder = findViewById(R.id.btnSubmitOrder);

        // Recebendo os dados do Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("productName");
        String description = intent.getStringExtra("productDescription");
        double price = intent.getDoubleExtra("productPrice", 0.0);
        int imageResId = intent.getIntExtra("productImage", R.drawable.logo);

        // Exibindo as informações do produto
        productName.setText(name);
        productDescription.setText(description);
        productPrice.setText("R$ " + String.format("%.2f", price));
        productImage.setImageResource(imageResId); // Exibe a imagem passada via Intent

        // Preenche o produto automaticamente se passado de outra atividade
        String product = getIntent().getStringExtra("productName");
        if (product != null) {
            etProduct.setText(product);
        }

        btnSubmitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String address = etAddress.getText().toString();
                String product = etProduct.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(product)) {
                    Toast.makeText(OrderActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(OrderActivity.this, LoginActivity.class);
                    activityResultLauncher.launch(intent);
                    // Aqui é onde você pode enviar os dados para um banco de dados ou backend
                }
            }
        });
    }

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Toast.makeText(OrderActivity.this, "Pedido realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(OrderActivity.this, "Falha ao realizar o pedido!", Toast.LENGTH_SHORT).show();
                }
            }
    );
}
