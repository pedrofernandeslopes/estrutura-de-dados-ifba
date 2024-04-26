// Inverter um Array

package exercicios.arrays.java.programa04;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};

        // Inicializa um array temporário para armazenar os elementos invertidos
        int[] invertido = new int[numeros.length];
        int indice = 0;

        // Itera sobre o array original, começando do final, e armazena os elementos no array invertido
        for (int i = numeros.length - 1; i >= 0; i--) {
            invertido[indice] = numeros[i];
            indice++;
        }

        // Imprime o array invertido
        System.out.print("Array invertido: ");
        for (int numero : invertido) {
            System.out.print(numero + " ");
        }
    }
}
