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
        
        // Criar usuarios
        Funcionario funcionario1 = new Funcionario(1, "Carlos Silva", rh);
        Funcionario funcionario2 = new Funcionario(2, "Ana Pereira", financeiro);
        Administrador administrador = new Administrador(3, "Jose Souza");

        // Adicionar usuarios a lista
        adicionarUsuario(funcionario1);
        adicionarUsuario(funcionario2);
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
