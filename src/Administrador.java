public class Administrador extends Usuario {
    public Administrador(int id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean isAdministrador() {
        return true;
    }
}
