package com.example.mukazuge.simplecalculatorexample;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorFragment extends Fragment {

    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String DIVIDE = "/";
    static final String MULTIPLY = "X";
    static final String CLEAR = "C";
    static final String RESULT = "=";
    protected int numericalButtonsId[] = new int[]{R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero};
    protected int operatorButtonId[] = new int[]{R.id.plus, R.id.minus, R.id.divide, R.id.multiply, R.id.clear, R.id.result};
    String lastValue = "";
    String firstValue = "";
    String processLastValue = "";
    int resultValue = 0;
    String lastOperator = "";
    TextView numberContainer = null;
    TextView operationContainer = null;
    Button operatorsButton = null;
    Button numPad = null;

    protected NumPadClickListener numPadClickListener = new NumPadClickListener();
    protected OperatorClickListener operatorClickListener = new OperatorClickListener();

    public CalculatorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_num_pad, container, false);

        numberContainer = (TextView) view.findViewById(R.id.numberContainer);
        operationContainer = (TextView) view.findViewById(R.id.operationContainer);

        for (int aNumericalButtonsId : numericalButtonsId) {
            numPad = (Button) view.findViewById(aNumericalButtonsId);
            numPad.setOnClickListener(numPadClickListener);
        }

        for(int aOperatorButtonId : operatorButtonId){
            operatorsButton = (Button) view.findViewById(aOperatorButtonId);
            operatorsButton.setOnClickListener(operatorClickListener);
        }



        return view;
    }

    private class NumPadClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView numbers = (TextView) v;
            numberContainer.setText(firstValue + numbers.getText());
            firstValue = (String) numberContainer.getText();
            lastValue = (String) numberContainer.getText();
        }
    }

    private class OperatorClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView operators = (TextView) v;
            lastOperator = (String) operators.getText();

            switch (lastOperator){

              case PLUS:
                  if(!lastValue.equals("")){
                      firstValue = "";
                      lastValue = (String) numberContainer.getText();
                      resultValue += Integer.parseInt(lastValue);
                      operationContainer.setText(processLastValue + numberContainer.getText() + " " + PLUS);
                      numberContainer.setText(Integer.toString(resultValue));
                      processLastValue = (String) operationContainer.getText();
                  }
                  break;

              case MINUS:
                  
                  break;

              case DIVIDE:

                  break;

              case MULTIPLY:

                  break;

              case CLEAR:
                  operationContainer.setText("");
                  numberContainer.setText("0");
                  lastOperator = "";
                  lastValue = "";
                  firstValue = "";
                  processLastValue = "";
                  resultValue = 0;

                  break;

              case RESULT:

                  break;
          }
        }
    }
}
