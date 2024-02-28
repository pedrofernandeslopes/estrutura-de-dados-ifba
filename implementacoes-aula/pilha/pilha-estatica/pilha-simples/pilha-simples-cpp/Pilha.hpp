#ifndef PILHA_HPP
#define PILHA_HPP

const int MAX_SIZE = 100;

class Pilha {
private:
    int topo;
    int elementos[MAX_SIZE];
public:
    Pilha();
    bool estaCheia();
    bool estaVazia();
    void empilhar(int valor);
    void desempilhar();
    int topoDaPilha();
};

#endif
