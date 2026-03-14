import java.sql.SQLOutput;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        boolean sair = false;
        int codigoProduto;
        Produto produto = new Produto();
        Scanner scan = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        while(!sair){
            System.out.println("1 - Cadastrar produto\n2 - Consultar Produto\n3 - Alterar Quantidade\n" +
                    "4 - Remover Produto\n5 - Sair");
            int opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    System.out.print("Informe o nome do produto: ");
                    String nome = scan.next();
                    System.out.print("Informe o preço do produto: ");
                    double preco = scan.nextDouble();
                    System.out.println("Informe a quantidade de estoque que o produto possui: ");
                    int qntd = scan.nextInt();

                    produto.setNome(nome);
                    produto.setPreco(preco);
                    produto.setQntd(qntd);

                    dao.cadastrarProduto(produto);
                    break;

                case 2:
                    dao.consultarProdutos();
                    break;

                case 3:
                    System.out.println("Informe o código do produto que vai ser alterado: ");
                    codigoProduto = scan.nextInt();
                    System.out.println("Informe a nova quantidade do produto: ");
                    int novaQuantidade = scan.nextInt();

                    dao.alterarEstoque(codigoProduto,novaQuantidade);
                    break;

                case 4:
                    System.out.println("Informe o código do produto que vai ser removido: ");
                    codigoProduto = scan.nextInt();

                    dao.removerProduto(codigoProduto);
                    break;

                case 5:
                    sair = true;
                    break;

            }

        }

    }

}