public class Funcionario extends Usuario {
    Departamento departamento;

    public Funcionario(int id, String nome, Departamento departamento) {
        super(id, nome);
        this.departamento = departamento;
    }
}
