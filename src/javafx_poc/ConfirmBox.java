/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_poc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Davy
 */
public class ConfirmBox {
    
    static boolean awnser;
    

     public static boolean display(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        Label lbMessage = new Label();
        lbMessage.setText(message);
        GridPane.setConstraints(lbMessage, 1, 0);
       
        
        Button btYes = new Button("Yes");
        btYes.setMaxWidth(Double.MAX_VALUE);
        btYes.setOnAction(e -> {
            awnser = true;
            window.close();
        });
        GridPane.setConstraints(btYes, 1, 1);
        
        Button btNo = new Button("No");
        btNo.setMaxWidth(Double.MAX_VALUE);
        btNo.setOnAction(e -> {
            awnser = false;
            window.close();
        });
        GridPane.setConstraints(btNo, 1, 2);
        
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.getChildren().addAll(lbMessage, btYes, btNo);
        grid.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(grid, 100, 150);
        scene.getStylesheets().add(JavaFX_PoC.class.getResource("AlertBox.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
        
        return awnser;

     }
}
