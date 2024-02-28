#include "Pilha.hpp"
#include <iostream>
using namespace std;

Pilha::Pilha() {
    topo = -1;
}

bool Pilha::estaCheia() {
    return topo == MAX_SIZE - 1;
}

bool Pilha::estaVazia() {
    return topo == -1;
}

void Pilha::empilhar(int valor) {
    if (estaCheia()) {
        cout << "Erro: Pilha cheia\n";
        return;
    }
    topo++;
    elementos[topo] = valor;
}

void Pilha::desempilhar() {
    if (estaVazia()) {
        cout << "Erro: Pilha vazia\n";
        return;
    }
    topo--;
}

int Pilha::topoDaPilha() {
    if (estaVazia()) {
        cout << "Erro: Pilha vazia\n";
        return -1;
    }
    return elementos[topo];
}
