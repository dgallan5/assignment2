package part2;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class MyCheckBox extends Pane{

    public static int xLocation = 60;
    public static int yLocation = 20;
    private Canvas canvas;
    private BooleanProperty booleanProperty;

    public MyCheckBox(int width, int height)
    {
        super();
        canvas = new Canvas(width, height);
        this.getChildren().add(canvas);
        booleanProperty = new SimpleBooleanProperty();
        setSelected(false);
        checkboxDetection();

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(isSelected()){
                    setSelected(false);
                }
                else {
                    setSelected(true);
                }
                checkboxDetection();
            }
        });

        booleanProperty.addListener((observable, oldValue, newValue) -> {
            checkboxDetection();
        });
    }

    private void drawSquare() {
        canvas.getGraphicsContext2D().setLineWidth(2);
        canvas.getGraphicsContext2D().strokeRect(xLocation, yLocation, 20, 20);
    }

    public BooleanProperty selectedProperty() {
        return booleanProperty;
    }
    public boolean isSelected() {
        return booleanProperty.get();
    }
    public void setSelected(boolean selected){
        booleanProperty.set(selected);
    }

    private void checkboxDetection(){
        if(isSelected()){
            canvas.getGraphicsContext2D().strokeLine(xLocation, yLocation, xLocation + 20, yLocation + 20);
            canvas.getGraphicsContext2D().strokeLine(xLocation, yLocation + 20, xLocation + 20, yLocation);
        }
        else{
            canvas.getGraphicsContext2D().clearRect(xLocation, yLocation, xLocation + 19, yLocation + 19);
            drawSquare();
        }
    }
}
