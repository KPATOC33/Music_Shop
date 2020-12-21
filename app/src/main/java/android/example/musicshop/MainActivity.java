package android.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

//Создаем реакцию на выбор элементов в спинере (наш класс будет слушать событие ктогда пользователь будет выберать элемент в списке)   добавив implements AdapterView.OnItemSelectedListener
// когда добавили и имплементировали то создали 2 метода
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    //Создаем класс Spinner
    Spinner spinner;
    //Создаем переменную ArrayList что бы наполнить spinner
    ArrayList spinnerArrayList;
    //Создаем переменную ArrayAdapter  связать данные с другим обьектом
    ArrayAdapter spinnerAdapter;
    // HashMap переменная для которая свяжет название товара и цену
    HashMap goodsMap;
    //goodsName переменная которая выполнить действие с price .
    String goodsName;
    //price
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Связываем spinner с xml разметкой
        spinner = findViewById(R.id.spinner);
        //присваеваем значение нового обьекта

        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Drums");
        spinnerArrayList.add("Keyboard");


        // структура позволяющая связать данные с другим обьектом (ArrayAdapter)
spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerArrayList);
//setDropDownViewResource(); делает выпадающий список
spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
spinner.setAdapter(spinnerAdapter);

        // HashMap содали обект
        goodsMap = new HashMap();
//заполняем структуру
        goodsMap.put("Guitar",500);
        goodsMap.put("Drums",555);
        goodsMap.put("Keyboard",333);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
goodsName =spinner.getSelectedItem().toString();
//price присваеваем значение goodsMap по ключу googsName
        //(double) установили так как нужно показать что мы получаем значение и приводим его к типу double и затем присваеваем к переменной типа double
price = (double)goodsMap.get(goodsName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
