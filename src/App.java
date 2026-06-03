import controllers.SortPersonaMethods;
import models.GeneradorPersonas;
import models.Persona;
import models.Resultado;
import utils.Benchmarking;

public class App {

    public static void main(String[] args) {

        int[] muestras = {10000, 50000, 100000};

        SortPersonaMethods sortMethods = new SortPersonaMethods();

        System.out.println("========== ESCENARIO 1: ARREGLO DESORDENADO ==========\n");

        for (int muestra : muestras) {

            Persona[] personas = GeneradorPersonas.generarPersonas(muestra);

            Persona[] copiaInsertion = personas.clone();
            Persona[] copiaQuick = personas.clone();

            Resultado resultadoInsertion = Benchmarking.medir(
                    () -> sortMethods.insertionSort(copiaInsertion),
                    "Insertion Sort",
                    muestra,
                    "Desordenado");

            Resultado resultadoQuick = Benchmarking.medir(
                    () -> sortMethods.quickSort(
                            copiaQuick,
                            0,
                            copiaQuick.length - 1),
                    "Quick Sort",
                    muestra,
                    "Desordenado");

            System.out.println(resultadoInsertion);
            System.out.println(resultadoQuick);
            System.out.println();
        }

        System.out.println("\n========== ESCENARIO 2: ORDENADO + NUEVA PERSONA ==========\n");

        for (int muestra : muestras) {

            Persona[] personas = GeneradorPersonas.generarPersonas(muestra);

            sortMethods.quickSort(personas, 0, personas.length - 1);

            Persona[] personasMasUna = new Persona[muestra + 1];

            System.arraycopy(
                    personas,
                    0,
                    personasMasUna,
                    0,
                    personas.length);

            personasMasUna[muestra] =
                    new Persona("PersonaNueva", 50);

            Persona[] copiaInsertion = personasMasUna.clone();
            Persona[] copiaQuick = personasMasUna.clone();

            Resultado resultadoInsertion = Benchmarking.medir(
                    () -> sortMethods.insertionSort(copiaInsertion),
                    "Insertion Sort",
                    muestra + 1,
                    "Ordenado + Nueva Persona");

            Resultado resultadoQuick = Benchmarking.medir(
                    () -> sortMethods.quickSort(
                            copiaQuick,
                            0,
                            copiaQuick.length - 1),
                    "Quick Sort",
                    muestra + 1,
                    "Ordenado + Nueva Persona");

            System.out.println(resultadoInsertion);
            System.out.println(resultadoQuick);
            System.out.println();
        }
    }
}