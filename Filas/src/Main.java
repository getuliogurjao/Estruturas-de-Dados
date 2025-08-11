import FilaPrioridade.FilaPrioridadeNOrdenada;

public class Main {
    public static void main(String[] args) {
        FilaPrioridadeNOrdenada<String> fila = new FilaPrioridadeNOrdenada<>();

        fila.enqueue("Pedro",0);
        fila.enqueue("Cleitinho",5);
        fila.enqueue("Clebinho",5);
        fila.enqueue("Arrascaeta",6);
        fila.enqueue("Josimar",-1);
        fila.enqueue("Clodoaldo",3);


    }
}