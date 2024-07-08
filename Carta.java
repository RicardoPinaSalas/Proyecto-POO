package ec.edu.espol;

public class Carta {
    private char color;
    private String valor;

    public Carta(char color, String valor) {
        this.color = color;
        this.valor = valor;
    }

    public char getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + color;
    }
}