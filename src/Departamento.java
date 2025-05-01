public enum Departamento {
    FINANCEIRO(5000),
    RH(3000),
    ENGENHARIA(10000),
    MANUTENCAO(7000),
    TI(8000);

    private double limite;

    Departamento(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }
}
