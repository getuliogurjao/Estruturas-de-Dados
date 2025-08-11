package ListaEstatica;

public class ListaEstatica<E>{

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

    private Object[] lista_estatica = ((E[]) new Object[10]);
    private int indice_atual = 0;

    public ListaEstatica(){
        clear();
    }

    public void add(E valor) {
        this.lista_estatica[this.indice_atual] = valor;
        this.indice_atual++;

        if(this.indice_atual == this.lista_estatica.length){
            Object[] lista_auxiliar = ((E[]) new Object[(int) (this.lista_estatica.length*1.5)]);
            for(int i = 0; i < this.lista_estatica.length; i++){
                lista_auxiliar[i] = lista_estatica[i];
            }
            this.lista_estatica = lista_auxiliar;
        }
    }

    public void add(int indice, E valor) {

        try{
            if(indice <= this.indice_atual) {
                if(this.indice_atual == this.lista_estatica.length){
                    Object[] lista_auxiliar = ((E[]) new Object[(int) (this.lista_estatica.length*1.5)]);
                    for(int i = 0; i < this.lista_estatica.length; i++){
                        lista_auxiliar[i] = lista_estatica[i];
                    }
                    this.lista_estatica = lista_auxiliar;
                }
                for (int i = this.indice_atual; i > indice; i--) {
                    this.lista_estatica[i] = this.lista_estatica[i - 1];
                }
                this.lista_estatica[indice] = valor;
                this.indice_atual++;
            }
            else throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.err.println("Índice "+ indice + " da lista ultrapassado para o tamanho " + this.indice_atual + ".");
        }

    }

    public int size() {
        return this.indice_atual;
    }

    public void clear() {
        this.lista_estatica = ((E[]) new Object[10]);
        this.indice_atual = 0;
    }

    public boolean contains(E valor) {

        for(int i = 0; i < this.indice_atual; i++)
            if(this.lista_estatica[i] == valor)
                return true;
        return false;

    }

    public void remove(E valor) {
        for(int i = 0; i < this.indice_atual; i++){
            if(this.lista_estatica[i] == valor){
                this.remove(i);
            }
        }
    }

    public void remove(int indice) {
        for(int i = indice; i < this.indice_atual; i++){
            this.lista_estatica[i] = this.lista_estatica[i+1];
        }
        this.indice_atual--;
    }

    public E get(int indice) {

        try{
            if(indice < this.indice_atual){
                return (E) this.lista_estatica[indice];
            }
            else{
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.err.println("Índice "+ indice + " da lista ultrapassado para o tamanho " + lista_estatica.length+ ".");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int indexOf(E valor) {

        for (int i = 0; i < this.indice_atual; i++) {
            if (this.lista_estatica[i] == valor) return i;
        }

        return -1;
    }

    public String toString(){
        String lista = "[";

        for(int i = 0; i < this.indice_atual; i++){
            lista += this.lista_estatica[i] + ", ";
        }

        return lista.substring(0,lista.length()-2) + "]";
    }
}
