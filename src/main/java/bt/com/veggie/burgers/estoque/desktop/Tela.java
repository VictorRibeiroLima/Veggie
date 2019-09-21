package bt.com.veggie.burgers.estoque.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Tela extends Application {
    public static void run(String[] args){
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView myWebView = new WebView();
        WebEngine webEngine = myWebView.getEngine();
        webEngine.load("http://localhost:8080/login");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(myWebView);

        Scene scene = new Scene(vBox,800,800);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> fechar());
        primaryStage.show();
    }
    public void fechar(){
        System.exit(1);
    }
}
