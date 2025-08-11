public interface Pilha<E> {

    void push(E valor);

    E pop();

    int indexOf(E valor);

    boolean contains(E valor);

    int size();

    void clear();

    E get(int indice);

    E peek();

    String toString();
}
