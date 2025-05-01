import java.util.Date;

public class Pedido {
    private Funcionario funcionario;
    private Departamento departamento;
    private Date dataPedido;
    private Date dataConclusao;
    private String descricaoItem;
    private double valorUnitario;
    private int quantidade;
    private double totalPedido;
    private StatusPedido status;

    public Pedido(Funcionario funcionario,
                  Departamento departamento,
                  Date dataPedido,
                  String descricaoItem,
                  double valorUnitario,
                  int quantidade) {
        this.funcionario = funcionario;
        this.departamento = departamento;
        this.dataPedido = dataPedido;
        this.descricaoItem = descricaoItem;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.totalPedido = valorUnitario * quantidade;
        this.status = StatusPedido.ABERTO;
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

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public double getTotal() {
        return totalPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido [Funcionario=" + funcionario.getNome() +
               ", Departamento=" + departamento +
               ", DataPedido=" + dataPedido +
               ", Status=" + status +
               ", Total=" + totalPedido + "]";
    }
}
