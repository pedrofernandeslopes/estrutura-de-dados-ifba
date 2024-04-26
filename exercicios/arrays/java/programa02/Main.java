package exercicios.arrays.java.programa02;

public class Main {
    public static void main(String[] args) {
        double[] notas = {8.5, 8.9, 6.5, 9.7};
        double soma = 0;
        
        // Calcula a soma de todas as notas
        for (double nota : notas) {
            soma += nota;
        }

        double media = soma / notas.length;

        System.out.println("A média das notas é: " + media);
    }
}
