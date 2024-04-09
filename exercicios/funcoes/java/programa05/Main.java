// Método com Parâmetros de Referência

package exercicios.funcoes.java.programa05;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        dobrarValores(numeros);
        for (int numero : numeros) {
            System.out.println(numero);
        }

    }

    public static void dobrarValores(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }
}
