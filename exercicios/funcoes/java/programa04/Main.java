// Método com Parâmetros Variáveis (Varargs)

package exercicios.funcoes.java.programa04;

public class Main {
    public static void main(String[] args) {
        System.out.println("Soma: " + somar(5, 4, 6, 7, 9));
        System.out.println("Soma: " + somar(10, 20, 30));
    }

    public static int somar(int... numeros) {
        int soma = 0;

        for (int numero: numeros) {
            soma += numero;
        }
        return soma;
    }
}
