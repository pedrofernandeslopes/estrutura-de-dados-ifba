public interface Stackable {
    // Métodos principais
   // Insere um elemento no topo da pilha
   void push(Object element);
   // Remove e retorna o elemento do topo da pilha
   Object pop();
   // Retorna o elemento do topo da pilha sem removê-lo
   Object peek();

   // Métodos auxiliares
   // Verifica se a pilha está vazia
   boolean isEmpty();
   // Verifica se a pilha está cheia (para pilhas com tamanho fixo utilizando array)
   boolean isFull();
   // Retorna o tamanho da pilha
   int size();
   // Retorna uma representação em string dos elementos na pilha
   String print();
}
