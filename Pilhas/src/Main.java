import PilhaDinamica.PilhaDinamica;
import PilhaEstatica.PilhaEstatica;

public class Main {
    public static void main(String[] args) {

        PilhaEstatica<Integer> pilha = new PilhaEstatica<Integer>(50);

        for(int i = 0; i < 50; i++) pilha.push(i);

        System.out.println(pilha);

        pilha.pop();

        System.out.println(pilha);

        pilha.pop();
        pilha.pop();

        System.out.println(pilha);
        System.out.println(pilha.peek());
        System.out.println(pilha.indexOf(40));
        System.out.println(pilha.get(25));
        System.out.println(pilha.size());
        System.out.println(pilha.contains(47));
        System.out.println(pilha.isEmpty());
    }
}