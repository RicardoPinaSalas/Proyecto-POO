package ec.edu.espol;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private Baraja baraja;
    private Mano jugador;
    private Mano maquina;
    private ArrayList<Carta> lineaJuego;
    private char colorActual;
    private Scanner scanner;

    public Juego() {
        baraja = new Baraja();
        jugador = new Mano();
        maquina = new Mano();
        lineaJuego = new ArrayList<>();
        scanner = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            jugador.agregarCarta(baraja.robarCarta());
            maquina.agregarCarta(baraja.robarCarta());
        }

        lineaJuego.add(baraja.robarCarta());
        colorActual = lineaJuego.get(0).getColor();
    }

    public void jugarCarta(Carta carta, Mano mano) {
        lineaJuego.add(carta);
        if (carta.getValor().equals("^")) {
            if (mano == jugador) {
                System.out.println("Máquina pierde turno");
            } else {
                System.out.println("Jugador pierde turno");
            }
        } else if (carta.getValor().equals("&")) {
            if (mano == jugador) {
                System.out.println("Máquina pierde turno");
            } else {
                System.out.println("Jugador pierde turno");
            }
        } else if (carta.getValor().equals("%")) {
            System.out.print("Ingrese el nuevo color (R, A, V, Z): ");
            char nuevoColor = scanner.next().charAt(0);
            colorActual = nuevoColor;
        } else if (carta.getValor().equals("+4")) {
            if (mano == jugador) {
                for (int i = 0; i < 4; i++) {
                    maquina.agregarCarta(baraja.robarCarta());
                }
                System.out.println("Máquina toma 4 cartas");
            } else {
                for (int i = 0; i < 4; i++) {
                    jugador.agregarCarta(baraja.robarCarta());
                }
                System.out.println("Jugador toma 4 cartas");
            }
        } else if (carta.getValor().equals("+2")) {
            if (mano == jugador) {
                for (int i = 0; i < 2; i++) {
                    maquina.agregarCarta(baraja.robarCarta());
                }
                System.out.println("Máquina toma 2 cartas");
            } else {
                for (int i = 0; i < 2; i++) {
                    jugador.agregarCarta(baraja.robarCarta());
                }
                System.out.println("Jugador toma 2 cartas");
            }
        } else {
            if (carta.getColor() == colorActual || carta.getValor().equals(lineaJuego.get(lineaJuego.size() - 2).getValor())) {
            } else {
                System.out.println("La carta no es válida");
                return;
            }
        }

        if (mano.getCartas().size() == 1) {
            System.out.println("UNO");
        }

        mano.quitarCarta(carta);
    }
    public void jugarTurno(Mano mano) {
        System.out.println("Mano del jugador: " + jugador);
        System.out.println("Mano de la máquina: " + maquina);
        System.out.println("Carta en mesa: " + lineaJuego.get(lineaJuego.size() - 1));
    
        if (mano == this.jugador) {
            System.out.print("Ingrese la carta que desea jugar: ");
            String cartaInput = scanner.next();
    
            if (cartaInput.equalsIgnoreCase("D")) {
                Carta carta = baraja.robarCarta();
                jugador.agregarCarta(carta);
                System.out.println("Tomaste una carta: " + carta);
            } else if (cartaInput.equalsIgnoreCase("P")) {
                System.out.println("Pasaste el turno.");
            } else {
                String valorInput = cartaInput.substring(0, cartaInput.length() - 1);
                char colorInput = cartaInput.charAt(cartaInput.length() - 1);
    
                Carta cartaJugada = null;
                for (Carta carta : mano.getCartas()) {
                    if (carta.getValor().equals(valorInput) && carta.getColor() == colorInput) {
                        cartaJugada = carta;
                        break;
                    }
                }
    
                if (cartaJugada!= null) {
                    jugarCarta(cartaJugada, mano);
                    mano.quitarCarta(cartaJugada);
                } else {
                    System.out.println("No tienes esa carta en tu mano.");
                }
            }
    
            Carta cartaMaquina = null;
            for (Carta carta : maquina.getCartas()) {
                if (carta.getValor().equals("^") || carta.getValor().equals("&") || carta.getValor().equals("%") || carta.getValor().equals("+4") || carta.getValor().equals("+2") || carta.getColor() == colorActual || carta.getValor().equals(lineaJuego.get(lineaJuego.size() - 1).getValor())) {
                    cartaMaquina = carta;
                    break;
                }
            }
    
            if (cartaMaquina == null) {
                Carta carta = baraja.robarCarta();
                maquina.agregarCarta(carta);
                System.out.println("Máquina tomó una carta: " + carta);
            } else {
                System.out.println("Máquina jugó carta " + cartaMaquina);
                jugarCarta(cartaMaquina, maquina);
            }
    
            System.out.println("Mano del jugador: " + jugador);
            System.out.println("Mano de la máquina: " + maquina);
            System.out.println("Línea del juego: " + lineaJuego.get(lineaJuego.size() - 1));
        }
    }

    public void jugarPartida() {
        while (jugador.getCartas().size() > 0 && maquina.getCartas().size() > 0) {
            jugarTurno(jugador);
        }

        if (jugador.getCartas().size() == 0) {
            System.out.println("¡Ganaste!");
        } else {
            System.out.println("¡Perdiste!");
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugarPartida();
    }
}