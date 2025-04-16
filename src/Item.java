public class Item {
    String descricao;
    double valorUnitario;
    int quantidade;

    public Item(String descricao, double valorUnitario, int quantidade) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return valorUnitario * quantidade;
    }
}
