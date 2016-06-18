/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_poc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Davy
 */
public class JavaFX_PoC extends Application {
    
    Stage window;
    Scene scene1, scene2;
    
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("JavaFxPoC");
        
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
          
        //Naam input
        TextField txtNaam = new TextField();
        GridPane.setConstraints(txtNaam, 1, 0);
        txtNaam.setPromptText("Username");
        
        //Password input
        TextField txtPassword = new TextField();
        GridPane.setConstraints(txtPassword, 1, 1);
        txtPassword.setPromptText("Password");
        
        // Button login
        Button btLogin = new Button("Log in");
        btLogin.setOnAction(e -> window.setScene(scene2));
        btLogin.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(btLogin, 1, 2);
        
        //Button exit
        Button btExit = new Button("Exit to desktop");
        btExit.setMaxWidth(Double.MAX_VALUE);
        btExit.setOnAction(e -> closeProgram());
        GridPane.setConstraints(btExit, 1, 3);
        
        grid.getChildren().addAll(txtNaam,txtPassword, btLogin, btExit);
        grid.setAlignment(Pos.CENTER);
        
        //LoginScreen
        scene1 = new Scene(grid, 1380, 720);
        scene1.getStylesheets().add(JavaFX_PoC.class.getResource("Login.css").toExternalForm());
        window.setScene(scene1);      
        window.show();
        
        //MainScreen
        StackPane mainScreen = new StackPane();
        scene2 = new Scene(mainScreen, 1380,720);
        
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        
        
    }
    
    private void closeProgram(){
        Boolean close = ConfirmBox.display("Exit to desktop", "Are you sure you want to exit?");
        if (close)
            window.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
