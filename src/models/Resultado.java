package models;

public class Resultado {

    private String algoritmo;
    private String escenario;
    private int sample;
    private double tiempoNano;
    private double tiempoMilli;

    public Resultado(
            String algoritmo,
            String escenario,
            int sample,
            double tiempoNano,
            double tiempoMilli) {

        this.algoritmo = algoritmo;
        this.escenario = escenario;
        this.sample = sample;
        this.tiempoNano = tiempoNano;
        this.tiempoMilli = tiempoMilli;
    }

    @Override
    public String toString() {

        return "Resultado [algoritmo=" + algoritmo
                + ", escenario=" + escenario
                + ", sample=" + sample
                + ", tiempoNano=" + tiempoNano
                + ", tiempoMilli=" + tiempoMilli
                + "]";
    }
}