import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        inicializarBaraja();
        barajar();
    }

    private void inicializarBaraja() {
        String[] colores = {"R", "A", "V", "Z"};
        String[] tipos = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "^", "&", "+2"};

        for (String color : colores) {
            for (String tipo : tipos) {
                cartas.add(new Carta(color, tipo));
                if (!tipo.equals("0")) {
                    cartas.add(new Carta(color, tipo));
                }
            }
        }

        String[] comodinesNegros = {"+4", "%"};
        for (String tipo : comodinesNegros) {
            cartas.add(new Carta("N", tipo));
            cartas.add(new Carta("N", tipo));
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta robarCarta() {
        return cartas.remove(0);
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }
}
