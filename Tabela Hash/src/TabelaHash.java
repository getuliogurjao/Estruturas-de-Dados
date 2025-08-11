public class TabelaHash {

    private Arvore[] vetor;

    public TabelaHash(int tamanho){
        this.vetor = new Arvore[tamanho];
    }

    public TabelaHash(){
        this.vetor = new Arvore[10];
    }

    private int hashFunction(String palavra) {
            return (int) (palavra.charAt(0))-65;
    }

    public void add(String palavra){
        int posicao = hashFunction(palavra);

        if(vetor[posicao] == null){
            vetor[posicao] = new Arvore(palavra);
        };

    }

    public void remove(){

    }

    public void clear(){

    }

    public boolean contains(){

    }

    public boolean isEmpty(){

    }

    public int size(){

    }

}
