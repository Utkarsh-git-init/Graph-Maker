package com.example.graphmaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage primarystage;
    @Override
    public void start(Stage stage) throws IOException {
        primarystage=stage;
        AnchorPane root=FXMLLoader.load(HelloApplication.class.getResource("First-Scene.fxml"));
        Scene scene = new Scene(root);
        //Line line=new Line(100,200,200,300);
        //root.getChildren().add(line);
        stage.setResizable(false);
        stage.setTitle("Graph Maker");
        Image icon=new Image(getClass().getResource("icon.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}