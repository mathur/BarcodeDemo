package com.rmathur.scannerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText) findViewById(R.id.txtInput);
        final TextView txt = (TextView) findViewById(R.id.textView);

        input.requestFocus();

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String currentData = input.getText().toString();
                if(currentData.length() == 13) {
                    txt.setText("Scan detected with barcode " + currentData);
                    input.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // nothing
            }
        });
    }
}
