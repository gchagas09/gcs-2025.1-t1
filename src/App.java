import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    private Sistema sistema = new Sistema();
    private Scanner scanner = new Scanner(System.in);
    private Usuario usuarioAtual;

    public App() {
        sistema.inicializar();
    }

    public void run() {
        while (true) {
            if (!fazerLogin()) {
                System.out.println("Saindo do sistema...");
                break;
            }
            if (usuarioAtual.isAdministrador()) {
                menuAdmin();
            } else {
                menuFuncionario();
            }
        }
    }

    private boolean fazerLogin() {
        System.out.println("\n--- LOGIN ---");
        System.out.print("Digite o ID do usuario (0 sai): ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id == 0) return false;
        for (Usuario u : sistema.getUsuarios()) {
            if (u.getId() == id) {
                usuarioAtual = u;
                System.out.println("Bem-vindo, " + u.getNome());
                return true;
            }
        }
        System.out.println("Usuario nao encontrado");
        return fazerLogin();
    }

    private void menuFuncionario() {
        Funcionario f = (Funcionario) usuarioAtual;
        int op;
        do {
            System.out.println("\n--- MENU FUNCIONARIO ---");
            System.out.println("1. Registrar novo pedido");
            System.out.println("2. Excluir pedido aberto");
            System.out.println("3. Trocar usuario");
            System.out.println("4. Sair");
            System.out.print("Opcao: ");
            op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1: registrarPedido(f); break;
                case 2: excluirPedido(f); break;
                case 3: return;
                case 4: System.exit(0);
                default: System.out.println("Opcao invalida");
            }
        } while (true);
    }

    private void registrarPedido(Funcionario f) {
        System.out.print("Descricao do item: ");
        String desc = scanner.nextLine();
        System.out.print("Valor unitario: ");
        double v = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int q = scanner.nextInt();
        scanner.nextLine();
        double total = v * q;
        if (total <= f.getDepartamento().getLimite()) {
            Pedido p = new Pedido(f, f.getDepartamento(), new Date(), desc, v, q);
            sistema.adicionarPedido(p);
            System.out.println("Pedido criado: " + p);
        } else {
            System.out.println("Excede limite de R$ " + f.getDepartamento().getLimite());
        }
    }

    private void excluirPedido(Funcionario f) {
        System.out.print("ID do pedido a excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        List<Pedido> abertos = new ArrayList<>();
        for (Pedido p : sistema.getPedidos()) {
            if (p.getStatus() == StatusPedido.ABERTO && p.getFuncionario().getId() == f.getId()) {
                abertos.add(p);
            }
        }
        for (Pedido p : abertos) {
            if (p.hashCode() == id) {
                sistema.getPedidos().remove(p);
                System.out.println("Pedido excluido");
                return;
            }
        }
        System.out.println("Pedido nao encontrado ou nao eh seu");
    }

    private void menuAdmin() {
        int op;
        do {
            System.out.println("\n--- MENU ADMINISTRADOR ---");
            System.out.println("1. Listar pedidos entre datas");
            System.out.println("2. Buscar pedidos por funcionario");
            System.out.println("3. Buscar pedidos por descricao de item");
            System.out.println("4. Visualizar e avaliar pedido");
            System.out.println("5. Estatisticas gerais");
            System.out.println("6. Trocar usuario");
            System.out.println("7. Sair");
            System.out.print("Opcao: ");
            op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1: listarEntreDatas(); break;
                case 2: buscarPorFuncionario(); break;
                case 3: buscarPorDescricao(); break;
                case 4: visualizarEAvaliar(); break;
                case 5: estatisticas(); break;
                case 6: return;
                case 7: System.exit(0);
                default: System.out.println("Opcao invalida");
            }
        } while (true);
    }

    private void listarEntreDatas() {
        System.out.print("Data inicio (yyyy-MM-dd): ");
        Date ini = java.sql.Date.valueOf(scanner.nextLine());
        System.out.print("Data fim    (yyyy-MM-dd): ");
        Date fim = java.sql.Date.valueOf(scanner.nextLine());
        for (Pedido p : sistema.listarPedidosEntreDatas(ini, fim)) {
            System.out.println(p);
        }
    }

    private void buscarPorFuncionario() {
        System.out.print("Nome do funcionario: ");
        String nome = scanner.nextLine();
        for (Pedido p : sistema.buscarPorFuncionario(nome)) {
            System.out.println(p);
        }
    }

    private void buscarPorDescricao() {
        System.out.print("Texto na descricao do item: ");
        String txt = scanner.nextLine();
        for (Pedido p : sistema.buscarPorDescricao(txt)) {
            System.out.println(p);
        }
    }

    private void visualizarEAvaliar() {
        List<Pedido> abertos = new ArrayList<>();
        for (Pedido p : sistema.getPedidos()) {
            if (p.getStatus() == StatusPedido.ABERTO) {
                abertos.add(p);
            }
        }
        if (abertos.isEmpty()) {
            System.out.println("Nao ha pedidos abertos");
            return;
        }
        for (int i = 0; i < abertos.size(); i++) {
            System.out.printf("%d. %s%n", i+1, abertos.get(i));
        }
        System.out.print("Escolha numero: ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        if (idx < 1 || idx > abertos.size()) {
            System.out.println("Pedido invalido");
            return;
        }
        Pedido p = abertos.get(idx - 1);
        System.out.println("Detalhes: " + p);
        System.out.print("1-Aprovar  2-Reprovar  0-Cancelar: ");
        int op = scanner.nextInt();
        scanner.nextLine();
        if (op == 1) {
            p.setStatus(StatusPedido.APROVADO);
            p.setDataConclusao(new Date());
            System.out.println("Aprovado");
        } else if (op == 2) {
            p.setStatus(StatusPedido.REPROVADO);
            p.setDataConclusao(new Date());
            System.out.println("Reprovado");
        }
    }

    private void estatisticas() {
        List<Pedido> todos = sistema.getPedidos();
        long total = todos.size();
        long apro = todos.stream().filter(p -> p.getStatus() == StatusPedido.APROVADO).count();
        long repro = todos.stream().filter(p -> p.getStatus() == StatusPedido.REPROVADO).count();
        System.out.printf("Total: %d  Aprovados: %d (%.1f%%)  Reprovados: %d (%.1f%%)%n",
            total, apro, total>0?100.0*apro/total:0, repro, total>0?100.0*repro/total:0);

        Date hoje = new Date();
        long ms30 = 30L * 24 * 60 * 60 * 1000;
        List<Pedido> ult30 = new ArrayList<>();
        for (Pedido p : todos) {
            if (hoje.getTime() - p.getDataPedido().getTime() <= ms30) {
                ult30.add(p);
            }
        }
        double media = ult30.stream().mapToDouble(Pedido::getTotal).average().orElse(0);
        System.out.printf("Ultimos 30 dias: %d pedidos, valor medio R$ %.2f%n",
            ult30.size(), media);

        Pedido maior = todos.stream()
            .filter(p -> p.getStatus() == StatusPedido.ABERTO)
            .max((a,b) -> Double.compare(a.getTotal(), b.getTotal()))
            .orElse(null);
        if (maior != null) {
            System.out.println("Maior pedido aberto: " + maior);
        } else {
            System.out.println("Nao ha pedidos abertos");
        }
    }
}
