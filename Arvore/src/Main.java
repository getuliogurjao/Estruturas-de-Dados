import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        ArvoreDeBuscaInt arvore = new ArvoreDeBuscaInt();

        int[] vetor = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85, 5, 15, 28, 33, 48,
                52, 63, 67, 78, 82, 90, 3, 12, 18, 27, 31, 38, 42, 46, 51, 58, 62, 66, 73, 77,
                81, 87, 92, 4, 13, 24, 37, 41, 53, 72};

        for(int valor: vetor){
            arvore.add(valor);
        }

//        arvore.remove(11);
//        arvore.remove(12);
//        arvore.remove(28);
//        arvore.remove(22);
//        arvore.remove(17);
//        arvore.remove(14);

        System.out.println(arvore.printPreOrder());
        System.out.println(arvore.printInOrder());
        System.out.println(arvore.printPosOrder());

    }
}