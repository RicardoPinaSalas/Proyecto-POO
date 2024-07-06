public class Carta {
    private String color;
    private String tipo;

    public Carta(String color, String tipo) {
        this.color = color;
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean esValidaSobre(Carta otraCarta) {
        return this.color.equals(otraCarta.getColor()) || this.tipo.equals(otraCarta.getTipo()) || this.color.equals("N") || otraCarta.getColor().equals("N");
    }

    @Override
    public String toString() {
        return tipo + color;
    }
}
