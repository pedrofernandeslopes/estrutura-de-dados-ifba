#include <iostream>
#include "Pilha.hpp"
using namespace std;

int main() {
    Pilha pilha;

    // Testando a pilha
    pilha.empilhar(1);
    pilha.empilhar(2);
    pilha.empilhar(3);

    cout << "Topo da pilha: " << pilha.topoDaPilha() << endl;

    pilha.desempilhar();
    cout << "Topo da pilha apos desempilhar: " << pilha.topoDaPilha() << endl;

    return 0;
}