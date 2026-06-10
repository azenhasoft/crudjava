public class Usuario {

    // Atributos que representam os dados do usuário
    private int id;
    private String nome;
    private String email;

    // Construtor usado para criar um novo usuário
    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Retorna o ID do usuário
    public int getId() {
        return id;
    }

    // Retorna o nome do usuário
    public String getNome() {
        return nome;
    }

    // Permite alterar o nome do usuário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o email do usuário
    public String getEmail() {
        return email;
    }

    // Permite alterar o email do usuário
    public void setEmail(String email) {
        this.email = email;
    }

    // Define como o objeto será exibido quando for impresso
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Email: " + email;
    }
}
