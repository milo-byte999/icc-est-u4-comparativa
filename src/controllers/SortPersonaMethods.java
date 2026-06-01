package controllers;

import models.Persona;

public class SortPersonaMethods {

    public void insertionSort(Persona[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Persona key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getCriterioOrdenamiento() > key.getCriterioOrdenamiento()) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = key;
        }
    }

    public void quickSort(Persona[] personas, int low, int high) {
        if (low < high) {
            int pi = partition(personas, low, high);
            quickSort(personas, low, pi - 1);
            quickSort(personas, pi + 1, high);
        }
    }

    public int partition(Persona[] personas, int low, int high) {
        Persona pivot = personas[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (personas[j].getCriterioOrdenamiento() < pivot.getCriterioOrdenamiento()) {
                i++;
                Persona temp = personas[i];
                personas[i] = personas[j];
                personas[j] = temp;
            }
        }
        Persona temp = personas[i + 1];
        personas[i + 1] = personas[high];
        personas[high] = temp;
        return i + 1;
    }
}