import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Conexao conn = new Conexao();
        System.out.print("Informe o nome do aluno: ");
        String nome = scan.nextLine();
        System.out.print("\nInforme a idade do aluno: ");
        int idade = scan.nextInt();
        System.out.print("\nInforme a matricula do aluno: ");
        int matricula = scan.nextInt();
        Aluno al = new Aluno(nome, idade, matricula);

        try {
            String sql = """
                    insert into Aluno(nomeAluno,idade,matricula)
                    values(?,?,?)
                    """;
            PreparedStatement stat = conn.getConnection().prepareStatement(sql);

            stat.setString(1, al.nome);
            stat.setInt(2, al.idade);
            stat.setInt(3, al.matricula);

            stat.execute();

            sql = """
                select idAluno, nomeAluno, idade, matricula from aluno   
            """;
            stat = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" - "+ rs.getString(2)+" - "+rs.getInt(3)+" - "+rs.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}