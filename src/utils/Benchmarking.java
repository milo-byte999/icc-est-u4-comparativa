package utils;
import models.Resultado;

public class Benchmarking {

    public static Resultado medir(
            Runnable algoritmo,
            String nombreAlgoritmo,
            int muestra,
            String escenario) {

        long startTime = System.nanoTime();

        algoritmo.run();

        long endTime = System.nanoTime();
        long tiempoNano = endTime - startTime;
        double tiempoMilli = tiempoNano / 1000000.0;

        return new Resultado(
                nombreAlgoritmo,
                escenario,
                muestra,
                tiempoNano,
                tiempoMilli);
    }
}