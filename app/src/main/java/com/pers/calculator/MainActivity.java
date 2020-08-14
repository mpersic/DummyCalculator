package com.pers.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView zeroTextView=(TextView)findViewById(R.id.tvZero);
        TextView dotTextView=(TextView)findViewById(R.id.tvDot);
        TextView oneTextView=(TextView)findViewById(R.id.tvOne);
        TextView twoTextView=(TextView)findViewById(R.id.tvTwo);
        TextView threeTextView=(TextView)findViewById(R.id.tvThree);
        TextView fourTextView=(TextView)findViewById(R.id.tvFour);
        TextView fiveTextView=(TextView)findViewById(R.id.tvFive);
        TextView sixTextView=(TextView)findViewById(R.id.tvSix);
        TextView sevenTextView=(TextView)findViewById(R.id.tvSeven);
        TextView eightTextView=(TextView)findViewById(R.id.tvEight);
        TextView nineTextView=(TextView)findViewById(R.id.tvNine);

        TextView plusTextView=(TextView)findViewById(R.id.tvPlus);
        TextView minusTextView=(TextView)findViewById(R.id.tvMinus);
        TextView multiplicationTextView=(TextView)findViewById(R.id.tvMultiplication);
        TextView divisionTextView=(TextView)findViewById(R.id.tvDivision);

        final TextView equalsTextView=(TextView)findViewById(R.id.tvEquals);
        TextView openParenthesisTextView=(TextView)findViewById(R.id.tvOpenedParenthesis);
        TextView closedParenthesisTextView=(TextView)findViewById(R.id.tvClosedParenthesis);
        TextView clearTextView=(TextView)findViewById(R.id.tvClear);

        TextView deleteTextView=(TextView)findViewById(R.id.tvDelete);

        final TextView resultTextView=(TextView)findViewById(R.id.tvResult);
        final TextView expressionTextView=(TextView)findViewById(R.id.tvExpression);

        zeroTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("0",true);
            }
        });
        dotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression(".",true);
            }
        });
        oneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("1",true);
            }
        });
        twoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("2",true);
            }
        });
        threeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("3",true);
            }
        });
        fourTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("4",true);
            }
        });
        fiveTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("5",true);
            }
        });
        sixTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("6",true);
            }
        });
        sevenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("7",true);
            }
        });
        eightTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("8",true);
            }
        });
        nineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("9",true);
            }
        });

        //numeric operations
        plusTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("+",false);
            }
        });

        minusTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("-",false);
            }
        });

        multiplicationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("*",false);
            }
        });

        divisionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("/",false);
            }
        });

        openParenthesisTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("(",false);
            }
        });

        closedParenthesisTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression(")",false);
            }
        });

        clearTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressionTextView.setText("");
                resultTextView.setText("");
            }
        });

        deleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value= (String) expressionTextView.getText().toString();
                if(!value.isEmpty()){
                    expressionTextView.setText(value.substring(0,value.length()-1));

                }
                resultTextView.setText("");
            }
        });
        equalsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Expression expressionBuilder = new ExpressionBuilder(expressionTextView.getText().toString()).build();
                    double result=expressionBuilder.evaluate();
                    long longResult=(long)result;
                    if(result==(double)longResult)
                        resultTextView.setText(String.valueOf(longResult));
                    else
                      resultTextView.setText(Double.toString(result));

                }
                catch (Exception exception){
                    System.out.println("Exception"+ exception.getMessage());
                }
            }
        });
    }

    protected void appendOnExpression(String value, boolean clearValue){
        TextView resultTextView=(TextView)findViewById(R.id.tvResult);
        TextView expressionTextView=(TextView)findViewById(R.id.tvExpression);
        if(!resultTextView.getText().toString().isEmpty()){
            resultTextView.setText("");
        }
        if(clearValue){
           resultTextView.setText("");
           expressionTextView.append(value);
        }
        else{
            expressionTextView.append(resultTextView.getText());
            expressionTextView.append(value);
            resultTextView.setText("");
        }
    }
}