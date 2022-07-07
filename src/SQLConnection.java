
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLConnection {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String db = "BloodDonationDATABASE";
	private String localhost = "jdbc:mysql://127.0.0.1:3306/" + db;
	private String username = "root";
	private String password = "1190120DB2022";
	private Connection conn = null;

	private static SQLConnection classObj = null;

	private SQLConnection() {
	}

	public static SQLConnection createSQLCursor() {
		if (classObj == null)
			classObj = new SQLConnection();
		return classObj;
	}

	private void establishConnection() {
		try {
			if (this.conn == null) {
				Class.forName(this.driver);
				this.conn = DriverManager.getConnection(this.localhost, this.username, this.password);
			}
		} catch (Exception e) {
			System.out.println("-E- An issue happens while establishing connection: " + e);
			this.conn = null;
		}
	}

	public void closeConnection() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				System.out.println("-E- An issue happens while closing connection: " + e);
				this.conn = null;
			}
		}
	}

	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		this.establishConnection();
		if (this.conn != null) {
			try {
				Statement stmt = this.conn.createStatement();
				rs = stmt.executeQuery(query);
			} catch (Exception e) {
				System.out.println("-E- An issue happens while executing query \'" + query + "\': " + e);
				rs = null;
			}
		}
		return rs;
	}
}
