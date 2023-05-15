import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conexao c = new Conexao();
        c.geraConexao();

        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ");
        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Idade: ");
        int idade = input.nextInt();

        System.out.println("Data de nascimento no formato AAAA-MM-DD");
        String data = sc.nextLine();
        Date dataDeNascimento = Date.valueOf(data);


        Pessoa p = new Pessoa();
        p.setNome(nome);
        p.setIdade(idade);
        p.setDataDeNascimento(dataDeNascimento);

//      adicionar data atual
//        p.setDataDeNascimento(new java.sql.Date(System.currentTimeMillis()));

        pessoaDAO.adiciona(p);

        System.out.println("pessoa adicionada com sucesso.");
    }
}