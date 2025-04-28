import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private ArrayList<Item> itens;
    private Usuario solicitante;
    private Date dataSolicitacao;
    private Date dataConclusao;
    private StatusPedido status;
    private double valorTotal;
    private Departamento departamentoSolicitante;

    // Construtor
    public Pedido(Usuario solicitante, Departamento departamentoSolicitante) {
        this.itens = new ArrayList<>();
        this.solicitante = solicitante;
        this.dataSolicitacao = new Date(); // Data atual como padrão
        this.departamentoSolicitante = departamentoSolicitante;
        this.status = StatusPedido.PENDENTE; // Valor padrão
        this.valorTotal = 0.0;
    }

    // Métodos para adicionar e remover itens
    public void adicionarItem(Item item) {
        this.itens.add(item);
        this.valorTotal += item.getValor();
    }

    public void removerItem(Item item) {
        if (this.itens.remove(item)) {
            this.valorTotal -= item.getValor();
        }
    }

    // Getters e Setters
    public ArrayList<Item> getItens() {
        return itens;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Departamento getDepartamentoSolicitante() {
        return departamentoSolicitante;
    }

    public void setDepartamentoSolicitante(Departamento departamentoSolicitante) {
        this.departamentoSolicitante = departamentoSolicitante;
    }

    // Enum para StatusPedido (assumindo que seja um enum)
    public enum StatusPedido {
        PENDENTE,
        EM_ANDAMENTO,
        CONCLUIDO,
        CANCELADO
    }
}
