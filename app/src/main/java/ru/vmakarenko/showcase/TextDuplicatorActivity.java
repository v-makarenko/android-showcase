package ru.vmakarenko.showcase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class TextDuplicatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_duplicator);
        final AtomicInteger btnPressed = new AtomicInteger(0);
        ((EditText)findViewById(R.id.edit_text_1)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ((EditText)findViewById(R.id.edit_text_2)).setText(s.toString());
                ((TextView)findViewById(R.id.btnPressedValue)).setText(String.valueOf(btnPressed.incrementAndGet()));
            }
        });

    }

}
