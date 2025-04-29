package enums;
public enum Departamento {
    RECURSOS_HUMANOS(1000), 
    FINANCEIRO(1000),
    MARKETING(1000),
    VENDAS(1000),
    DIRETORIA(1000),
    TI(1000),
    OPERACOES(1000);
    
    private double limitePedido;

    private Departamento(double limitePedido){
        this.limitePedido = limitePedido;
    }

    public double getLimite(){
        return this.limitePedido;
    }
    public void setLimite(double limitePedido){
        this.limitePedido = limitePedido;
    }
    
}
