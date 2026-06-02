import utils.Benchmarking;
import controllers.SortPersonaMethods;
import models.GeneradorPersonas;
import models.Persona;
import models.Resultado;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] muestras = { 10000, 50000, 100000 };

        SortPersonaMethods sortMethods = new SortPersonaMethods();

        for (int muestra : muestras) {

            Persona[] personas = GeneradorPersonas.generarPersonas(muestra);

            Persona[] copiaInsertion = personas.clone();
            Persona[] copiaQuick = personas.clone();

            Resultado resultadoInsertion = Benchmarking.medir(
                    () -> sortMethods.insertionSort(copiaInsertion),
                    "Insertion Sort",
                    muestra,
                    "Ordenamiento de personas");

            System.out.println(resultadoInsertion);

            Resultado resultadoQuick = Benchmarking.medir(
                    () -> sortMethods.quickSort(
                            copiaQuick,
                            0,
                            copiaQuick.length - 1),
                    "Quick Sort",
                    muestra,
                    "Ordenamiento de personas");

            System.out.println(resultadoQuick);
        }
    }
}