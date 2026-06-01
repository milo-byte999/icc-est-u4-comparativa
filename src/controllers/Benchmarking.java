package controllers;

import models.Resultado;

public class Benchmarking {

    public static Resultado medir(Runnable algoritmo, String nombreAlgoritmo, int muestra, String escenario) {
        long startTime = System.nanoTime();
        algoritmo.run();
        long endTime = System.nanoTime();
        long tiempo = endTime - startTime;
        return new Resultado(nombreAlgoritmo, escenario, muestra, tiempo, tiempo);
    }
}