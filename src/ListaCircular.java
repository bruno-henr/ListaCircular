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
}
