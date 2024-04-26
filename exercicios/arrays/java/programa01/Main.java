// Escreva um programa Java que calcula a soma de todos os elementos em um array de inteiros

package exercicios.arrays.java.programa01;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};

        // Chamada da função para calcular a soma
        int resultado = calcularSoma(numeros);

        System.out.println("A soma dos elementos do array é: " + resultado);
    }

    public static int calcularSoma(int[] array) {
        int soma = 0;
        for (int numero : array) {
            soma += numero;
        }
        return soma;
    }
}
