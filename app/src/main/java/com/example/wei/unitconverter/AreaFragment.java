package com.example.wei.unitconverter;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by wei on 9/15/2015.
 */
public class AreaFragment extends Fragment implements NumberPicker.OnValueChangeListener {
    NumberPicker mInputUnitPicker, mResultUnitPicker;
    private EditText mInputArea, mOutputArea;
    String[] mAreaUnit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area, null);

        mAreaUnit = new String[]{"cm²", "dm²", "m²", "km²", "sq.mi", "sq.in", "sq.yd", "sq.ft", "are", "acre"};
        //Input numberPicker
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
                if (mInputArea.getText() != null&&!mInputArea.getText().toString().equals("")) {
                    transferAreaUnit();
                }else {
                    mOutputArea.setText("");
                }
            }
        });

        //Unit numberPicker
        mInputUnitPicker = (NumberPicker) view.findViewById(R.id.numberpicker_unit);
        mInputUnitPicker.setMinValue(0);
        mInputUnitPicker.setMaxValue(9);
        mInputUnitPicker.setDisplayedValues(mAreaUnit);
        setNumberPickerTextColor(mInputUnitPicker, Color.YELLOW);
        mInputUnitPicker.setOnValueChangedListener(this);

        mResultUnitPicker = (NumberPicker) view.findViewById(R.id.result_unit_area);
        mResultUnitPicker.setMinValue(0);
        mResultUnitPicker.setMaxValue(9);
        mResultUnitPicker.setDisplayedValues(mAreaUnit);
        setNumberPickerTextColor(mResultUnitPicker, Color.YELLOW);
        mResultUnitPicker.setOnValueChangedListener(this);

        return view;
    }

    public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color) {
        final int count = numberPicker.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = numberPicker.getChildAt(i);
            if (child instanceof EditText) {
                try {
                    Field selectorWheelPaintField = numberPicker.getClass()
                            .getDeclaredField("mSelectorWheelPaint");
                    selectorWheelPaintField.setAccessible(true);
                    ((Paint) selectorWheelPaintField.get(numberPicker)).setColor(color);
                    ((EditText) child).setTextColor(color);
                    numberPicker.invalidate();
                    return true;
                } catch (NoSuchFieldException e) {
                    Log.w("setNumPickerTextColor", e);
                } catch (IllegalAccessException e) {
                    Log.w("setNumPickerTextColor", e);
                } catch (IllegalArgumentException e) {
                    Log.w("setNumPickerTextColor", e);
                }
            }
        }
        return false;
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        if (mInputArea.getText() != null&&!mInputArea.getText().toString().equals("")) {
            transferAreaUnit();
        }
    }

    private void transferAreaUnit(){
        //cm2 to *
        if (mInputUnitPicker.getValue() == 0) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) / 100));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) / 10000));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0000000001));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) / 25899881103.36));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.1550003));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0001196));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0010764));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1e-6)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (2.4711e-8)));
            }
        }
        //dm2 to *
        if (mInputUnitPicker.getValue() == 1) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) / 100));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.00000001));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) / 258998811.0336));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 15.50003));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.01196));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.10764));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1e-6) * 100));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (2.4711e-8) * 100));
            }
        }
        //m2 to *
        if (mInputUnitPicker.getValue() == 2) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.000001));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) / 2589988.110336));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1550.003));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1.196));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10.764));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1e-6) * 10000));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (2.4711e-8) * 10000));
            }
        }
        //km2 to *
        if (mInputUnitPicker.getValue() == 3) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10000000000l));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100000000));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.3861022));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1550003100.006));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1195990.046301));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10763910.41671));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10000));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 247.1053815));
            }
        }
        //sq.mi to *
        if (mInputUnitPicker.getValue() == 4) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 25899881103.36));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 258998811.0336));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 2589988.110336));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 2.5899881));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 4014489600l));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 3097600));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 27878400));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 25899.8811034));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 640));
            }
        }

        if (mInputUnitPicker.getValue() == 5) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 6.4516));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.064516));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0006452));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.4516e-10)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (2.4910e-10)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(mInputArea.getText()));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0007716));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.0069444));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6.4516e-6)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1.5942e-7)));
            }
        }
        //sq.yd to *
        if (mInputUnitPicker.getValue() == 6) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 8361.2736));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 83.612736));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.8361274));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (8.3613e-7)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (3.2283e-7)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1296)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 9));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0083613)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0002066)));
            }
        }
        //sq.ft to *
        if (mInputUnitPicker.getValue() == 7) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 929.0304));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 9.290304));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 0.092903));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (9.2903e-8)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (3.5870e-8)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (144)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.1111111)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.000929)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.000023)));
            }
        }

        //acre to *
        if (mInputUnitPicker.getValue() == 9) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 40468564.224));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 404685.64224));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 4046.8564224));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0040469)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0015625)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (6272640)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (4840)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (43560)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (40.4685642)));
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(mInputArea.getText());
            }
        }
        //are to *
        if (mInputUnitPicker.getValue() == 8) {
            if (mResultUnitPicker.getValue() == 0) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 1000000));
            }
            if (mResultUnitPicker.getValue() == 1) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 10000));
            }
            if (mResultUnitPicker.getValue() == 2) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * 100));
            }
            if (mResultUnitPicker.getValue() == 3) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0001)));
            }
            if (mResultUnitPicker.getValue() == 4) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0000386)));
            }
            if (mResultUnitPicker.getValue() == 5) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (155000.3100006)));
            }
            if (mResultUnitPicker.getValue() == 6) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (119.5990046)));
            }
            if (mResultUnitPicker.getValue() == 7) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (1076.3910417)));
            }
            if (mResultUnitPicker.getValue() == 8) {
                mOutputArea.setText(mInputArea.getText());
            }
            if (mResultUnitPicker.getValue() == 9) {
                mOutputArea.setText(String.valueOf(Double.parseDouble(mInputArea.getText().toString()) * (0.0247105)));
            }
        }
    }
}
