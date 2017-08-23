package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Stack;

/**
 * Created by Home on 8/13/2017.
 */
public class CalculatorControler {

    Double savedNumber=0.0;
    Boolean noTextEdit=true;
    Stack stackList = new Stack();
    int CharacterLimit;

    @FXML
    TextField textCalcArea;

    @FXML
    Label lblNumber;

    @FXML
    Label lblErrorMsg;

    @FXML
    Label lblMemory;


    @FXML
    private void clearTextField(ActionEvent event) {
        clearText();
    }

    /*
    Add the number that is in the Text property of the button pressed
     */
    @FXML
    private void addNum(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (textCalcArea.getText().equals("0") || noTextEdit) {
            textCalcArea.setText("");
            lblErrorMsg.setText("");
            noTextEdit=false;
        }
        if(CharacterLimit <20) {
            textCalcArea.appendText(String.valueOf(button.getText()));
            CharacterLimit++;
        }
    }

    @FXML
    private void addFloat(ActionEvent event) {
        if (!textCalcArea.getText().contains("."))
            textCalcArea.appendText(".");
    }

    /*
    ADD TO THE STACK
     */
    @FXML
    private void equal(ActionEvent event) {
        stackList.push(Double.valueOf(textCalcArea.getText()));
        updateNumbInList();
        clearText();
    }

    @FXML
    private void clearStack(){
        stackList=new Stack();
        updateNumbInList();
    }

    @FXML
    private void removeLast(){
        String text = textCalcArea.getText();
        if(text.length()>0 && !text.equals("0")){
            textCalcArea.setText(text.substring(0,text.length()-1));
            CharacterLimit--;
            if(textCalcArea.getText().length()==0)
                textCalcArea.setText("0");
        }

    }

    //Memory Event - Recall, Store and Clear
    @FXML
    private void memory(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (button.getText().contains("MS")) {
            savedNumber = Double.valueOf(textCalcArea.getText());
            lblMemory.setText("M");
        }

        //If the stored number doesn't have any number after the . returns an integer
        if (button.getText().contains("MR")) {
            if (savedNumber % 1 == 0)
                textCalcArea.setText(String.valueOf(savedNumber.intValue()));
            else
                textCalcArea.setText(String.valueOf(savedNumber));
        }

        if (button.getText().contains("MC")) {
            savedNumber = 0.0;
            lblMemory.setText("");
        }
    }

    @FXML
    private void initialize() {
        updateNumbInList();
    }

    //Operations Methods
    @FXML
    private void sum(ActionEvent event) {
        operation("+");
    }

    @FXML
    private void minus(ActionEvent event) {
        operation("-");
    }

    @FXML
    private void division(ActionEvent event) {
        operation("/");
    }

    @FXML
    private void multiply(ActionEvent event) {
        operation("*");
    }

    private void operation(String symbol) {
        Double result;

        if (stackList.getSize() > 0 && stackList.peek() != null) {
            noTextEdit=true;
            double num1 = (double) stackList.pop().getElement();// (stackList.pop().getElement()!=null?stackList.pop().getElement():null);
            double num2 = Double.valueOf(textCalcArea.getText());
            switch (symbol) {
                case "+":
                    result = num1 + num2;
                    updateListandText(result);
                    break;
                case "-":
                    result = num1 - num2;
                    updateListandText(result);
                    break;
                case "*":
                    result = num1 * num2;
                    updateListandText(result);
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                        updateListandText(result);
                    } else
                        lblErrorMsg.setText("ERROR - CAN'T DIVIDE BY ZERO");
                    break;
            }
            CharacterLimit =0;
        } else
            lblErrorMsg.setText("ERROR - NO NUMBERS ON LIST");
    }

    /*
    Send the result to the screen and update to INT or DOUBLE
     */
    public void updateListandText(double result) {
        clearText();
        if (result % 1 == 0)
            textCalcArea.setText(String.valueOf((int) result));
        else
            textCalcArea.setText(String.valueOf(result));
        updateNumbInList();
    }


    public void updateNumbInList() {
        lblNumber.setText(String.valueOf(stackList.getSize()));
    }


    public void clearText() {
        //Change Label and TextField
        textCalcArea.setText("0");
        lblErrorMsg.setText("");
        //Reset characther limit
        CharacterLimit =0;
    }
}
