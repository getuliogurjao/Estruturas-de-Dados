package ListaDinamica.SimplesmenteEncadeada;

public class ListaDinamicaSE<E>{

    private class No<E> {

        public Object elemento;
        public No proximo;
        public No anterior;

        public No(E elemento){
            this.elemento = elemento;
            this.proximo = null;
            this.anterior = null;
        }

    }

    private No inicio;
    private No fim;
    private int tamanho = 0;

    public ListaDinamicaSE(){
        clear();
    }

    public void add(E valor) {
        No novoNo = new No(valor);

        if(this.inicio == null){
            this.inicio = novoNo;
            this.fim = novoNo;
        }
        else{
            this.fim.proximo = novoNo;
            this.fim = novoNo;
        }

        this.tamanho++;
    }

    public void add(int indice, E valor) {
        No novoNo = new No(valor);
        No auxNo = this.inicio;

        if(indice == 0){
            novoNo.proximo = this.inicio;
            this.inicio = novoNo;
        }
        else if(indice == tamanho){
            this.fim.proximo = novoNo;
            this.fim = novoNo;
        }
        else{
            for(int i = 0; i < tamanho-1; i++){
                auxNo = auxNo.proximo;
            }
            novoNo.proximo = auxNo.proximo;
            auxNo.proximo = novoNo;
        }

        this.tamanho++;

    }

    public int size() {
        return this.tamanho;
    }

    public void clear() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean contains(E valor) {
        No auxNo = inicio;

        while(auxNo != null){
            if(auxNo.elemento.equals(valor)) return true;
            auxNo = auxNo.proximo;
        }
        return false;
    }

    public void remove(E valor) {
        No auxNo = this.inicio;
        No tempNo = auxNo.proximo;

        if(this.inicio.elemento.equals(valor)){
            this.inicio = auxNo.proximo;
        }
        else if (this.fim.elemento.equals(valor)){
            for(int i = 0; i < this.tamanho-2; i++){
                auxNo = auxNo.proximo;
            }
            this.fim = auxNo;
            this.fim.proximo = null;
        }
        else{
            while(auxNo != null){
                if(tempNo.elemento.equals(valor)){
                    auxNo.proximo = tempNo.proximo;
                }
                auxNo = auxNo.proximo;
                tempNo = tempNo.proximo;
            }
        }

        this.tamanho--;
    }

    public void remove(int indice) {
        No auxNo = this.inicio;
        No tempNo;

        if(indice == 0){
            this.inicio = auxNo.proximo;
        }
        else if(indice == this.tamanho-1){
            for(int i = 0; i < this.tamanho-2; i++){
                auxNo = auxNo.proximo;
            }
            this.fim = auxNo;
            this.fim.proximo = null;
        }
        else{
            for(int i = 0; i < indice-1; i++){
                auxNo = auxNo.proximo;
            }
            tempNo = auxNo.proximo;
            auxNo.proximo = tempNo.proximo;
        }

        this.tamanho--;
    }

    public E get(int indice) {
        No auxNo = inicio;

        for(int i = 0; i < indice; i++){
            auxNo = auxNo.proximo;
        }

        return (E) auxNo.elemento;
    }

    public int indexOf(E valor) {
        No auxNo = inicio;
        int cont = 0;

        while(auxNo != null){
            if(auxNo.elemento.equals(valor)) return cont;
            auxNo = auxNo.proximo;
            cont++;
        }

        return -1;
    }

    public String toString(){
        String lista = "[";

        No auxNo = inicio;

        while(auxNo != null){
            lista += auxNo.elemento + ", ";
            auxNo = auxNo.proximo;
        }

        return lista.substring(0,lista.length()-2) + "]";
    }
}

