package FilaEstatica;

public class FilaEstatica<E>{

    private E[] fila;
    private int inicio;
    private int fim;

    public FilaEstatica(){
        clear();
    }

    public void clear(){
        this.fila = (E[]) new Object[10];;
        this.inicio = 0;
        this.fim = -1;
    }

    public void enqueue(E valor){
        this.fila[++fim] = valor;
    }

    public E dequeue(){
        this.inicio++;
        return this.fila[inicio-1];
    }

    public E front(){
        return this.fila[inicio];
    }

    public int size(){
        return this.fim - this.inicio + 1;
    }

    public boolean isEmpty(){
        if(this.inicio > this.fim){
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){

        String fila = "";

        for(int i = this.inicio; i <= this.fim; i++){
            fila += this.fila[i] + " ";
        }

        return fila;
    }


}
