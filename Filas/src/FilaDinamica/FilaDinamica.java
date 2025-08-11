package FilaDinamica;

public class FilaDinamica<E>{

    private class No<E>{

        public E valor;
        public No anterior;
        public No proximo;

        public No(E valor) {
            this.valor = valor;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public FilaDinamica() {
        clear();
    }

    public void enqueue(E valor){
        No novo = new No(valor);

        if(this.tamanho == 0){
            this.inicio = novo;
            this.fim = novo;
        }else{
            this.fim.proximo = novo;
            this.fim = novo;
        }

        this.tamanho++;
    }

    public E dequeue(){

        if(this.tamanho == 0){
            return null;
        }else{
            No removido = this.inicio;

            this.inicio = this.inicio.proximo;
            this.tamanho--;

            return (E) removido.valor;
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
        No atual = this.inicio;

        while(atual != null){
            if(valor.equals(atual.valor)){
                return true;
            }
            atual = atual.proximo;
        }

        return false;
    }

    public E get(int posicao){

        No atual = this.inicio;
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
        No atual = this.inicio;
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
        No atual = this.inicio;
        String texto = "";

        while(atual != null){
            texto += atual.valor + " ";
            atual = atual.proximo;
        }

        return texto;
    }


}
