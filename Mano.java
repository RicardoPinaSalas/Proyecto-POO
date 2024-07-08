package ec.edu.espol;
import java.util.ArrayList;

public class Mano {
    private ArrayList<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void quitarCarta(Carta carta) {
        cartas.remove(carta);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    @Override
    public String toString() {
        String mano = "";
        for (Carta carta : cartas) {
            mano += carta + " ";
        }
        return mano;
    }
}