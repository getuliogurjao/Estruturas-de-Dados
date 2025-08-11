package FilaPrioridade;

public class FilaPrioridadeNOrdenada<E>{

    private class No<E>{

        public E valor;
        public int prioridade;
        public No<E> anterior;
        public No<E> proximo;

        public No(E valor) {
            this.valor = valor;
            this.prioridade = 0;
            this.anterior = null;
            this.proximo = null;
        }

        public No(E valor, int prioridade) {
            this.valor = valor;
            this.prioridade = prioridade;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private No<E> inicio;
    private No<E> fim;
    private int tamanho;

    public FilaPrioridadeNOrdenada() {
        clear();
    }

    public void enqueue(E valor, int prioridade){
        No<E> novo = new No<E>(valor, prioridade);

        if(this.tamanho == 0){
            this.inicio = novo;
            this.fim = novo;
        }else{
            this.fim.proximo = novo;
            novo.anterior = this.fim;
            this.fim = novo;
        }

        this.tamanho++;
    }

    public E dequeue(){

        if(this.tamanho == 0){
            return null;
        }else{
            No<E> atual = this.inicio;
            No<E> menor = atual;

            while(atual != null){
                if(atual.prioridade < menor.prioridade) menor = atual;
                atual = atual.proximo;
            }
            if(size() == 1) clear();
            if(menor == this.inicio){
                this.inicio = this.inicio.proximo;
                this.inicio.anterior = null;
            } else if (menor == this.fim) {
                this.fim = this.fim.anterior;
                this.fim.proximo = null;
            }else{
                menor.anterior.proximo = menor.proximo;
                menor.proximo.anterior = menor.anterior;
            }

            return menor.valor;
        }
    }

    public E front(){
        return (E) this.inicio.valor;
    }

    public boolean isEmpty(){
        if(tamanho == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return this.tamanho;
    }

    public boolean contains(E valor){
        No<E> atual = this.inicio;

        while(atual != null){
            if(valor.equals(atual.valor)){
                return true;
            }
            atual = atual.proximo;
        }

        return false;
    }

    public E get(int posicao){

        No<E> atual = this.inicio;
        int index = 0;

        while(atual != null){
            if(index == posicao){
                return (E) atual.valor;
            }
            atual = atual.proximo;
            index++;
        }

        return null;
    }

    public int indexOf(E valor){
        No<E> atual = this.inicio;
        int index = 0;

        while(atual != null){
            if(valor.equals(atual.valor)){
                return index;
            }
            atual = atual.proximo;
            index++;
        }

        return -1;
    }

    public void clear(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public String toString(){
        No<E> atual = this.inicio;
        String texto = "";

        while(atual != null){
            texto += atual.valor + " ";
            atual = atual.proximo;
        }

        return texto;
    }


}
