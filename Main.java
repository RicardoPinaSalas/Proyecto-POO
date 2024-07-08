package ec.edu.espol;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de UNO!");
        System.out.println("Instrucciones:");
        System.out.println("  +2: Fuerza al otro jugador a tomar 2 cartas.");
        System.out.println("  +4: Fuerza al otro jugador a tomar 4 cartas y perder su turno.");
        System.out.println("  ^: Cambia el sentido del juego (de ascendente a descendente o viceversa).");
        System.out.println("  &: Bloquea el turno del otro jugador.");
        System.out.println("  %: Cambia el color del juego.");
        System.out.println("  D: Toma una carta del mazo.");
        System.out.println("  P: Hace un salto de turno.");
        System.out.println("Recuerda que para ingresar una carta debes ingresarla de esta manera (4V, 3A, 6Z, 7R)");
        Juego juego = new Juego();
        juego.jugarPartida();
    }
}