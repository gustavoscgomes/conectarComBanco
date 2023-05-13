import java.sql.*;
import java.util.ArrayList;
public class PessoaDAO {
    private Connection connection;
    public PessoaDAO() {
        this.connection = new Conexao().GeraConexao();
    }
    public void adiciona(Pessoa p) {
        String sql = "INSERT INTO pessoa(nome,idade, dataDeNascimento) VALUES(?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setDate(3, p.getDataDeNascimento());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}