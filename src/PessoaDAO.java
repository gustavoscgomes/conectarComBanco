import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

    private Connection connection;
    public PessoaDAO() {
        this.connection = new Conexao().geraConexao();
    }
    public void adiciona(Pessoa p) {
        String sql = "INSERT INTO pessoa(nome,idade, data_de_nascimento) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setDate(3, new Date(p.getDataDeNascimento().getTime()));

//          adicionar data atual
//            stmt.setDate(3, new java.sql.Date(p.getDataDeNascimento().getTime()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
