import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoDAO{

    public void cadastrarProduto(Produto produto){
        FabricaDeConexoes fc = FabricaDeConexoes.obterInstancia();
        LocalDate dataHoje = LocalDate.now();

        try(Connection conn = fc.getConnection()){
            String sql = """
                    Insert into produto(nomeProduto,precoProduto,estoqueProduto,dataLancamento) values(?,?,?,?)
                    """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,produto.getNome());
            stmt.setDouble(2,produto.getPreco());
            stmt.setInt(3,produto.getQntd());
            stmt.setObject(4,dataHoje);
            stmt.execute();

        }catch(SQLException e){
            throw new RuntimeException(e);

        }
    }

    public void consultarProdutos(){
        FabricaDeConexoes fc = FabricaDeConexoes.obterInstancia();
        try(Connection conn = fc.getConnection()){
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String sql = """
                    Select idProduto,nomeProduto,precoProduto,estoqueProduto,dataLancamento from produto
                    """;

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println("Id - "+rs.getInt(1)+" -- Nome - "+rs.getString(2)+
                        " -- Preço - "+rs.getDouble(3)+" -- Estoque - "+
                        rs.getInt(4)+" -- Data de Lançamento - "+rs.getObject(5, LocalDate.class).format(formatoData));

            }

        }catch (SQLException e){
            throw new RuntimeException(e);

        }

    }

}
