package PilhaDinamica;

public class PilhaDinamica<E>{

    private class No<E>{

        public E valor;
        public No<E> proximo;

        public No(E valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private int tamanho;
    private No<E> topo;

    public PilhaDinamica() {
        clear();
    }

    public void push(E valor){
        No<E> novo = new No<>(valor);

        if(tamanho == 0){
            this.topo = novo;
        }else{
            novo.proximo = this.topo;
            this.topo = novo;
        }

        tamanho++;
    }

    public void pop(){
        this.topo = this.topo.proximo;
        tamanho--;
    }

    public int indexOf(E valor) {
        No<E> atual = this.topo;
        int index = 0;

        while(atual != null){
            if(valor.equals(atual.valor)) return tamanho-index-1;
            atual = atual.proximo;
            index++;
        }

        return -1;
    }

    public boolean contains(E valor) {
        No<E> atual = this.topo;

        while(atual != null){
            if(valor.equals(atual.valor)) return true;
            atual = atual.proximo;
        }

        return false;
    }

    public E peek(){
        return this.topo.valor;
    }

    public void clear(){
        this.tamanho = 0;
        this.topo = null;
    }

    public E get(int indice) {
        No<E> atual = this.topo;
        int index = this.tamanho-1;

        while(atual != null){
            if(index == indice) return atual.valor;
            atual = atual.proximo;
            index--;
        }

        return null;
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        if(tamanho == 0) return true;
        else return false;
    }

    public String toString(){
        No<E> atual = this.topo;

        String pilha = "";

        while(atual != null){
            pilha += atual.valor + " ";
            atual = atual.proximo;
        }

        return pilha;
    }

}
