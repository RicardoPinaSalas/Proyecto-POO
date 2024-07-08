package ec.edu.espol;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        for (char color : new char[] {'R', 'A', 'V', 'Z'}) {
            for (int i = 0; i <= 9; i++) {
                cartas.add(new Carta(color, String.valueOf(i)));
            }
        }
        for (String comodin : new String[] {"^", "&", "%", "+4", "+2"}) {
            if (comodin.equals("+4") || comodin.equals("+2")) {
                cartas.add(new Carta('N', comodin));
            } else {
                for (char color : new char[] {'R', 'A', 'V', 'Z'}) {
                    cartas.add(new Carta(color, comodin));
                }
            }
        }
        Collections.shuffle(cartas);
    }

    public Carta robarCarta() {
        return cartas.remove(0);
    }
}