package Interface;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * Created by jay on 2/24/15.
 * Tested by wjr on 4/10/15
 */
public class DBConnection implements Driver{

    public DBConnection() {
        Connection conn = null;

        try {
            String userName = "root";
            String password = "FGCU500";
            String url = "jdbc:mysql:127.0.0.1:3306";
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server "+e.getMessage());

        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
    
/*    public static void main(String[] args){
    	
    	DBConnection connect = new DBConnection();
    	
    }*/

	@Override
	public boolean acceptsURL(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection connect(String arg0, Properties arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String arg0, Properties arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}
}
