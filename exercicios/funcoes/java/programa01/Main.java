// // Método Estático vs Método de Instância

package exercicios.funcoes.java.programa01;

public class Main {
    public static void main(String[] args) {
        // Chamada do método estático diretamente na classe
        metodoEstatico();
        

        // Para chamar o método de instância, precisamos criar uma instância da classe
        Main exemplo = new Main();
        exemplo.metodoDeInstancia();
    }

    public static void metodoEstatico() {
        System.out.println("Método estático");
    }

    public void metodoDeInstancia() {
        System.out.println("Método de instância");
    }
}
