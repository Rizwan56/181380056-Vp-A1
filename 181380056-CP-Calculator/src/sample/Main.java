package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {
    private Label titleLabel,dateLabel,markslabel;
    private DatePicker datePicker;
    private TextField marksTextField;
    private Button saveData;
    private HBox titleHbox,datePickerHbox,marksHbox,buttonHbox;
    private BorderPane root;
    private VBox center;
    @Override
    public void start(Stage primaryStage) throws Exception{

        titleLabel = new Label("My CP Tracker");
        titleLabel.setStyle("-fx-font:22px Arial");

        dateLabel = new Label("Date");
        dateLabel.setFont(new Font(16));
        markslabel = new Label("Marks");
        markslabel.setFont(new Font(16));
        datePicker = new DatePicker();
        datePicker.setMaxWidth(150);
        marksTextField = new TextField();
        marksTextField.setMaxWidth(150);
        saveData = new Button("Save Data");
        saveData.setFont(new Font(16));

        ShowAlert show = new ShowAlert();
        saveData.setOnAction(show);
        titleHbox = new HBox(titleLabel);
        titleHbox.setAlignment(Pos.CENTER);
        titleHbox.setPadding(new Insets(40,0,40,0));
        datePickerHbox = new HBox(30,dateLabel,datePicker);
        datePickerHbox.setAlignment(Pos.CENTER);
        marksHbox = new HBox(20,markslabel,marksTextField);
        marksHbox.setAlignment(Pos.CENTER);
        buttonHbox = new HBox(saveData);
        buttonHbox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonHbox.setPadding(new Insets(0,20,0,0));


        buttonHbox.setPrefWidth(250);
        center = new VBox(30,datePickerHbox,marksHbox,buttonHbox);
        center.setMaxWidth(300);
        root = new BorderPane();
        root.setPrefHeight(300);
        root.setPrefWidth(250);
        root.setTop(titleHbox);
        root.setCenter(center);

        Scene scene = new Scene(root);
        primaryStage.setTitle("181380056 CP Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private class ShowAlert implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CP Data Saved");
            alert.setHeaderText("Your CP Data is saved successfully");
            alert.setContentText("----- CP marks on " + datePicker.getValue().toString() + " ---------\n"+ "Marks: " +
                    marksTextField.getText().toString());

            File file = new File("CP.txt");
            Boolean exist = file.exists();

            if(exist){
                try {
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String str = "\n\n----- CP marks on " + datePicker.getValue().toString() + " ---------\n" + "Marks: " +
                            marksTextField.getText().toString();
                    bw.write(str);

                    bw.close();
                    fw.close();
                    alert.show();

                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else {
                try {
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("\n----- CP marks on " + datePicker.getValue().toString() + " ---------\n" + "Marks: " +
                            marksTextField.getText().toString());
                    bw.close();
                }


                catch (IOException e) {
                    e.printStackTrace();
                }
                alert.show();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
