package com.example.mipt2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtInputText;
    private Spinner spnMetricType;
    private Button btnCalculate;
    private TextView txtResult;

    // Constants for spinner item positions
    private static final int METRIC_SENTENCES = 0;
    private static final int METRIC_WORDS = 1;
    private static final int METRIC_PUNCTUATION = 2;
    private static final int METRIC_NUMBERS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements
        txtInputText = findViewById(R.id.txtInputText);
        spnMetricType = findViewById(R.id.spnMetricType);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        // Button click listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleCalculate();
            }
        });
    }

    private void handleCalculate() {
        String inputText = txtInputText.getText().toString().trim();

        // Check if input is empty
        if (inputText.isEmpty()) {
            Toast.makeText(this, getString(R.string.toast_empty_input), Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedIndex = spnMetricType.getSelectedItemPosition();
        Calculator calculator = new Calculator();  // uses your Calculator.java
        int result = 0;

        switch (selectedIndex) {
            case METRIC_SENTENCES:
                result = calculator.countSentences(inputText);
                break;
            case METRIC_WORDS:
                result = calculator.countWords(inputText);
                break;
            case METRIC_PUNCTUATION:
                result = calculator.countPunctuationMarks(inputText);
                break;
            case METRIC_NUMBERS:
                result = calculator.countNumbers(inputText);
                break;
        }

        // Get the metric name from Spinner options
        String metricName = getMetricName(selectedIndex);
        txtResult.setText(getString(R.string.result_format, metricName, result));
    }

    private String getMetricName(int index) {
        String[] options = getResources().getStringArray(R.array.metric_options);
        if (index >= 0 && index < options.length) {
            return options[index];
        } else {
            return "";
        }
    }
}
