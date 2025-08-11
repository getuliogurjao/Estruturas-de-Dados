package ListaDinamicaOrdenada.DuplamenteEncadeada.String;

public class ListaDinamicaDEOrdenada_String {

    private class No implements Comparable<String> {

        public String elemento;
        public No proximo;
        public No anterior;

        public No(String elemento){
            this.elemento = elemento;
            this.proximo = null;
            this.anterior = null;
        }


        @Override
        public int compareTo(String o) {
            return this.elemento.compareTo(o);
        }
    }

    private No inicio;
    private No fim;
    private int tamanho = 0;

    public ListaDinamicaDEOrdenada_String(){
        clear();
    }

    public void add(String valor) {
        No novoNo = new No(valor);

        if(this.inicio == null){
            this.inicio = novoNo;
            this.fim = novoNo;
        }
        else{
            if(novoNo.elemento.compareTo(this.inicio.elemento) < 0) {
                this.inicio.anterior = novoNo;
                novoNo.proximo = this.inicio;
                this.inicio = novoNo;
            }
            else if (novoNo.elemento.compareTo(this.fim.elemento) > 0){
                this.fim.proximo = novoNo;
                novoNo.anterior = this.fim;
                this.fim = novoNo;
            }
            else {
                No auxNo = this.inicio;
                No tempNo = this.inicio.proximo;

                while (tempNo.elemento.compareTo(novoNo.elemento) < 0) {
                    auxNo = tempNo;
                    tempNo = tempNo.proximo;
                }

                novoNo.proximo = tempNo;
                tempNo.anterior = novoNo;
                auxNo.proximo = novoNo;
                novoNo.anterior = auxNo;
            }
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

    public boolean contains(String valor) {
        No auxNo = inicio;

        while(auxNo != null){
            if(auxNo.elemento.equals(valor)) return true;
            auxNo = auxNo.proximo;
        }
        return false;
    }

    public void remove(String valor) {
        No auxNo = this.inicio;
        No tempNo = auxNo.proximo;

        if(this.inicio.elemento.equals(valor)){
            this.inicio = auxNo.proximo;
            this.inicio.anterior = null;
        }
        else if (this.fim.elemento.equals(valor)){
            this.fim = this.fim.anterior;
            this.fim.proximo = null;
        }
        else{
            while(auxNo != null){
                if(tempNo.elemento.equals(valor)){
                    auxNo.proximo = tempNo.proximo;
                    tempNo.proximo.anterior = auxNo;
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
            this.inicio.anterior = null;
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
            tempNo.proximo.anterior = auxNo;
        }

        this.tamanho--;
    }

    public String get(int indice) {
        No auxNo = inicio;

        for(int i = 0; i < indice; i++){
            auxNo = auxNo.proximo;
        }

        return auxNo.elemento;
    }

    public int indexOf(int valor) {
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

        No auxNo = this.inicio;

        while(auxNo != null){
            lista += auxNo.elemento + ", ";
            auxNo = auxNo.proximo;
        }

        return lista.substring(0,lista.length()-2) + "]";
    }
}


