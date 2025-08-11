public class ArvoreDeBuscaStringTeste {

    private class No{

        public String elemento;
        public No filhoEsquerdo;
        public No filhoDireito;
        private int fb;

        public No(String elemento) {
            this.elemento = elemento;
            this.filhoEsquerdo = null;
            this.filhoDireito = null;
            this.fb = 0;
        }

        public boolean temDireita(){
            return  filhoDireito != null;
        }

        public boolean temEsquerda(){
            return  filhoEsquerdo != null;
        }

    }

    private No raiz;

    public ArvoreDeBuscaStringTeste(){
        this.raiz = null;
    }

    public void add(String elemento){

        if(this.raiz == null) this.raiz = new No(elemento);
        else add(elemento,this.raiz,this.raiz);
    }

    private void add(String elemento,No atual, No paiAtual){

        if(elemento.compareTo(atual.elemento) < 0){

            if(atual.temEsquerda()) {

                add(elemento,atual.filhoEsquerdo,atual);
                if(atual.temEsquerda() && atual.filhoEsquerdo.fb != 0) atual.fb++;

            }
            else{

                atual.filhoEsquerdo = new No(elemento);
                atual.fb++;

            }

        }
        else if(elemento.compareTo(atual.elemento) > 0){

            if(atual.temDireita()){

                add(elemento,atual.filhoDireito,atual);
                if(atual.temDireita() && atual.filhoDireito.fb != 0) atual.fb--;

            }
            else{

                atual.filhoDireito = new No(elemento);
                atual.fb--;

            }

        }

        verificarBalanceamento(atual,paiAtual);

    }

    private void verificarBalanceamento(No atual, No paiAtual){

        if (atual.fb > 1 || atual.fb < -1) {
            if (paiAtual != null) {
                if (paiAtual.filhoEsquerdo == atual) {
                    paiAtual.filhoEsquerdo = balanceamento(atual);
                } else if (paiAtual.filhoDireito == atual) {
                    paiAtual.filhoDireito = balanceamento(atual);
                }
            }
        }

    }

    private No balanceamento(No atual){

        if(atual.fb < -1) {
            if (atual.filhoDireito.fb > 0) return rotacaoDuplaEsquerda(atual);
            else return rotacaoEsquerda(atual);
        }
        else if(atual.fb > 1) {
            if(atual.filhoEsquerdo.fb < 0) return rotacaoDuplaDireita(atual);
            else return rotacaoDireita(atual);
        }

        return null;

    }

    private No rotacaoEsquerda(No raizDesbalanceada){

        No filhoDireitoRaizDesbalanceada = raizDesbalanceada.filhoDireito;

        raizDesbalanceada.filhoDireito = filhoDireitoRaizDesbalanceada.filhoEsquerdo;
        filhoDireitoRaizDesbalanceada.filhoEsquerdo = raizDesbalanceada;

        raizDesbalanceada.fb = 0;
        filhoDireitoRaizDesbalanceada.fb = 0;

        return filhoDireitoRaizDesbalanceada;

    }

    private No rotacaoDireita(No raizDesbalanceada){

        No filhoEsquerdoRaizDesbalanceada = raizDesbalanceada.filhoEsquerdo;

        raizDesbalanceada.filhoEsquerdo = filhoEsquerdoRaizDesbalanceada.filhoDireito;
        filhoEsquerdoRaizDesbalanceada.filhoDireito = raizDesbalanceada;

        raizDesbalanceada.fb = 0;
        filhoEsquerdoRaizDesbalanceada.fb = 0;

        return filhoEsquerdoRaizDesbalanceada;

    }

    private No rotacaoDuplaEsquerda(No raizDesbalanceada){
        raizDesbalanceada.filhoDireito = rotacaoDireita(raizDesbalanceada.filhoDireito);
        return rotacaoEsquerda(raizDesbalanceada);
    }

    private No rotacaoDuplaDireita(No raizDesbalanceada){
        raizDesbalanceada.filhoEsquerdo = rotacaoEsquerda(raizDesbalanceada.filhoEsquerdo);
        return rotacaoDireita(raizDesbalanceada);
    }

    public void remove(String elemento){

        if(elemento.compareTo(this.raiz.elemento) == 0){

            if (this.raiz.temEsquerda()) {

                this.raiz.elemento = maiorValor(this.raiz.filhoEsquerdo);
                remove(this.raiz.elemento, this.raiz.filhoEsquerdo, this.raiz);

            } else if (this.raiz.temDireita()) {

                this.raiz.elemento = maiorValor(this.raiz.filhoDireito);
                remove(this.raiz.elemento, this.raiz.filhoDireito, this.raiz);

            } else {

                this.raiz = null;

            }

        }

        if(raiz != null){
            remove(elemento, raiz, null);
        }

    }

    public void remove(String elemento, No atual, No paiAtual){

        if(elemento.compareTo(atual.elemento) == 0){

            if(atual.temEsquerda() && atual.temDireita()){

                atual.elemento = menorValor(atual.filhoDireito);
                remove(atual.elemento, atual.filhoDireito, atual);

            }
            else if(atual.temEsquerda()){

                if(atual == paiAtual.filhoEsquerdo){
                    paiAtual.filhoEsquerdo = atual.filhoEsquerdo;
                }
                else{
                    paiAtual.filhoDireito = atual.filhoEsquerdo;
                }

            }
            else if(atual.temDireita()){

                if(atual == paiAtual.filhoEsquerdo){
                    paiAtual.filhoEsquerdo = atual.filhoDireito;
                }
                else{
                    paiAtual.filhoDireito = atual.filhoDireito;
                }

            }
            else{

                if(atual == paiAtual.filhoEsquerdo){
                    paiAtual.filhoEsquerdo = null;
                }
                else{
                    paiAtual.filhoDireito = null;
                }

            }

        }
        else if(elemento.compareTo(atual.elemento) < 0){

            if(atual.temEsquerda()) remove(elemento, atual.filhoEsquerdo, atual);

        }
        else if(elemento.compareTo(atual.elemento) > 0){

            if(atual.temDireita()) remove(elemento, atual.filhoDireito, atual);

        }

    }

    public boolean isEmpty(){
        return this.raiz == null;
    }

    private String menorValor(No atual){

        if(atual.temEsquerda()) return menorValor(atual.filhoEsquerdo);
        else return atual.elemento;

    }

    private String maiorValor(No atual){

        if(atual.temDireita()) return maiorValor(atual.filhoDireito);
        return atual.elemento;

    }

    public boolean contains(String elemento){

        if(this.raiz == null) return false;
        else return contains(elemento,this.raiz);

    }

    private boolean contains(String elemento, No atual){

        if(elemento.compareTo(atual.elemento) == 0) return true;
        else if (elemento.compareTo(atual.elemento) < 0){

            if(atual.temEsquerda()) return contains(elemento,atual.filhoEsquerdo);
            else return false;

        }
        else if (elemento.compareTo(atual.elemento) > 0) {

            if(atual.temDireita()) return contains(elemento,atual.filhoDireito);
            else return false;

        }

        return false;

    }

    public void printPreOrder(){

        if(this.raiz != null){
            printPreOrder(this.raiz);
            System.out.println();
        }

    }

    private void printPreOrder(No atual){

        System.out.print(atual.elemento + " ");

        if(atual.temEsquerda()) printPreOrder(atual.filhoEsquerdo);

        if(atual.temDireita()) printPreOrder(atual.filhoDireito);

    }

    public void printInOrder(){

        if(this.raiz != null){
            printInOrder(this.raiz);
            System.out.println();
        }

    }

    private void printInOrder(No atual){

        if(atual.temEsquerda()) printInOrder(atual.filhoEsquerdo);

        System.out.print(atual.elemento + " " + atual.fb + "\n");

        if(atual.temDireita()) printInOrder(atual.filhoDireito);

    }

    public void printPosOrder(){

        if(this.raiz != null){
            printPosOrder(this.raiz);
            System.out.println();
        }

    }

    private void printPosOrder(No atual){

        if(atual.temEsquerda()) printPosOrder(atual.filhoEsquerdo);

        if(atual.temDireita()) printPosOrder(atual.filhoDireito);

        System.out.print(atual.elemento + " ");

    }

    public String printTeste(){

        String texto = "";

        if(this.raiz != null){
            texto = printTeste(this.raiz,texto);
        }
        return texto;
    }

    private String printTeste(No atual,String texto){

        if(atual.temEsquerda()) texto += printTeste(atual.filhoEsquerdo,texto);

        texto += atual.elemento + " ";

        if(atual.temDireita()) texto += printTeste(atual.filhoDireito,texto);

        return texto;

    }
}
