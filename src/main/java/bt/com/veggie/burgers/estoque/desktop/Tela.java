package bt.com.veggie.burgers.estoque.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        webEngine.load("http://localhost:8080/locais");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(myWebView);
        Image image = new Image("icons/veggie.png");
        Scene scene = new Scene(vBox,700,700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Veggie Burgers Estoque");
        primaryStage.getIcons().add(image);
        primaryStage.setOnCloseRequest(event -> fechar());
        primaryStage.show();
    }
    public void fechar(){
        System.exit(1);
    }
}
