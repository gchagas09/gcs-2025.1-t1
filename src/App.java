import java.util.Scanner;

public class App {
    private Sistema sistema;
    private Scanner scanner;

    public App() {
        sistema = new Sistema();
        scanner = new Scanner(System.in);
        sistema.inicializar();  // Inicializa com dados pré-cadastrados
    }

    public void run() {
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar Pedido");
            System.out.println("2. Listar Usuarios");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Opcoes para o administrador");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarPedido();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    FuncaoAdministrador();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 5);
    }

    private void adicionarPedido() {
        // Exemplo de como adicionar um pedido
        System.out.println("Adicionando novo pedido:");

        // Escolher um funcionário (usando o ID)
        System.out.print("Digite o ID do funcionario: ");
        int funcionarioId = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        Funcionario funcionario = null;
        for (Usuario usuario : sistema.getUsuarios()) {
            if (usuario instanceof Funcionario && usuario.getId() == funcionarioId) {
                funcionario = (Funcionario) usuario;
                break;
            }
        }

        if (funcionario == null) {
            System.out.println("Funcionario nao encontrado.");
            return;
        }

        // Digitar o departamento (com base no funcionario)
        Departamento departamento = funcionario.getDepartamento();

        // Digitar dados do pedido
        System.out.print("Digite a descricao do item: ");
        String descricaoItem = scanner.nextLine();
        System.out.print("Digite o valor unitario do item: ");
        double valorUnitario = scanner.nextDouble();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        // Calcular o total do item
        double totalItem = valorUnitario * quantidade;

        // Criar o pedido
        Pedido pedido = new Pedido(funcionario, departamento, new java.util.Date(), descricaoItem, valorUnitario, quantidade, totalItem);

        // Verificar se o pedido está dentro do limite do departamento
        if (pedido.getTotal() <= departamento.getLimite()) {
            sistema.adicionarPedido(pedido);
            System.out.println("Pedido adicionado com sucesso!");
        } else {
            System.out.println("Valor do pedido excede o limite do departamento!");
        }
    }

    private void listarUsuarios() {
        System.out.println("\nUsuarios cadastrados:");
        for (Usuario usuario : sistema.getUsuarios()) {
            System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome());
        }
    }

    private void listarPedidos() {
        System.out.println("\nPedidos cadastrados:");
        for (Pedido pedido : sistema.getPedidos()) {
            System.out.println(pedido);
        }
    }
    
    private void FuncaoAdministrador(){
        System.out.println("---MENU ADM---");
        System.out.println("1. Avaliar pedidos.");
        System.out.println("2. Listar pedidos por data.");
        System.out.println("3. Buscar pedidos por funcionario.");
        System.out.println("4. Buscar pedidos pela descrição.");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opcao: ");
        int valor = scanner.nextInt();
        scanner.nextLine();

        switch (valor) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.out.println("saindo...");
                break;
            default:
                System.out.println("Opcao Invalida!");
        }
    }
}
