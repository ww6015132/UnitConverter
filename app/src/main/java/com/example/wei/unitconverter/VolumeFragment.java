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
public class VolumeFragment extends Fragment implements NumberPicker.OnValueChangeListener {

    NumberPicker mInputUnitPicker, mResultUnitPicker;
    private EditText mInputArea, mOutputArea;
    String[] mVolumnUnit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area,null);

        mVolumnUnit = getResources().getStringArray(R.array.volumn_unit);
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
                    transferVolumnthUnit();
                } else {
                    mOutputArea.setText("");
                }
            }
        });

        //Unit numberPicker
        mInputUnitPicker = (NumberPicker) view.findViewById(R.id.numberpicker_unit);
        mInputUnitPicker.setMinValue(0);
        mInputUnitPicker.setMaxValue(10);
        mInputUnitPicker.setDisplayedValues(mVolumnUnit);
        AreaFragment.setNumberPickerTextColor(mInputUnitPicker, Color.GREEN);
        mInputUnitPicker.setOnValueChangedListener(this);

        mResultUnitPicker = (NumberPicker) view.findViewById(R.id.result_unit_area);
        mResultUnitPicker.setMinValue(0);
        mResultUnitPicker.setMaxValue(10);
        mResultUnitPicker.setDisplayedValues(mVolumnUnit);
        AreaFragment.setNumberPickerTextColor(mResultUnitPicker, Color.GREEN);
        mResultUnitPicker.setOnValueChangedListener(this);

        return view;
    }

    private void transferVolumnthUnit() {

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            //mm to *
            if (mInputUnitPicker.getValue() == 0) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.000001));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1e-9)));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (2.1997e-7)));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (2.6417e-7)));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1e-6)));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.000061)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (3.5315e-8)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1e-8)));
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
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.000001));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.00022));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0002642));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString())));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0610238)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000353)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1e-5)));
                }
            }

            if (mInputUnitPicker.getValue() == 2) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.2199692));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.2641721));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString())));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (61.0238445)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0353147)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.01)));
                }
            }
            //m3 to *
            if (mInputUnitPicker.getValue() == 3) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000000));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 219.9691573));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 264.1720524));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (61023.8445022)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (35.3147248)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (10)));
                }
            }
            //uk ga to *
            if (mInputUnitPicker.getValue() == 4) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 4546091.88));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 4546.09188));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 4.5460919));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0045461));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.2009504));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 4546.09188));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 4.5460919));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (277.420004)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.160544)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0454609)));
                }
            }

            //us gal to x

            if (mInputUnitPicker.getValue() == 5) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3785411.784));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3785.411784));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3.7854118));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0037854));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.8326738));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3785.411784));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3.7854118));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (231.0003801)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.1336808)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0378541)));
                }
            }
            //ml to *
            if (mInputUnitPicker.getValue() == 6) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.000001)));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.00022)));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0002642)));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.001));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0610238)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000353)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.00001)));
                }
            }
            //l to *
            if (mInputUnitPicker.getValue() == 7) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.001)));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.2199692)));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.2641721)));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1000)));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (61.0238445)));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0353147)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.01)));
                }
            }

            //cu in to *
            if (mInputUnitPicker.getValue() == 8) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 16387.037037));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 16.387037));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.016387));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000164)));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0036046)));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.004329)));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (16.387037)));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.016387)));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(mInputArea.getText());
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0005787)));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0001639)));
                }
            }
            //cu ft to *
            if (mInputUnitPicker.getValue() == 9) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 28316800));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 28316.8));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 28.3168));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0283168)));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.2288226)));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (7.4805072)));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (28316.8)));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (28.3168)));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1728));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText((mInputArea.getText()));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.283168));
                }
            }
            //fur to *
            if (mInputUnitPicker.getValue() == 10) {
                if (mResultUnitPicker.getValue() == 0) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100000000));
                }
                if (mResultUnitPicker.getValue() == 1) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100000));
                }
                if (mResultUnitPicker.getValue() == 2) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100));
                }
                if (mResultUnitPicker.getValue() == 3) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.1)));
                }
                if (mResultUnitPicker.getValue() == 4) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (21.9969157)));
                }
                if (mResultUnitPicker.getValue() == 5) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (26.4172052)));
                }
                if (mResultUnitPicker.getValue() == 6) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (100000)));
                }
                if (mResultUnitPicker.getValue() == 7) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (100)));
                }
                if (mResultUnitPicker.getValue() == 8) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 6102.3844502));
                }
                if (mResultUnitPicker.getValue() == 9) {
                    mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3.5314725));
                }
                if (mResultUnitPicker.getValue() == 10) {
                    mOutputArea.setText(mInputArea.getText());
                }
            }
    }
}
