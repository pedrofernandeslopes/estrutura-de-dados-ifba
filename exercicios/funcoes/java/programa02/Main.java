// Método Recursivo

package exercicios.funcoes.java.programa02;

public class Main {
    public static void main(String[] args) {
        int numero = 5;
        int fatorial = calcularFatorial(numero);
        System.out.println("O fatorial de " + numero + " é:" + fatorial);

    }

    // Método recursivo para calcular o fatorial de um número

    public static int calcularFatorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calcularFatorial(n - 1);
        }
    }
}
