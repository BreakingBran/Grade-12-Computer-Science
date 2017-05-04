/*
import javafx.event.ActionEvent;

import com.sun.scenario.effect.impl.prism.PrImage;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application {

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub ASas
        primaryStage.setTitle("Banking System");
        button = new Button();
        button.setText("Create New user");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                System.out.println("I exist");
            }
        });

        //Below statement does exactly what above statement does but only allowed in java 8
        //button.setOnAction(e -> System.out.println("I exist"));
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}


 * public class Main extends Application implements EventHandler<ActionEvent>{
 * 
 * Button button;
 * 
 * public static void main(String[] args) { launch(args); }
 * 
 * @Override public void start(Stage primaryStage) throws Exception { // TODO
 * Auto-generated method stub ASas primaryStage.setTitle("Banking System");
 * button = new Button(); button.setText("Create New user");
 * button.setOnAction(this);
 * 
 * 
 * StackPane layout = new StackPane(); layout.getChildren().add(button);
 * 
 * 
 * Scene scene = new Scene(layout,300,250); primaryStage.setScene(scene);
 * 
 * primaryStage.show(); }
 * 
 * @Override public void handle(ActionEvent event) { // TODO Auto-generated
 * method stub if(event.getSource() == button) {
 * System.out.println("Will create new account"); } } }
 
*/