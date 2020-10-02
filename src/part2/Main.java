package part2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    MyCheckBox font, color, underline;
    Label text, fontText, colorText, underlineText;
    HBox fontBox, colorBox, underlineBox;

    @Override
    public void start(Stage primaryStage) {

        font = new MyCheckBox(100, 80);
        fontText = new Label("font");
        fontText.setTranslateY(20);
        fontText.setTranslateX(-10);

        color = new MyCheckBox(100, 80);
        colorText = new Label("color");
        colorText.setTranslateY(20);
        colorText.setTranslateX(-10);

        underline = new MyCheckBox(100, 80);
        underlineText = new Label("underline");
        underlineText.setTranslateY(20);
        underlineText.setTranslateX(-10);

        font.selectedProperty().addListener(this::checkboxUpdateListener);
        color.selectedProperty().addListener(this::checkboxUpdateListener);
        underline.selectedProperty().addListener(this::checkboxUpdateListener);

        font.setOnMouseClicked(this::updateCheckbox);
        color.setOnMouseClicked(this::updateCheckbox);
        underline.setOnMouseClicked(this::updateCheckbox);

        fontBox = new HBox();
        fontBox.getChildren().addAll(font, fontText);

        colorBox = new HBox();
        colorBox.getChildren().addAll(color, colorText);

        underlineBox = new HBox();
        underlineBox.getChildren().addAll(underline, underlineText);

        HBox hBoxParent = new HBox();
        hBoxParent.getChildren().addAll(fontBox,colorBox,underlineBox);

        text = new Label("Assignment 2, Part 2");
        text.setFont(new Font("Normal", 35));

        Button quit = new Button("quit");
        quit.setOnAction(this::closeApplication);

        updateCheckbox(font.isSelected());
        updateCheckbox(color.isSelected());
        updateCheckbox(underline.isSelected());

        VBox vBox = new VBox();
        vBox.getChildren().addAll(text, hBoxParent, quit);

        Scene scene = new Scene(vBox, 400, 150);
        vBox.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Assignment 2, Part 2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeApplication(ActionEvent event) {
        System.out.println("Goodbye!");
        Platform.exit();
    }

    private void checkboxUpdateListener(Observable observable, Object oldValue, Object newValue) {
       updateCheckbox((boolean) newValue);
    }
    private void updateCheckbox(MouseEvent event) {
        MyCheckBox widget = ((MyCheckBox) event.getSource());
        updateCheckbox(widget.isSelected());
    }
    private void updateCheckbox(boolean selected){
        Font fontNormal = new Font("Normal", 35);
        text.setTextFill(Color.BLACK);
        text.setUnderline(false);

        if(font.isSelected()){
            fontNormal = Font.font("Arial Black", 35);
        }
        if(color.isSelected()){
            text.setTextFill(Color.BLUE);
        }
        if(underline.isSelected()){
            text.setUnderline(true);
        }
        text.setFont(fontNormal);
    }
}
