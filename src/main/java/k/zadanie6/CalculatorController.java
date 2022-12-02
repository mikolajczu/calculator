package k.zadanie6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class CalculatorController {

    double firstNumber = 0;
    double secondNumber = 0;
    double copyFirstNumber = 0;
    boolean isFirstNumber = false;
    double memory = 0;
    char actualOp;
    char lastOp;

    @FXML
    private Label label;

    @FXML
    private TextField result;

    void wykonajObliczenia(){
        if(!isFirstNumber || result.getText().length() <= 0)
            return;
        if(lastOp == '-')
            firstNumber -= Double.parseDouble(result.getText());
        else if(lastOp == '+')
            firstNumber += Double.parseDouble(result.getText());
        else if(lastOp == '*')
            firstNumber *= Double.parseDouble(result.getText());
        else if(lastOp == '/')
            firstNumber /= Double.parseDouble(result.getText());
    }

    void calculate(){
        if (!isFirstNumber) {
            firstNumber = Double.parseDouble(result.getText());
            copyFirstNumber = firstNumber;
            isFirstNumber = true;
            result.clear();
        }
        if(lastOp != actualOp)
            wykonajObliczenia();
        else {
            if (result.getText().length() > 0) {
                if(actualOp == '+') {
                    secondNumber = Double.parseDouble(result.getText());
                    firstNumber += secondNumber;
                }
                else if(actualOp == '-'){
                    secondNumber = -Double.parseDouble(result.getText());
                    firstNumber += secondNumber;
                }
                else if(actualOp == '*'){
                    secondNumber = Double.parseDouble(result.getText());
                    firstNumber *= secondNumber;
                }
                else if(actualOp == '/'){
                    secondNumber = Double.parseDouble(result.getText());
                    firstNumber /= secondNumber;
                }
                copyFirstNumber = secondNumber;
            }
        }
        label.setText(firstNumber + " " + actualOp);
        result.clear();
        result.setPromptText(String.valueOf(firstNumber));
    }

    @FXML
    void btn0Click(ActionEvent event) {
        if(result.getText().indexOf("0") != 0 || result.getText().indexOf('.') != -1)
            result.setText(result.getText() + "0");
    }

    @FXML
    void btn1Click(ActionEvent event) {
        int res = 1;
        try {
              res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("1");
        else
            result.setText(result.getText() + "1");
    }

    @FXML
    void btn1xClick(ActionEvent event) {
        if(!isFirstNumber) {
            firstNumber = Double.parseDouble(result.getText());
            isFirstNumber = true;
        }
        if(result.getText().length() > 0)
            firstNumber = Double.parseDouble(result.getText());
        label.setText("1/(" + firstNumber + ")");
        firstNumber = 1 / firstNumber;
        result.clear();
        result.setPromptText(String.valueOf(firstNumber));
    }

    @FXML
    void btn2Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("2");
        else
            result.setText(result.getText() + "2");
    }

    @FXML
    void btn3Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("3");
        else
            result.setText(result.getText() + "3");
    }

    @FXML
    void btn4Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("4");
        else
            result.setText(result.getText() + "4");
    }

    @FXML
    void btn5Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("5");
        else
            result.setText(result.getText() + "5");
    }

    @FXML
    void btn6Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("6");
        else
            result.setText(result.getText() + "6");
    }

    @FXML
    void btn7Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("7");
        else
            result.setText(result.getText() + "7");
    }

    @FXML
    void btn8Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("8");
        else
            result.setText(result.getText() + "8");
    }

    @FXML
    void btn9Click(ActionEvent event) {
        int res = 1;
        try {
            res = Integer.parseInt(result.getText());
        }
        catch (NumberFormatException e){
        }
        if(res == 0)
            result.setText("9");
        else
            result.setText(result.getText() + "9");
    }

    @FXML
    void btnDivClick(ActionEvent event) {
        actualOp = '/';
        calculate();
        lastOp = '/';
    }

    @FXML
    void btnEqualClick(ActionEvent event) {
        if(!isFirstNumber)
            return;
        if(result.getText().length() > 0) {
            calculate();
            double temp = 0;
            if(lastOp == '+')
                temp = firstNumber - secondNumber;
            else if(lastOp == '-')
                temp = firstNumber + secondNumber;
            else if(lastOp == '*')
                temp = firstNumber / secondNumber;
            else if(lastOp == '/')
                temp = firstNumber * secondNumber;
            if(secondNumber < 0 && lastOp == '-')
                label.setText(temp + " " + secondNumber + " =");
            else
                label.setText(temp + " " + lastOp + " " + secondNumber + " =");
        }
        else {
            label.setText(firstNumber + " " + lastOp + " " + copyFirstNumber + " =");
            if (actualOp == '+') {
                firstNumber += copyFirstNumber;
            } else if (actualOp == '-') {
                firstNumber -= copyFirstNumber;
            } else if (actualOp == '*') {
                firstNumber *= copyFirstNumber;
            } else if (actualOp == '/') {
                firstNumber /= copyFirstNumber;
            }
            result.setPromptText(String.valueOf(firstNumber));
        }
    }

    @FXML
    void btnFractionClick(ActionEvent event) {
        if(result.getText().indexOf('.') == -1)
            result.setText(result.getText() + ".");
    }

    @FXML
    void btnMCClick(ActionEvent event) {

    }

    @FXML
    void btnMRClick(ActionEvent event) {

    }

    @FXML
    void btnMSClick(ActionEvent event) {

    }

    @FXML
    void btnMinusClick(ActionEvent event) {
        actualOp = '-';
        calculate();
        lastOp = '-';
    }

    @FXML
    void btnMminusClick(ActionEvent event) {

    }

    @FXML
    void btnMplusClick(ActionEvent event) {

    }

    @FXML
    void btnMultiplyClick(ActionEvent event) {
        actualOp = '*';
        calculate();
        lastOp = '*';
    }

    @FXML
    void btnPercentClick(ActionEvent event) {

    }

    @FXML
    void btnPlusClick(ActionEvent event) {
        actualOp = '+';
        calculate();
        lastOp = '+';
    }

    @FXML
    void btnPlusMinusClick(ActionEvent event) {
        if(!isFirstNumber) {
            firstNumber = Double.parseDouble(result.getText());
            isFirstNumber = true;
        }
        if(result.getText().length() > 0)
            firstNumber = Double.parseDouble(result.getText());
        label.setText("neg(" + firstNumber + ")");
        firstNumber = -firstNumber;
        result.clear();
        result.setPromptText(String.valueOf(firstNumber));
    }

    @FXML
    void btnSqrtClick(ActionEvent event) {
        if(!isFirstNumber) {
            firstNumber = Double.parseDouble(result.getText());
            isFirstNumber = true;
        }
        if(result.getText().length() > 0)
            firstNumber = Double.parseDouble(result.getText());
        label.setText("√" + firstNumber);
        firstNumber = Math.sqrt(firstNumber);
        result.clear();
        result.setPromptText(String.valueOf(firstNumber));
    }

    @FXML
    void btnUndoAllClick(ActionEvent event) {
        label.setText("");
        result.setText("0");
        firstNumber = 0;
        secondNumber = 0;
        isFirstNumber = false;
        actualOp = 't';
        lastOp = 'k';
        copyFirstNumber = 0;
    }

    @FXML
    void btnUndoClick(ActionEvent event) {
        StringBuffer sb = new StringBuffer(result.getText());
        try {
            sb.deleteCharAt(sb.length() - 1);
            if(sb.length() == 0)
                result.setText("0");
            else
                result.setText(sb.substring(0));
        }
        catch (StringIndexOutOfBoundsException e) {
            if(isFirstNumber)
                result.clear();
            else
                result.setText("0");
        }
    }

    @FXML
    void btnUndoFirstClick(ActionEvent event) {
        if(isFirstNumber)
            result.clear();
        else
            result.setText("0");
    }

}
