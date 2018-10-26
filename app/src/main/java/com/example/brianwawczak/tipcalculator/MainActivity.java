package com.example.brianwawczak.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    double totalBill;
    String tipRate;
    double tipAmount;
    String trueTipRate;
    int intTip;
    String totalTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText bill = findViewById(R.id.idUserInput);
        final Spinner rate = findViewById(R.id.idSpinner);
        Button calculate = findViewById(R.id.idButton);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result = (findViewById(R.id.idTextDisplay));
            @Override
            public void onClick(View v) {
                NumberFormat numFormat = NumberFormat.getNumberInstance();
                numFormat.setGroupingUsed(true);
                numFormat.setMaximumFractionDigits(2);
                numFormat.setMinimumFractionDigits(2);
                String holdEditText;
                holdEditText = bill.getText().toString();
                try {
                    totalBill = Double.parseDouble(holdEditText);
                } catch (NumberFormatException d){
                    totalBill = 0;
                }
                tipRate = rate.getSelectedItem().toString();
                trueTipRate = tipRate.substring(0, tipRate.length()-1);
                intTip = Integer.parseInt(trueTipRate);
                tipAmount = ((double)intTip / 100) * totalBill;
                totalTip = numFormat.format(tipAmount);


                result.setText("The total tip is $" + totalTip);
            }
        });
    }
}
