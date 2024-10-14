package dad.calculadora;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class CalculadoraController {

    @FXML
    private TextField screenText;

    @FXML
    private GridPane root;

    private Calculadora calculadora;

    public CalculadoraController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException IOe) {
            throw new RuntimeException(IOe);
        }
    }

    public void initialize() {
        calculadora = new Calculadora();
        
        // Vinculamos la pantalla del modelo con la pantalla de la interfaz
        screenText.textProperty().bind(Bindings.concat(calculadora.pantallaProperty()));
    }

    @FXML
    private void onSevenAction() {
        calculadora.insertar('7');
    }

    @FXML
    private void onEigthAction() {
        calculadora.insertar('8');
    }

    @FXML
    private void onNineAction() {
        calculadora.insertar('9');
    }

    @FXML
    private void onFourAction() {
        calculadora.insertar('4');
    }

    @FXML
    private void onFiveAction() {
        calculadora.insertar('5');
    }

    @FXML
    private void onSixAction() {
        calculadora.insertar('6');
    }

    @FXML
    private void onOneAction() {
        calculadora.insertar('1');
    }

    @FXML
    private void onTwoAction() {
        calculadora.insertar('2');
    }

    @FXML
    private void onThreeAction() {
        calculadora.insertar('3');
    }

    @FXML
    private void onZeroAction() {
        calculadora.insertar('0');
    }

    @FXML
    private void onDotAction() {
        calculadora.insertarComa();
    }

    @FXML
    private void borrar() {
        calculadora.borrar();
    }

    @FXML
    private void borrarTodo() {
        calculadora.borrarTodo();
    }

    @FXML
    private void onPlusAction() {
        calculadora.operar(Calculadora.SUMAR);
    }

    @FXML
    private void onMinusAction() {
        calculadora.operar(Calculadora.RESTAR);
    }

    @FXML
    private void onMultiplicationAction() {
        calculadora.operar(Calculadora.MULTIPLICAR);
    }

    @FXML
    private void onDivisionAction() {
        calculadora.operar(Calculadora.DIVIDIR);
    }

    @FXML
    private void onEqualAction() {
        calculadora.operar(Calculadora.IGUAL);
    }

    public GridPane getRoot() {
        return root;
    }
}

