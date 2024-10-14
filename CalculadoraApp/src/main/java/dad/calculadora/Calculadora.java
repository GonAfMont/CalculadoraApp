package dad.calculadora;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Calculadora {
    
    public static final char IGUAL = '=';
    public static final char SUMAR = '+';
    public static final char RESTAR = '-';
    public static final char DIVIDIR = '/';
    public static final char MULTIPLICAR = '*';
    private static final char COMA = '.';

    private Double operando;
    private char operador;
    private Boolean nuevoOperando;
    private StringProperty pantalla;  // Utilizamos un StringProperty para enlazarlo con la interfaz

    public Calculadora() {
        pantalla = new SimpleStringProperty("0.0");
        borrar();
    }

    public StringProperty pantallaProperty() {
        return pantalla;
    }

    public String getPantalla() {
        return pantalla.get();
    }

    public void borrar() {
        operando = 0.0;
        operador = IGUAL;
        borrarTodo();
    }

    public void borrarTodo() {
        nuevoOperando = true;
        pantalla.set("0.0");
    }

    public void operar(char operador) {
        nuevoOperando = true;
        double operando2 = Double.parseDouble(pantalla.get());
        switch (this.operador) {
            case SUMAR: operando += operando2; break;
            case RESTAR: operando -= operando2; break;
            case MULTIPLICAR: operando *= operando2; break;
            case DIVIDIR: operando /= operando2; break;
            case IGUAL: operando = operando2; break;
        }
        this.operador = operador;
        pantalla.set("" + operando);
    }

    public void insertarComa() {
        if (!pantalla.get().contains("" + COMA)) {
            pantalla.set(pantalla.get() + COMA);
        }
    }

    public void insertar(char digito) {
        if (digito >= '0' && digito <= '9') {
            if (nuevoOperando) {
                nuevoOperando = false;
                pantalla.set("");
            }
            pantalla.set(pantalla.get() + digito);
        } else if (digito == COMA) {
            insertarComa();
        }
    }
}

