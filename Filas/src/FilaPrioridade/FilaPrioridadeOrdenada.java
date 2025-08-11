package FilaPrioridade;

public class FilaPrioridadeOrdenada<E>{

    private class No<E>{

        public E valor;
        public int prioridade;
        public No anterior;
        public No proximo;

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

    public FilaPrioridadeOrdenada() {
        clear();
    }

    public void enqueue(E valor, int prioridade){
        No<E> novo = new No<>(valor,prioridade);

        if(this.tamanho == 0){
            this.inicio = novo;
            this.fim = novo;
        }else{
            if(novo.prioridade < this.inicio.prioridade){
                novo.proximo = this.inicio;
                this.inicio.anterior = novo;
                this.inicio = novo;
            }
            else if(novo.prioridade >= this.fim.prioridade){
                this.fim.proximo = novo;
                novo.anterior = this.fim;
                this.fim = novo;
            }
            else{
                No<E> atual = this.inicio;

                while(novo.prioridade > atual.proximo.prioridade){
                    atual = atual.proximo;
                }

                novo.proximo = atual.proximo;
                atual.proximo.anterior = novo;
                atual.proximo = novo;
                novo.anterior = atual;
            }
        }

        this.tamanho++;
    }

    public E dequeue(){

        if(this.tamanho == 0){
            return null;
        }else{
            No<E> removido = this.inicio;

            this.inicio = this.inicio.proximo;
            this.tamanho--;

            return removido.valor;
        }
    }

    public E front(){
        return this.inicio.valor;
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
                return atual.valor;
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
