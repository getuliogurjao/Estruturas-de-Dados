public class Arvore {

    private class No{

        public String elemento;
        public No filhoEsquerdo;
        public No filhoDireito;

        public No(String elemento) {
            this.elemento = elemento;
            this.filhoEsquerdo = null;
            this.filhoDireito = null;
        }

        public boolean temDireita(){
            return  filhoDireito != null;
        }

        public boolean temEsquerda(){
            return  filhoEsquerdo != null;
        }

    }

    private No raiz;
    private String indiceRemissivo;

    public Arvore(){
        this.raiz = null;
    }

    public void add(String elemento){
        if(this.raiz == null) this.raiz = new No(elemento);
        else add(elemento,this.raiz);
    }

    private void add(String elemento,No atual){

        if(elemento.compareTo(atual.elemento) < 0){

            if(atual.temEsquerda()) add(elemento,atual.filhoEsquerdo);
            else atual.filhoEsquerdo = new No(elemento);

        }
        else if(elemento.compareTo(atual.elemento) > 0){

            if(atual.temDireita()) add(elemento,atual.filhoDireito);
            else atual.filhoDireito = new No(elemento);

        }

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

    public void remove(String elemento, No atual, No pai){

        if(elemento.compareTo(atual.elemento) == 0){

            if(atual.temEsquerda() && atual.temDireita()){

                atual.elemento = menorValor(atual.filhoDireito);
                remove(atual.elemento, atual.filhoDireito, atual);

            }
            else if(atual.temEsquerda()){

                if(atual == pai.filhoEsquerdo){
                    pai.filhoEsquerdo = atual.filhoEsquerdo;
                }
                else{
                    pai.filhoDireito = atual.filhoEsquerdo;
                }

            }
            else if(atual.temDireita()){

                if(atual == pai.filhoEsquerdo){
                    pai.filhoEsquerdo = atual.filhoDireito;
                }
                else{
                    pai.filhoDireito = atual.filhoDireito;
                }

            }
            else{

                if(atual == pai.filhoEsquerdo){
                    pai.filhoEsquerdo = null;
                }
                else{
                    pai.filhoDireito = null;
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

        System.out.print(atual.elemento + " ");

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


}
