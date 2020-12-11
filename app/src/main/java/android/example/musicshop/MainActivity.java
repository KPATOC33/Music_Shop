package android.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Увеличивает + 1 кнопку +
    public void increaseQuantity(View view)  {
        quantity = quantity + 1 ;
    TextView quantityTextView = findViewById(R.id.quantityTextView);
    quantityTextView.setText("" + quantity);
    }
    //Уменьшает - 1 кнопку -
    public void decreaseQuantity(View view) {
        quantity = quantity - 1 ;
        //если на кнопку минус нажали при 0 то значение должно быть -1 но мы возвращаем 0g
        if(quantity < 0){
            quantity = 0;
        }
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
    }
}
