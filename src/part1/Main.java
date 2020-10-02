package part1;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private CheckBox font, color, underline;
    private Label label;

    @Override
    public void start(Stage primaryStage) {

        label = new Label("Assignment 2, Part 1");
        label.setFont(new Font("Normal", 35));

        Button quit = new Button("quit");
        quit.setOnAction(this::closeApplication);

        font = new CheckBox("font");
        font.setOnAction(this::stylesCheckboxAction);
        color = new CheckBox("color");
        color.setOnAction(this::stylesCheckboxAction);
        underline = new CheckBox("underline");
        underline.setOnAction(this::stylesCheckboxAction);

        HBox options = new HBox(20, font, color, underline);
        options.setAlignment(Pos.CENTER);

        options.setSpacing(20);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, options, quit);

        Scene scene = new Scene(vBox, 400, 150);
        vBox.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Assignment 2, Part 1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeApplication(ActionEvent event){
        System.out.println("Goodbye!");
        Platform.exit();
    }

    private void stylesCheckboxAction(ActionEvent event){
        Font fontNormal = new Font("Normal", 35);
        label.setTextFill(Color.BLACK);
        label.setUnderline(false);

        if(font.isSelected()){
            fontNormal = Font.font("Arial Black", 35);
        }
        if(color.isSelected()){
            label.setTextFill(Color.BLUE);
        }
        if(underline.isSelected()){
            label.setUnderline(true);
        }

        label.setFont(fontNormal);
    }

}


