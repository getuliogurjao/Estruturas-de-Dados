package PilhaEstatica;

public class PilhaEstatica<E>{

    public E[] v;
    private int top;

    public PilhaEstatica(){
        this.v = ((E[]) new Object[10]);
        this.top = -1;
    }

    public PilhaEstatica(int n){
        this.v = ((E[]) new Object[n]);
        this.top = -1;
    }

    public void push(E valor){
        this.top++;
        this.v[this.top] = valor;
    }

    public void pop(){
        top--;
    }

    public E peek(){
        return this.v[this.top];
    }

    public boolean contains(E valor){
        for(int i = 0; i <= this.top; i++){
            if(this.v[i].equals(valor)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E valor){
        for(int i = 0; i <= this.top; i++){
            if(this.v[i].equals(valor)){
                return i;
            }
        }
        return -1;
    }

    public E get(int indice){
        if(indice <= this.top) return this.v[indice];
        else return null;
    }

    public void clear(){
        this.top = -1;
    }

    public int size(){
        return (this.top+1);
    }

    public boolean isEmpty(){
        if(this.top == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String pilha = "";

        for(int i = this.top; i >= 0; i--){
            pilha += this.v[i] + " ";
        }

        return pilha;
    }
}
