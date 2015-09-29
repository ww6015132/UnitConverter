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
public class LengthFragment extends Fragment implements NumberPicker.OnValueChangeListener {
    private String[] mLengthUnit;
    NumberPicker mInputUnitPicker, mResultUnitPicker;
    private EditText mInputArea, mOutputArea;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area, null);
        mLengthUnit = getResources().getStringArray(R.array.length_unit);
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
                    transferLengthUnit();
                }else {
                    mOutputArea.setText("");
                }
            }
        });

        //Unit numberPicker
        mInputUnitPicker = (NumberPicker) view.findViewById(R.id.numberpicker_unit);
        mInputUnitPicker.setMinValue(0);
        mInputUnitPicker.setMaxValue(12);
        mInputUnitPicker.setDisplayedValues(mLengthUnit);
        AreaFragment.setNumberPickerTextColor(mInputUnitPicker, Color.GREEN);
        mInputUnitPicker.setOnValueChangedListener(this);

        mResultUnitPicker = (NumberPicker) view.findViewById(R.id.result_unit_area);
        mResultUnitPicker.setMinValue(0);
        mResultUnitPicker.setMaxValue(12);
        mResultUnitPicker.setDisplayedValues(mLengthUnit);
        AreaFragment.setNumberPickerTextColor(mResultUnitPicker, Color.GREEN);
        mResultUnitPicker.setOnValueChangedListener(this);


        return view;
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        if (mInputArea.getText() != null && !mInputArea.getText().toString().equals("")) {
            transferLengthUnit();
        }
    }

    private void transferLengthUnit() {

        //um to *
        if (mInputUnitPicker.getValue() == 0) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0001));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.00001));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.000001));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.000000001));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0000394));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (3.2808e-6)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1.0936e-6)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5.4681e-7)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (4.9710e-9)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.2137e-10)));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5.3996e-10)));
            }

        }
        //mm to *
        if (mInputUnitPicker.getValue() == 1) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.1));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.01));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.000001));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0393701));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0032808));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0010936)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0005468)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (4.9710e-6)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.2137e-7)));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5.3996e-7)));
            }
        }
        //cm to *
        if (mInputUnitPicker.getValue() == 2) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.1));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.01));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.00001));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.3937008));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0328084));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0109361)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0054681)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000497)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.2137e-6)));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5.3996e-6)));
            }
        }
        //dm to *
        if (mInputUnitPicker.getValue() == 3) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.1));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0001));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3.937008));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.328084));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.109361)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.054681)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.000497)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.2137e-6) * 10));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5.3996e-6) * 10));
            }
        }
        //m to *
        if (mInputUnitPicker.getValue() == 4) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 39.37008));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3.28084));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1.09361)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.54681)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.00497)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.2137e-6) * 100));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5.3996e-6) * 100));
            }
        }

        //km to x

        if (mInputUnitPicker.getValue() == 5) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100000));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10000));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 39370.08));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3280.84));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1093.61)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (546.81)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (4.97)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.2137e-6) * 100000));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5.3996e-6) * 100000));
            }
        }
        //in to *
        if (mInputUnitPicker.getValue() == 6) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 25400));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 25.4));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 2.54));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.254)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0254)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000254)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0833333));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0277778)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0138889)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0001263)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000158)));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000137)));
            }
        }
        //ft to *
        if (mInputUnitPicker.getValue() == 7) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 304800));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 304.8));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 30.48));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (3.048)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.3048)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0003048)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (12)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.3333333)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.1666667)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0015152)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0001894)));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0001646)));
            }
        }

        //yd to *
        if (mInputUnitPicker.getValue() == 8) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 914400));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 914.4));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 91.44));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (9.144)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.9144)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0009144)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (36)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (3)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.5)));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0045455)));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0005682)));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0004937)));
            }
        }
        //fm to *
        if (mInputUnitPicker.getValue() == 9) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1828800));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1828.8));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 182.88));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (18.288)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1.8288)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0018288)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (72)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 2));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText((mInputArea.getText()));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0090909));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0011364));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0009875));
            }
        }
        //fur to *
        if (mInputUnitPicker.getValue() == 10) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 201168000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 201168));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 20116.8));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (2011.68)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (201.168)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.201168)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (7920)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (660)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 220));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 110));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.125));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.108622));
            }
        }
        //mi to *
        if (mInputUnitPicker.getValue() == 11) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1609344000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1609344));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 160934.4));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (16093.44)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1609.344)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1.609344)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (63360)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (5280)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1760));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 880));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 8));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText((mInputArea.getText()));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.8689762));
            }
        }
        //nmi to *
        if (mInputUnitPicker.getValue() == 12) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1852000000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1852000));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 185200));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (18520)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1852)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1.852)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (72913.3858268)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6076.1154856)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 2025.3718285));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1012.6859143));
            }
            if (mResultUnitPicker.getValue() == 10) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 9.2062356));
            }
            if (mResultUnitPicker.getValue() == 11) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.1507794));
            }
            if (mResultUnitPicker.getValue() == 12) {
                mOutputArea.setText(mInputArea.getText());
            }
        }

    }
}
