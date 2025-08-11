public interface Listas<E> {

    void add(E valor);

    void add(int indice,E valor);

    int size();

    void clear();

    boolean contains(E valor);

    void remove(Integer valor);

    void remove(int indice);

    E get(int indice);

    int indexOf(E valor);

    String toString();
}
