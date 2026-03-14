import java.sql.SQLOutput;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        boolean sair = false;
        Produto produto = new Produto();
        Scanner scan = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        while(!sair){
            System.out.println("1 - Cadastrar produto\n2 - Consultar Produto\n3 - Sair");
            int opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    System.out.print("Informe o nome do produto: ");
                    String nome = scan.next();
                    System.out.print("Informe o preço do produto: ");
                    double preco = scan.nextDouble();
                    produto.setNome(nome);
                    produto.setPreco(preco);

                    dao.cadastrarProduto(produto);
                    break;

                case 2:
                    dao.consultarProdutos();
                    break;

                case 3:
                    sair = true;
                    break;
            }

        }

    }

}