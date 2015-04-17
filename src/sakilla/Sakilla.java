/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakilla;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author ravklk
 */
public class Sakilla extends Application {

    private Map<String, String> windowParameters;

    @Override
    public void start(Stage primaryStage) {
        Parameters parameters = getParameters();
        windowParameters = parameters.getNamed();
        
        StackPane root = new StackPane();
       
        Scene scene = new Scene(
                root, windowParameters.get("w") == null ? 300 : Integer.parseInt(windowParameters.get("w")), 
                windowParameters.get("h") == null ? 300 : Integer.parseInt(windowParameters.get("h"))
        );

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load(windowParameters.get("l"));
        
        root.getChildren().add(webView);
        
        primaryStage.setTitle(windowParameters.get("t"));        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
