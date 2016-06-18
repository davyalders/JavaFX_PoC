/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_poc;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

        //Grids
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(2);
        
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(2);
        grid3.setHgap(5);
        
        BorderPane border = new BorderPane();
        
  
        //Infobar Icons
        Image imagePopulation = new Image(getClass().getResourceAsStream("population.png"));
        Image imageCurrency = new Image(getClass().getResourceAsStream("money_bag.png"));

        //Infobar Labels
        Label lbPopulation = new Label("4302");
        lbPopulation.setGraphic(new ImageView(imagePopulation));
        GridPane.setConstraints(lbPopulation, 0, 2);
        GridPane.setColumnSpan(lbPopulation, 2);
        
        Label lbDate = new Label("21 Jan 2016");
        GridPane.setConstraints(lbDate, 3, 2);
        GridPane.setColumnSpan(lbDate, 2);
        
        Label lbCurrency = new Label("42.324");
        lbCurrency.setGraphic(new ImageView(imageCurrency));
        GridPane.setConstraints(lbCurrency, 6, 2);
        GridPane.setColumnSpan(lbCurrency, 2);
        
        //Infobar
        final Separator sepVert1 = new Separator();
        sepVert1.setOrientation(Orientation.VERTICAL);
        sepVert1.setValignment(VPos.CENTER);
        sepVert1.setPrefHeight(10);
        GridPane.setConstraints(sepVert1, 2, 2);
        GridPane.setRowSpan(sepVert1, 2);
        
        final Separator sepVert2 = new Separator();
        sepVert2.setOrientation(Orientation.VERTICAL);
        sepVert2.setValignment(VPos.CENTER);
        sepVert2.setPrefHeight(10);
        GridPane.setConstraints(sepVert2, 5, 2);
        GridPane.setRowSpan(sepVert2, 2);

        //Naam input
        TextField txtNaam = new TextField();
        GridPane.setConstraints(txtNaam, 1, 0);
        txtNaam.setPromptText("Username");

        //Password input
        PasswordField txtPassword = new PasswordField();
        GridPane.setConstraints(txtPassword, 1, 1);
        txtPassword.setPromptText("Password");

        //Button login
        Button btLogin = new Button("Log in");
        btLogin.setOnAction(e -> window.setScene(scene2));
        btLogin.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(btLogin, 1, 2);

        //Button exit
        Button btExit = new Button("Exit to desktop");
        btExit.setMaxWidth(Double.MAX_VALUE);
        btExit.setOnAction(e -> closeProgram());
        GridPane.setConstraints(btExit, 1, 3);

        //Main layout              
        Button btMenu = new Button();
        Button btQuestLog = new Button();
        Button btFinance = new Button();
        Button btHappiness = new Button();
        
        //Icons for iconMenu
        Image imageMenu = new Image(getClass().getResourceAsStream("Computer-icon.png"));
        Image imageQuestLog = new Image(getClass().getResourceAsStream("QuestLog.png"));
        Image imageFinance = new Image(getClass().getResourceAsStream("money_bag.png"));
        Image imageHappiness = new Image(getClass().getResourceAsStream("Happiness.png"));
        
        //Set icons on the buttons
        btMenu.setGraphic(new ImageView(imageMenu));
        btQuestLog.setGraphic(new ImageView(imageQuestLog));
        btFinance.setGraphic(new ImageView(imageFinance));
        btHappiness.setGraphic(new ImageView(imageHappiness));
        
        //Button functionality
        btMenu.setOnAction(e -> GameMenu.display());
        
        //Align the buttons
        GridPane.setConstraints(btMenu, 0, 1);
        GridPane.setConstraints(btQuestLog, 1, 1);
        GridPane.setConstraints(btFinance, 2, 1);
        GridPane.setConstraints(btHappiness, 3, 1);

        // Implement grid   
        grid.getChildren().addAll(txtNaam, txtPassword, btLogin, btExit);
        grid.setAlignment(Pos.CENTER);

        grid2.getChildren().addAll(btMenu, btQuestLog, btFinance, btHappiness);
        grid2.setAlignment(Pos.BOTTOM_RIGHT);
        
        grid3.getChildren().addAll(lbPopulation, sepVert1, lbDate, sepVert2, lbCurrency);
        grid3.setAlignment(Pos.TOP_CENTER);
        grid3.setStyle("-fx-background-color: #000000;");
        

        //LoginScreen
        scene1 = new Scene(grid, 1380, 720);
        scene1.getStylesheets().add(JavaFX_PoC.class.getResource("Login.css").toExternalForm());
        window.setScene(scene1);
        window.show();

        //MainScreen
        border.setTop(grid3);
        border.setBottom(grid2);
        scene2 = new Scene(border, 1380, 720);
        scene2.getStylesheets().add(JavaFX_PoC.class.getResource("Main.css").toExternalForm());
 
        //Close application
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

    }

    private void closeProgram() {
        Boolean close = ConfirmBox.display("Exit to desktop", "Are you sure you want to exit?");
        if (close) {
            window.close();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
