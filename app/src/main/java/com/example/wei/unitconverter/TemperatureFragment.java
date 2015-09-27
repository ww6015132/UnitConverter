package com.example.wei.unitconverter;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * Created by wei on 9/15/2015.
 */
public class TemperatureFragment extends Fragment implements NumberPicker.OnValueChangeListener {
    NumberPicker mInputUnitPicker, mResultUnitPicker;
    private EditText mInputArea, mOutputArea;
    String[] mTempUnit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area, null);

        mTempUnit = getResources().getStringArray(R.array.temp_unit);
        mInputArea = (EditText) view.findViewById(R.id.input_area);
        mOutputArea = (EditText) view.findViewById(R.id.output_area);

        mInputArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mInputArea.getText() != null && !mInputArea.getText().toString().equals("")) {
                    transferTempthUnit();
                } else {
                    mOutputArea.setText("");
                }
            }
        });

        //Unit numberPicker
        mInputUnitPicker = (NumberPicker) view.findViewById(R.id.numberpicker_unit);
        mInputUnitPicker.setMinValue(0);
        mInputUnitPicker.setMaxValue(4);
        mInputUnitPicker.setDisplayedValues(mTempUnit);
        AreaFragment.setNumberPickerTextColor(mInputUnitPicker, Color.YELLOW);
        mInputUnitPicker.setOnValueChangedListener(this);

        mResultUnitPicker = (NumberPicker) view.findViewById(R.id.result_unit_area);
        mResultUnitPicker.setMinValue(0);
        mResultUnitPicker.setMaxValue(4);
        mResultUnitPicker.setDisplayedValues(mTempUnit);
        AreaFragment.setNumberPickerTextColor(mResultUnitPicker, Color.YELLOW);
        mResultUnitPicker.setOnValueChangedListener(this);

        return view;
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        if (mInputArea.getText() != null && !mInputArea.getText().toString().equals("")) {
            transferTempthUnit();
        }
    }

    private void transferTempthUnit() {
        if (mInputUnitPicker.getValue() == 0) {
            switch (mResultUnitPicker.getValue()) {
                case 0:
                    mOutputArea.setText(mInputArea.getText());
                    break;
                case 1:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.8) + 32);
                    break;
                case 2:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.8));
                    break;
                case 3:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) + 273.15));
                    break;
                case 4:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.8 + 32 + 459.67));
                    break;
                default:
                    mOutputArea.setText("");
                    break;
            }
        }

        if (mInputUnitPicker.getValue() == 1) {
            switch (mResultUnitPicker.getValue()) {
                case 0:
                    mOutputArea.setText(String.valueOf((Double.parseDouble(mInputArea.getText().toString()) - 32) / 1.8));
                    break;
                case 1:
                    mOutputArea.setText(mInputArea.getText());
                    break;
                case 2:
                    mOutputArea.setText(String.valueOf((Double.parseDouble(mInputArea.getText().toString()) - 32) / 2.25));
                    break;
                case 3:
                    mOutputArea.setText(String.valueOf((Double.parseDouble(mInputArea.getText().toString()) + 459.67) / 1.8));
                    break;
                case 4:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) + 459.67));
                    break;
                default:
                    mOutputArea.setText("");
                    break;
            }
        }

        if (mInputUnitPicker.getValue() == 2) {
            switch (mResultUnitPicker.getValue()) {
                case 0:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.25));
                    break;
                case 1:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 2.25 + 32));
                    break;
                case 2:
                    mOutputArea.setText(mInputArea.getText());
                    break;
                case 3:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.25 + 273.15));
                    break;
                case 4:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 2.2532 + 459.67));
                    break;
                default:
                    mOutputArea.setText("");
                    break;
            }
        }

        if (mInputUnitPicker.getValue() == 3) {
            switch (mResultUnitPicker.getValue()) {
                case 0:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) - 273.15));
                    break;
                case 1:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.8 - 459.67));
                    break;
                case 2:
                    mOutputArea.setText(String.valueOf((Double.parseDouble(mInputArea.getText().toString()) - 273.15) * 0.8));
                    break;
                case 3:
                    mOutputArea.setText(mInputArea.getText());
                    break;
                case 4:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.8));
                    break;
                default:
                    mOutputArea.setText("");
                    break;
            }
        }

        if (mInputUnitPicker.getValue() == 4) {
            switch (mResultUnitPicker.getValue()) {
                case 0:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) - 273.15));
                    break;
                case 1:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.8 - 459.67));
                    break;
                case 2:
                    mOutputArea.setText(String.valueOf((Double.parseDouble(mInputArea.getText().toString()) - 273.15) * 0.8));
                    break;
                case 3:
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.8));
                    break;
                case 4:
                    mOutputArea.setText(mInputArea.getText());
                    break;
                default:
                    mOutputArea.setText("");
                    break;
            }
        }


    }
}
