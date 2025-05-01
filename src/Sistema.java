import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sistema {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void adicionarPedido(Pedido p) {
        pedidos.add(p);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void inicializar() {

        adicionarUsuario(new Funcionario(2, "Ana Pereira", Departamento.FINANCEIRO));
        adicionarUsuario(new Funcionario(3, "Pedro Silva", Departamento.MANUTENCAO));
        adicionarUsuario(new Funcionario(4, "Ana Santos", Departamento.ENGENHARIA));
        adicionarUsuario(new Funcionario(5, "Carlos Sales", Departamento.TI));
        adicionarUsuario(new Funcionario(6, "Joao Diniz", Departamento.RH));
        adicionarUsuario(new Funcionario(7, "Luiza Ferreira", Departamento.FINANCEIRO));
        adicionarUsuario(new Funcionario(8, "Antonio Sasso", Departamento.ENGENHARIA));
        adicionarUsuario(new Funcionario(9, "Fabio Rossi", Departamento.TI));
        adicionarUsuario(new Funcionario(10, "Eduarda Monteiro", Departamento.MANUTENCAO));
        adicionarUsuario(new Funcionario(11, "Felipe Junior", Departamento.RH));
        adicionarUsuario(new Funcionario(12, "Lucca Carli", Departamento.FINANCEIRO));
        adicionarUsuario(new Funcionario(13, "Mariana Rocha", Departamento.ENGENHARIA));
        adicionarUsuario(new Funcionario(14, "Beatriz Costa", Departamento.MANUTENCAO));
        adicionarUsuario(new Funcionario(15, "Rafael Lima", Departamento.TI));
        adicionarUsuario(new Administrador(1, "Jose Souza"));

        Pedido p1 = new Pedido(
            (Funcionario) usuarios.get(0),
            ((Funcionario) usuarios.get(0)).getDepartamento(),
            new Date(),
            "Computador",
            2000.00,
            1
        );
        Pedido p2 = new Pedido(
            (Funcionario) usuarios.get(1),
            ((Funcionario) usuarios.get(1)).getDepartamento(),
            new Date(),
            "Impressora",
            500.00,
            2
        );
        adicionarPedido(p1);
        adicionarPedido(p2);
    }

    public List<Pedido> listarPedidosEntreDatas(Date inicio, Date fim) {
        List<Pedido> res = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (!p.getDataPedido().before(inicio) && !p.getDataPedido().after(fim)) {
                res.add(p);
            }
        }
        return res;
    }

    public List<Pedido> buscarPorFuncionario(String nomeParte) {
        List<Pedido> res = new ArrayList<>();
        String n = nomeParte.toLowerCase();
        for (Pedido p : pedidos) {
            if (p.getFuncionario().getNome().toLowerCase().contains(n)) {
                res.add(p);
            }
        }
        return res;
    }

    public List<Pedido> buscarPorDescricao(String parteDesc) {
        List<Pedido> res = new ArrayList<>();
        String d = parteDesc.toLowerCase();
        for (Pedido p : pedidos) {
            if (p.getDescricaoItem().toLowerCase().contains(d)) {
                res.add(p);
            }
        }
        return res;
    }
}
