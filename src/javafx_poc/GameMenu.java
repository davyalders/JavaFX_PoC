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
public class GameMenu {
    
        
    public static void display(){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Menu");
        window.setMinWidth(220);
        window.setMinHeight(300);
        
        Button btSettings = new Button("Settings");
        btSettings.setMaxWidth(Double.MAX_VALUE);
        btSettings.setOnAction(e -> window.close());
        GridPane.setConstraints(btSettings, 1, 0);
        
        Button btKeybinds = new Button("Keybinds");
        btKeybinds.setMaxWidth(Double.MAX_VALUE);
        btKeybinds.setOnAction(e -> window.close());
        GridPane.setConstraints(btKeybinds, 1, 1);
        
        Button btSave = new Button("Save");
        btSave.setMaxWidth(Double.MAX_VALUE);
        btSave.setOnAction(e -> window.close());
        GridPane.setConstraints(btSave, 1, 2);
        
        Button btLoad = new Button("Load");
        btLoad.setMaxWidth(Double.MAX_VALUE);
        btLoad.setOnAction(e -> window.close());
        GridPane.setConstraints(btLoad, 1, 3);
        
        Button btSaveExit = new Button("Save and exit");
        btSaveExit.setMaxWidth(Double.MAX_VALUE);
        btSaveExit.setOnAction(e -> window.close());
        GridPane.setConstraints(btSaveExit, 1, 4);
        
        Button btResume = new Button("Resume game");
        btResume.setMaxWidth(Double.MAX_VALUE);
        btResume.setOnAction(e -> window.close());
        GridPane.setConstraints(btResume, 1, 5);
        
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.getChildren().addAll(btSettings, btKeybinds, btSave, btLoad, btSaveExit, btResume);
        grid.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(grid, 100, 150);
        scene.getStylesheets().add(JavaFX_PoC.class.getResource("AlertBox.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
        
    }
    
}
