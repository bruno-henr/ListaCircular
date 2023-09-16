public class ListaCircular<T> {
    private No<T> cabeca;
    private No<T> calda;
    private int tamanhoLista;

    public int size() {
        return tamanhoLista;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0;
    }

    public No<T> getNo(int index) {
        if(this.isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vazia");
        }
        if(index == 0) {
            return this.calda;
        }

        No<T> aux = this.calda;
        for(int i = 0; (i < index) && (aux != null); i++) {
            aux = aux.getNoProximo();
        }
        return aux;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void remove(int index) {
        if(index >= tamanhoLista) {
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista");
        } else {
            No<T> aux = this.calda;
            if(index == 0) {
                this.calda = this.calda.getNoProximo();
                this.cabeca.setNoProximo(this.calda);
            }else if(index == 1){
                this.calda.setNoProximo(this.calda.getNoProximo().getNoProximo());
            } else {
                for (int i =0;i<index-1; i++) {
                    aux = aux.getNoProximo();
                }
                aux.setNoProximo(aux.getNoProximo().getNoProximo());
            }
            this.tamanhoLista--;
        }
    }
}
