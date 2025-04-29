import java.util.Date;

public class Pedido {
    private Funcionario funcionario;
    private Departamento departamento;
    private Date dataPedido;
    private Date dataConclusao;
    private String descricaoItem;
    private double valorUnitario;
    private int quantidade;
    private double totalItem;
    private double totalPedido;
    private String status;

    public Pedido(Funcionario funcionario, Departamento departamento, Date dataPedido, String descricaoItem, double valorUnitario, int quantidade, double totalItem) {
        this.funcionario = funcionario;
        this.departamento = departamento;
        this.dataPedido = dataPedido;
        this.descricaoItem = descricaoItem;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.totalItem = totalItem;
        this.totalPedido = totalItem; // Considerando que o pedido tem apenas um item por enquanto
        this.status = "ABERTO";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return totalPedido;
    }

    @Override
    public String toString() {
        return "Pedido [Funcionario=" + funcionario.getNome() + ", Departamento=" + departamento + ", Data Pedido=" + dataPedido + ", Status=" + status + ", Total Pedido=" + totalPedido + "]";
    }
}
