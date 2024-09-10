package com.example.tecnostore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecnostore.objetos.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 colunas

        // Recebe a categoria selecionada
        String category = getIntent().getStringExtra("category");
        TextView tvCategories = findViewById(R.id.tvCategories);
        tvCategories.setText(category);

        // Inicializa a lista de produtos
        productList = new ArrayList<>();

        // Preenche a lista de produtos conforme a categoria
        if (category.equals("Laptops")) {
            productList.add(new Product("Notebook Dell Inspiron 15 I15-I120K-A35P", "Intel Core i5 16GB RAM SSD 1TB 15,6\" Full HD Windows 11 12MB 210-BNFN", R.drawable.laptop1, 3399.99));
            productList.add(new Product("Notebook Acer Aspire 5", "Intel Core i5 12450H 8GB RAM 512GB SSD 15,6” Full HD Windows 11 A515-57-565J", R.drawable.laptop2, 2799.99));
            productList.add(new Product("Notebook Lenovo IdeaPad 1i", "Intel Core i7-1255U 16GB 512GB SSD Windows 11 Home 15.6\" 82VY000NBR", R.drawable.laptop3, 3599.99));
            productList.add(new Product("Notebook Samsung Galaxy Book4", "Intel Core i5 8GB RAM SSD 512GB 15,6\" Full HD Windows 11 NP750XGJ-KG3BR", R.drawable.laptop4, 2499.99));
        } else if (category.equals("Smartphones")) {
            productList.add(new Product("Samsung Galaxy S23", "256GB Preto 5G 8GB RAM 6,1” Câm Tripla + Selfie 12MP", R.drawable.smartphone1, 2799.99));
            productList.add(new Product("Motorola Moto G24", "128GB Rosa 4GB + 4GB RAM Boost 6,6\" Câm. Dupla + Selfie 8MP Dual Chip", R.drawable.smartphone2, 799.99));
            productList.add(new Product("Apple iPhone 14", "Smartphone com grande tela AMOLED", R.drawable.smartphone3, 4199.99));
            productList.add(new Product("Smartphone celular Xiaomi Redmi 13C", "Azul Dual SIM de 256GB / 8GB RAM de 6.74\" 50 + 2 + 2MP / 8MP", R.drawable.smartphone4, 1099.99));
        } else if (category.equals("Accessórios")) {
            productList.add(new Product("Cabo Carregador de Dados", "Compatível iPhone 6 7 8 X Xr Xs 11 12 13 14 15 Pro - Altomex", R.drawable.access1, 119.99));
            productList.add(new Product("Teclado Gamer", "Semi Mecânico Rise Mode G2 Mini, RGB, Layout 60% - RM-TG-02-B", R.drawable.access2, 69.90));
            productList.add(new Product("Filtro de Linha", "6 Tomadas Preto ou Branco Régua 110/220v Bivolt Universal C/ Protetor Descarga de Energia - OPEN ZEE", R.drawable.access3, 59.99));
            productList.add(new Product("Cartão de Memória Kingston", "Canvas Select Plus MicroSD 128GB, com Adaptador, para Câmeras Automáticas/Dispositivos Android - SDCS2/128GB", R.drawable.access4, 129.99));
        }

        // Configura o adaptador para o RecyclerView
        ProductAdapter adapter = new ProductAdapter(this, productList, product -> {
            // Ao clicar no produto, vai para a OrderActivity
            Intent intent = new Intent(ProductActivity.this, OrderActivity.class);
            intent.putExtra("productName", product.getName());
            intent.putExtra("productDescription", product.getDescription());
            intent.putExtra("productPrice", product.getPrice());
            intent.putExtra("productImage", product.getImageResId());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }
}
