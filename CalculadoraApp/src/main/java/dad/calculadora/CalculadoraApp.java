package dad.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class CalculadoraApp extends Application {

    private CalculadoraController calculadoraController = new CalculadoraController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(new Scene(calculadoraController.getRoot()));
        primaryStage.show();
    }

}
