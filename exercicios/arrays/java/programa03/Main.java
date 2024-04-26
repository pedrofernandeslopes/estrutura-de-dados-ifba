// Encontrar o Maior Elemento

package exercicios.arrays.java.programa03;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {10, 20 ,5, 15, 30};
        int maior = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }
        System.out.println("O maior elemento do array é: " + maior);
    }
}
