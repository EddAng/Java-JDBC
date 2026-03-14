import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO{

    public void cadastrarProduto(Produto produto){
        FabricaDeConexoes fc = FabricaDeConexoes.obterInstancia();
        try(Connection conn = fc.getConnection()){
            String sql = """
                    Insert into produto(nomeProduto,precoProduto) values(?,?)
                    """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,produto.getNome());
            stmt.setDouble(2,produto.getPreco());
            stmt.execute();

        }catch(SQLException e){
            throw new RuntimeException(e);

        }
    }

    public void consultarProdutos(){
        FabricaDeConexoes fc = FabricaDeConexoes.obterInstancia();
        try(Connection conn = fc.getConnection()){
            String sql = """
                    Select idProduto,nomeProduto,precoProduto from produto
                    """;

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println("Id - "+rs.getInt(1)+" -- Nome - "+rs.getString(2)+
                        " -- Preço - "+rs.getDouble(3));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

}
