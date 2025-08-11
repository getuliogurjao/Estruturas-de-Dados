public class ArvoreDeBuscaString {

    private class No{

        public String elemento;
        public No filhoEsquerdo;
        public No filhoDireito;
        private int fb;
        private int altura;

        public No(String elemento) {
            this.elemento = elemento;
            this.filhoEsquerdo = null;
            this.filhoDireito = null;
            this.fb = 0;
            this.altura = 1;
        }

        public boolean temDireita(){
            return  filhoDireito != null;
        }

        public boolean temEsquerda(){
            return  filhoEsquerdo != null;
        }

    }

    private No raiz;

    public ArvoreDeBuscaString(){
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

            }
            else{

                atual.filhoEsquerdo = new No(elemento);

            }

        }
        else if(elemento.compareTo(atual.elemento) > 0){

            if(atual.temDireita()){

                add(elemento,atual.filhoDireito,atual);
            }
            else{

                atual.filhoDireito = new No(elemento);

            }

        }

        atualizarAlturaBalanceamento(atual);

        verificarBalanceamento(atual,paiAtual);

    }

    private void atualizarAlturaBalanceamento(No atual){
        atualizarAltura(atual);
        atualizarFatorBalanceamento(atual);
    }

    private void atualizarAltura(No atual){

        if(atual.temEsquerda() && atual.temDireita()){
            if(atual.filhoEsquerdo.altura > atual.filhoDireito.altura)
                atual.altura = atual.filhoEsquerdo.altura + 1;
            else if (atual.filhoEsquerdo.altura < atual.filhoDireito.altura)
                atual.altura = atual.filhoDireito.altura + 1;
            else
                atual.altura = atual.filhoEsquerdo.altura + 1;
        }
        else if(atual.temEsquerda()) atual.altura = atual.filhoEsquerdo.altura + 1;
        else if(atual.temDireita()) atual.altura = atual.filhoDireito.altura + 1;
        else atual.altura = 1;

    }

    private void atualizarFatorBalanceamento(No atual){

        if(atual.temEsquerda() && atual.temDireita()) atual.fb = atual.filhoEsquerdo.altura - atual.filhoDireito.altura;
        else if(atual.temEsquerda()) atual.fb = atual.filhoEsquerdo.altura;
        else if (atual.temDireita()) atual.fb = -atual.filhoDireito.altura;
        else atual.fb = 0;

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

        atualizarAlturaBalanceamento(raizDesbalanceada);
        atualizarAlturaBalanceamento(filhoDireitoRaizDesbalanceada);

        return filhoDireitoRaizDesbalanceada;

    }

    private No rotacaoDireita(No raizDesbalanceada){

        No filhoEsquerdoRaizDesbalanceada = raizDesbalanceada.filhoEsquerdo;

        raizDesbalanceada.filhoEsquerdo = filhoEsquerdoRaizDesbalanceada.filhoDireito;
        filhoEsquerdoRaizDesbalanceada.filhoDireito = raizDesbalanceada;

        atualizarAlturaBalanceamento(raizDesbalanceada);
        atualizarAlturaBalanceamento(filhoEsquerdoRaizDesbalanceada);

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

        atualizarAlturaBalanceamento(atual);

        verificarBalanceamento(atual,paiAtual);

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

    public String printPreOrder(){

        String saida = "";

        if(this.raiz != null){
            saida = printPreOrder(this.raiz,saida);
        }

        return saida.substring(0,saida.length()-1);

    }

    private String printPreOrder(No atual, String saida){

        saida += atual.elemento + " ";

        if(atual.temEsquerda()) saida = printPreOrder(atual.filhoEsquerdo,saida);

        if(atual.temDireita()) saida = printPreOrder(atual.filhoDireito,saida);

        return saida;
    }

    public String printInOrder(){

        String saida = "";

        if(this.raiz != null){
            saida = printInOrder(this.raiz,saida);
        }

        return saida;

    }

    private String printInOrder(No atual,String saida){

        if(atual.temEsquerda()) saida = printInOrder(atual.filhoEsquerdo,saida);

        saida += atual.elemento + " ";

        if(atual.temDireita()) saida = printInOrder(atual.filhoDireito,saida);

        return saida;

    }

    public String printPosOrder(){

        String saida = "";

        if(this.raiz != null){
            saida = printPosOrder(this.raiz,saida);
        }

        return saida.substring(0,saida.length()-1);

    }

    private String printPosOrder(No atual,String saida){

        if(atual.temEsquerda()) saida = printPosOrder(atual.filhoEsquerdo,saida);

        if(atual.temDireita()) saida = printPosOrder(atual.filhoDireito,saida);

        saida += atual.elemento + " ";

        return saida;

    }
}
