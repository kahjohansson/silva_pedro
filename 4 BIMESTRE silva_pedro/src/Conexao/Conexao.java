
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static Connection conexao;

    public static Connection get() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/silva", "root", "");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
}
