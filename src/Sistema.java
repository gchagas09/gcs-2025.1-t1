import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Usuario> usuarios;
    private List<Pedido> pedidos;

    public Sistema() {
        usuarios = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void inicializar() {
        // Criar departamentos (não instanciando, mas acessando os valores do enum)
        Departamento financeiro = Departamento.FINANCEIRO;
        Departamento rh = Departamento.RECURSOS_HUMANOS;
        Departamento mkt = Departamento.MARKETING;
        Departamento vendas = Departamento.VENDAS;
        Departamento dir = Departamento.DIRETORIA;
        Departamento ti = Departamento.TI;
        Departamento op = Departamento.OPERACOES;
        
        // Criar usuarios
        Funcionario funcionario1 = new Funcionario(1, "Carlos Silva", rh);
        Funcionario funcionario2 = new Funcionario(2, "Ana Pereira", financeiro);
        Funcionario funcionario3 = new Funcionario(3, "Pedro Silva", op);
        Funcionario funcionario4 = new Funcionario(4, "Ana Santos", mkt);
        Funcionario funcionario5 = new Funcionario(5, "Carlos Sales", vendas);
        Funcionario funcionario6 = new Funcionario(6, "Joao Diniz", dir);
        Funcionario funcionario7 = new Funcionario(7, "Joao Sales", vendas);
        Funcionario funcionario8 = new Funcionario(8, "Artur Diniz", dir);
        Funcionario funcionario9 = new Funcionario(9, "Luiza Ferreira", mkt);
        Funcionario funcionario10 = new Funcionario(10, "Antonio Sasso", ti);
        Funcionario funcionario11 = new Funcionario(11, "Fabio Rossi", ti);
        Funcionario funcionario12 = new Funcionario(12, "Eduarda Monteiro", op);
        Funcionario funcionario13 = new Funcionario(13, "Felipe Junior", rh);
        Funcionario funcionario14 = new Funcionario(14, "Lucca Carli", financeiro);
        
        Administrador administrador = new Administrador(15, "Jose Souza");

        // Adicionar usuarios a lista
        adicionarUsuario(funcionario1);
        adicionarUsuario(funcionario2);
        adicionarUsuario(funcionario3);
        adicionarUsuario(funcionario4);
        adicionarUsuario(funcionario5);
        adicionarUsuario(funcionario6);
        adicionarUsuario(funcionario7);
        adicionarUsuario(funcionario8);
        adicionarUsuario(funcionario9);
        adicionarUsuario(funcionario10);
        adicionarUsuario(funcionario11);
        adicionarUsuario(funcionario12);
        adicionarUsuario(funcionario13);
        adicionarUsuario(funcionario14);

        adicionarUsuario(administrador);

        // Criar pedidos
        Pedido pedido1 = new Pedido(funcionario1, rh, new java.util.Date(), "Computador", 2000.00, 1, 2000.00);
        Pedido pedido2 = new Pedido(funcionario2, financeiro, new java.util.Date(), "Impressora", 500.00, 2, 1000.00);

        // Adicionar pedidos a lista
        adicionarPedido(pedido1);
        adicionarPedido(pedido2);
    }

    public void run() {
        // Exemplo de exibição dos usuários cadastrados
        System.out.println("Usuarios cadastrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome());
        }

        // Exemplo de exibição dos pedidos cadastrados
        System.out.println("\nPedidos cadastrados:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }
}
