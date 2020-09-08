package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Main extends Application {

    private TextField output;
    private Button clear,square,squareRoot,plus,multiply,division,minus,equalBtn,
                    dot,zero,one,two,three,four,five,six,seven,eight,nine,plus_minus_division;
    private HBox textFieldHbox,cHbox,sevenHbox,fourHbox,oneHbox,allHbox;
    private VBox root;

    private double data = 0.0;
    private int operation = -1;
    @Override
    public void start(Stage primaryStage) throws Exception{
        output = new TextField();
        output.setPrefWidth(480);
        output.setPrefHeight(70);
        output.setFont(new Font(40));
        output.setAlignment(Pos.BOTTOM_RIGHT);

        GetButtonInput in = new GetButtonInput();

        clear = getButtons("C");
        clear.setOnAction(in);

        square = getButtons("x^2");
        mathExpression(square,"x^2");


        squareRoot = getButtons("Sqrt");
        mathExpression(squareRoot,"sqrt");

        plus = getButtons("+");
        plus.setOnAction(in);

        multiply = getButtons("x");
        multiply.setOnAction(in);

        division = getButtons("/");
        division.setOnAction(in);

        minus = getButtons("-");
        minus.setOnAction(in);

        equalBtn = getButtons("=");
        equalBtn.setOnAction(in);

        dot = getButtons(".");
        dot.setOnAction(in);

        zero = getButtons("0");
        zero.setOnAction(in);

        one = getButtons("1");
        one.setOnAction(in);

        two = getButtons("2");
        two.setOnAction(in);

        three = getButtons("3");
        three.setOnAction(in);

        four = getButtons("4");
        four.setOnAction(in);

        five = getButtons("5");
        five.setOnAction(in);

        six = getButtons("6");
        six.setOnAction(in);

        seven = getButtons("7");
        seven.setOnAction(in);

        eight = getButtons("8");
        eight.setOnAction(in);

        nine = getButtons("9");
        nine.setOnAction(in);

        plus_minus_division = getButtons("+/-");

        textFieldHbox = new HBox(output);

        cHbox = new HBox(clear,square,squareRoot,division);

        sevenHbox = new HBox(seven,eight,nine,multiply);

        fourHbox = new HBox(four,five,six,minus);

        oneHbox = new HBox(one,two,three,plus);

        allHbox = new HBox(plus_minus_division,zero,dot,equalBtn);

        root = new VBox(textFieldHbox,cHbox,sevenHbox,fourHbox,oneHbox,allHbox);

        Scene scene = new Scene(root);
        primaryStage.setTitle("181380056");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mathExpression(Button btn, String str) {
        btn.setOnAction(e->{
            if (str.equals("sqrt")){
                data=Double.parseDouble(output.getText());
                double ans=Math.sqrt(data);
                output.setText(String.valueOf(ans));
            }
            else if(str.equals("x^2")){
                data=Double.parseDouble(output.getText());
                double square = Math.pow(data,2);
                output.setText(String.valueOf(square));
            }
        });

    }

    private Button getButtons(String text) {
        Button btn = new Button(text);
        btn.setFont(new Font(32));
        btn.setPrefHeight(60);
        btn.setPrefWidth(120);

        return  btn;
    }
    private class  GetButtonInput implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==zero){
                output.setText(output.getText() + "0");
            }
            else if(event.getSource()==one){
                output.setText(output.getText() + "1");
            }
            else if(event.getSource()==two){
                output.setText(output.getText() + "2");
            }
            else if(event.getSource()==three){
                output.setText(output.getText() + "3");
            }
            else if(event.getSource()==four){
                output.setText(output.getText() + "4");
            }
            else if(event.getSource()==five){
                output.setText(output.getText() + "5");
            }
            else if(event.getSource()==six){
                output.setText(output.getText() + "6");
            }
            else if(event.getSource()==seven){
                output.setText(output.getText() + "7");
            }
            else if(event.getSource()==eight){
                output.setText(output.getText() + "8");
            }
            else if(event.getSource()==nine){
                output.setText(output.getText() + "9");
            }
            else if(event.getSource()==dot){
                output.setText(output.getText() + ".");
            }
            else if(event.getSource()==clear){
                output.setText("");
            }
            else if(event.getSource()==plus){
                data = Double.parseDouble(output.getText());
                operation = 1;
                output.setText("");
            }
            else if(event.getSource()==minus){
                data = Double.parseDouble(output.getText());
                operation = 2;
                output.setText("");
            }
            else if(event.getSource()==multiply){
                data = Double.parseDouble(output.getText());
                operation = 3;
                output.setText("");
            }
            else if(event.getSource()==square){
                data = Double.parseDouble(output.getText());
                operation = 5;
                output.setText("");

            }
            else if(event.getSource()==division){
                data = Double.parseDouble(output.getText());
                operation = 4;
                output.setText("");
            }

            else if(event.getSource()==equalBtn){
                double data1 = Double.parseDouble(output.getText());
                switch (operation){
                    case 1:
                        double add = data + data1;
                        output.setText("" + add);
                        break;
                    case 2:
                        double negative = data - data1;
                        output.setText("" + negative);
                        break;
                    case 3:
                        double mul = data * data1;
                        output.setText("" + mul);
                        break;
                    case 4:
                        double div = 0;
                        try {
                            div = data / data1;
                        }
                        catch (Exception e){
                            output.setText("error");
                        }

                        output.setText("" + div);
                        break;
                }
            }

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
