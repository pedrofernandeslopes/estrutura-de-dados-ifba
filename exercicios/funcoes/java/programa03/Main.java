// Sobrecarga de Métodos

package exercicios.funcoes.java.programa03;

public class Main {
    public static void main(String[] args) {
        System.out.println("Soma de inteiros: " + somar(5, 7));
        System.out.println("Soma de decimais: " + somar(2.5, 3.6));
    }

    // Método sobrecarregado para calcular a soma de dois números inteiros
    public static int somar(int a, int b) {
        return a + b;
    }


    // Sobrecarga do método somar para aceitar números decimais (double)
    public static double somar (double a, double b) {
        return a + b;
    }
}
