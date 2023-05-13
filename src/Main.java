import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conexao c = new Conexao();
        c.geraConexao();

        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner input = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = input.nextLine();

        Date dataDeNascimento = new Date(19910512);

        Pessoa p = new Pessoa();
        p.setNome(nome);
        p.setDataDeNascimento(dataDeNascimento);

        pessoaDAO.adiciona(p);

        System.out.println("pessoa adicionada com sucesso.");
    }
}