/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycontrol;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




/**
 *
 * @author Lab
 */
public class MyControlDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MyControl myControl = MyControlBuilder.create()
                                              .color(Color.RED)
                                              .build();
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(5,5,5,5));
        pane.getChildren().add(myControl);
        
        Scene scene = new Scene(pane);
        
        stage.setTitle("Java One 2012");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main (final String[] args) {
        Application.launch(args);
    }
    
    
    
}
