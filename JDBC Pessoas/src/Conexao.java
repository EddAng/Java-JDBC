import java.sql.*;

public class Conexao{

    public Conexao(){

    }
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pessoa"
            ,"root"
            ,"root");
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }
}