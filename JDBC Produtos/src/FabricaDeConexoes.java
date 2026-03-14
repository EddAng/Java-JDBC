import java.sql.*;
public class FabricaDeConexoes {

    private static FabricaDeConexoes instancia;

    public FabricaDeConexoes() {
    }

    public static FabricaDeConexoes obterInstancia() {
        if (instancia == null) {
            instancia = new FabricaDeConexoes();

        }
        return instancia;

    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja"
                    , "root"
                    , "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

}
