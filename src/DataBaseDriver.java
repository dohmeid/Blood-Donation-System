import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataBaseDriver {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/BloodDonation";
	private static final String username = "root";
	private static final String password = "1190120DB2022";
	private static Connection con;
	private static Statement st;
	static int count_rows = 0;

	public static void main(String[] args) throws Exception {
		

		InitializeDB();
		Donor d1 = new Donor(3, "sara", 11231, "nablus", "1/1/2001", "m", "O+", 12, "yes");
		Donor d2 = new Donor(2, "karam", 11231, "nablus", "1/1/2001", "m", "O+", 12, "yes");
		Donor d3 = new Donor(6, "kam", 11231, "ram", "1/3/2001", "m", "O+", 12, "yes");
		Donor d4 = new Donor(5, "taeen", 11231, "nablus", "1/1/2001", "m", "A+", 12, "yes");
		//addDonor(d1);
		//addDonor(d2);
		//addDonor(d3);
		//addDonor(d4);
		
		Receiver r1 = new Receiver(1, "hiba", 11231, "nablus", "1/1/2001", "m", "O+");
		//addReceiver(r1);
		Donation don = new Donation(7, 3,"1/8/2021", "O+", 5,"ramallah",  "shadi");
		Donation don2 = new Donation(3, 2,"1/4/2021", "B-", 5,"ramallah",  "shadi");
		Donation don3 = new Donation(4, 6,"1/8/2021", "AB+", 5,"ramallah",  "shadi");
		Donation don4 = new Donation(2, 5,"1/8/2021", "AB+", 2,"ramallah",  "shadi");
		Donation don5 = new Donation(28, 5,"8/8/2021", "B+", 2,"ramallah",  "shadi");
		//addDonation(don);
		//addDonation(don2);
	//	addDonation(don5);
		//System.out.println(search(1,3));
		Receiving rec =  new Receiving(33,1,"1/1/2001","O+",3,"ramallah",  "shadi");
		//addBloodReceiving(rec);
		
		// delete(1, 2);//delete karam
		// delete(2, 1);//delete hiba
		//listTable(4);
		/*
		 * ArrayList<String> col = new ArrayList<String>(); col.add("rname");
		 * col.add("PhoneNumber"); col.add("DateofBirth"); ArrayList<String> val = new
		 * ArrayList<String>(); val.add("amr"); val.add("8888"); val.add("2021-06-06");
		 * update(2, 1, col, val); System.out.println("ggggggggggggggg"); listTable(2);
		 */

		//String query= "select dname from Donor where dssn=6";
		/*
		 * System.out.println("query trys"); ArrayList<String> a = new
		 * ArrayList<String>(); //a = q1("O+"); //a= q3("2021-08-01"); //a =
		 * q11("2001-01-01","2021-08-09"); //a = q8();
		 * System.out.println("------------------"); System.out.println(a.toString());
		 * //q11("2021-05-01", "2021-08-02"); // update(2,1,col,val); // listTable(2);
		 */
	}

	public DataBaseDriver() {
		InitializeDB();
		count_rows = 0;
	}

	public static void InitializeDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			System.out.println("Connection is done");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int search(int id, int flag) throws SQLException{
		//return 1 if id exists, otherwise returns 0
	    String sql="";
	    if (flag == 1){// search for donor
	       sql = "select * from donor d where d.dssn ="+id+";";

	    }else if (flag ==2){// search for BloodReceiver
	        sql = "select * from BloodReceiver Br where Br.rssn ="+id+";";
	    }else if (flag == 3){// search for donation
	        sql = "select * from donation do where do.id ="+id+";";
	    }else if(flag == 4){// search for BloodReceiving
	        sql = "select * from BloodReceiving B where B.id ="+id+";";
	    }
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sql);
	    if (rs.next()){
	        return 1;
	    }else
	    return 0;
	}
	
	
	public static void addDonor(Donor bloodDonor) throws SQLException, ParseException {

		if (bloodDonor.getDssn() == 0 || bloodDonor.getDname() == "" || bloodDonor.getPhoneNumber() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"insert into Donor (dssn, dname, phoneNumber,address, dateOfBirth, gender, bloodType,bloodHgb,eligibleToDonate) value (?, ?, ?, ?, ?, ?,?,?,?);");

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date birthDate = formatter.parse(bloodDonor.getDateOfBirth());
		java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());

		ps.setInt(1, bloodDonor.getDssn());
		ps.setString(2, bloodDonor.getDname());
		ps.setInt(3, bloodDonor.getPhoneNumber());
		ps.setString(4, bloodDonor.getAddress());
		ps.setDate(5, sqlBirthDate);
		ps.setString(6, bloodDonor.getGender());
		ps.setString(7, bloodDonor.getBloodType());
		ps.setInt(8, bloodDonor.getBloodHgb());
		ps.setString(9, bloodDonor.getEligableToDonate());
		ps.executeUpdate();

	}

	public static void addReceiver(Receiver bloodReceiver) throws SQLException, ParseException {

		if (bloodReceiver.getRssn() == 0 || bloodReceiver.getRname() == "" || bloodReceiver.getPhoneNumber() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"insert into BloodReceiver (rssn, rname, phoneNumber,address, dateOfBirth, gender, bloodType) value (?, ?, ?, ?, ?, ?,?);");

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date birthDate = formatter.parse(bloodReceiver.getDateOfBirth());
		java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());

		ps.setInt(1, bloodReceiver.getRssn());
		ps.setString(2, bloodReceiver.getRname());
		ps.setInt(3, bloodReceiver.getPhoneNumber());
		ps.setString(4, bloodReceiver.getAddress());
		ps.setDate(5, sqlBirthDate);
		ps.setString(6, bloodReceiver.getGender());
		ps.setString(7, bloodReceiver.getBloodType());
		ps.executeUpdate();
	}

	public static void delete(int flag, int key) throws SQLException {
		// flag to choose the table
		// key delete condition
		String sql = "";
		if (flag == 1) {
			sql = "DELETE FROM donor WHERE dssn = ? ";
		} else if (flag == 2) {
			sql = "DELETE FROM BloodReceiver WHERE rssn = ? ";
		} else if (flag == 3) {
			sql = "DELETE FROM Donation WHERE ID = ? ";
		} else if (flag == 4) {
			sql = "DELETE FROM BloodReceiving WHERE ID = ? ";
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, key);
		ps.executeUpdate();

	}

	public static void update(int flag, int key, ArrayList columns, ArrayList updatedValues)
			throws SQLException, ParseException {

		// flag to choose the table
		// key update condition
		// columns represents the fields to be updated
		// columns must have the same name as in the database tables
		String query = "";
		String sql = "";
		for (int i = 0; i < columns.size(); i++) {
			if (i == columns.size() - 1) {
				query += "" + columns.get(i) + "='" + updatedValues.get(i) + "'";
			} else
				query += "" + columns.get(i) + "='" + updatedValues.get(i) + "',";
		}

		if (flag == 1) {
			sql = "UPDATE donor SET " + query + " WHERE dssn = ? ;";
		} else if (flag == 2) {
			sql = "UPDATE BloodReceiver SET " + query + " WHERE rssn = ? ;";
		} else if (flag == 3) {
			sql = "UPDATE Donation SET " + query + " WHERE ID = ? ;";
		} else if (flag == 4) {
			sql = "UPDATE BloodReceiving SET " + query + " WHERE ID = ? ;";
		}

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, key);
		ps.executeUpdate();

	}

	public static ArrayList<String> listTable(int flag) throws SQLException {
		ArrayList<String> data = new ArrayList<String>();
		String sql = "";
		if (flag == 1) { // flag =1 ==> list all donors
			sql = "select * from donor";
		} else if (flag == 2) { // flag =2 ==> list all receivers
			sql = "select * from BloodReceiver";
		} else if (flag == 3) { // flag =3 ==> list all donation processes
			sql = "select * from Donation";
		} else if (flag == 4) { // flag =4 ==> list all receiving processes
			sql = "select * from BloodReceiving";
		}
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			count_rows++;
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				data.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return data;
	}

	public static void addDonation(Donation donationProcess) throws SQLException, ParseException {

		if (donationProcess.getBloodSampleId() == 0 || donationProcess.getDssn() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"insert into Donation (ID, dSSN, DateofDonation,BloodType, BloodTypeQuantity, Hospital , Doctor) value (?, ?, ?, ?, ?, ?,?);");

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date donationDate = formatter.parse(donationProcess.getDateOfDonation());
		java.sql.Date sqldonationDate = new java.sql.Date(donationDate.getTime());

		ps.setInt(1, donationProcess.getBloodSampleId());
		ps.setInt(2, donationProcess.getDssn());
		ps.setDate(3, sqldonationDate);
		ps.setString(4, donationProcess.getBloodType());
		ps.setInt(5, donationProcess.getBloodUnits());
		ps.setString(6, donationProcess.getHospital());
		ps.setString(7, donationProcess.getDoctor());

		ps.executeUpdate();
	}

	public static void addBloodReceiving(Receiving receivingProcess) throws SQLException, ParseException {

		if (receivingProcess.getBloodSampleId() == 0 || receivingProcess.getRssn() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"insert into BloodReceiving (ID, rSSN, DateofReceiving,BloodType, BloodTypeQuantity, Hospital , Doctor) value (?, ?, ?, ?, ?, ?,?);");

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date receivingDate = formatter.parse(receivingProcess.getDateOfReceiving());
		java.sql.Date sqlreceivingDate = new java.sql.Date(receivingDate.getTime());

		ps.setInt(1, receivingProcess.getBloodSampleId());
		ps.setInt(2, receivingProcess.getRssn());
		ps.setDate(3, sqlreceivingDate);
		ps.setString(4, receivingProcess.getBloodType());
		ps.setInt(5, receivingProcess.getBloodUnits());
		ps.setString(6, receivingProcess.getHospital());
		ps.setString(7, receivingProcess.getDoctor());

		ps.executeUpdate();
	}

	// queries
	public static ArrayList<String> q1(String bloodType) throws SQLException {// to show all donor's names that donated a specific
																	// blood type.
		ArrayList<String> names = new ArrayList<String>();
		String sql = "";
		sql = "select distinct D.dname from Donor D, Donation Do where D.dssn = Do.dssn and Do.BloodType = '"
				+ bloodType + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static ArrayList<String> q2() throws SQLException {// to show blood stock of each blood type.
		ArrayList<String> s = new ArrayList<String>();
		String sql = "";
		sql = "select d.bloodtype, sum(d.bloodtypequantity) from Donation d group by d.bloodtype ;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				s.add(rs.getString(i));

			}
			System.out.println();// Move to the next line to print the next row.
		}
		return s;
	}

	public static ArrayList<String> q3(String date) throws SQLException {// to show all donors name that donated in a specific date.
		
		ArrayList<String> names = new ArrayList<String>();
		String sql = "";
		sql = "select distinct D.dname from donor D, donation Do where D.dssn = Do.dssn and Do.dateofdonation = '"
				+ date + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static ArrayList<String> q4() throws SQLException {// to show all donors for each blood group
		
		ArrayList<String> names = new ArrayList<String>();
		String sql = "";
		sql = "select distinct don.bloodtype,D.dname from Donor D, Donation don where D.dssn = don.dssn order by don.bloodtype;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static ArrayList<String> q5(String startDate, String endDate) throws SQLException {// to show all donors that donated in a
		ArrayList<String> names = new ArrayList<String>();
		// specific period of time
		String sql = "";
		sql = "SELECT  distinct D.dname from donor D join donation Don where D.dssn = Don.dssn and Don.DateofDonation BETWEEN '"
				+ startDate + "' AND '" + endDate + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static ArrayList<String> q6(String startDate, String endDate) throws SQLException {// to show highest bloodstock in a
		ArrayList<String> names = new ArrayList<String>();																		// certain period of time
		String sql = "";
		sql = "select max(sum),bloodtype from  (select sum(d.bloodtypequantity) as sum ,d.bloodtype  from donation d where d.DateofDonation BETWEEN '"
				+ startDate + "'and'" + endDate + "' group by d.bloodtype  order by sum desc)a ;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static ArrayList<String> q7(String bloodType, String startDate, String endDate) throws SQLException {// to show all blood
																									// receivers that received a specific blood type in a specific period of time
		ArrayList<String> names = new ArrayList<String>();	
		String sql = "";
		sql = "SELECT  distinct R.rname from BloodReceiver R join BloodReceiving BR where R.rssn = BR.rssn and BR.Dateofreceiving BETWEEN '"
				+ startDate + "' AND '" + endDate + "'and BR.bloodType='" + bloodType + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static ArrayList<String> q8() throws SQLException {// to show all receivers for each blood group
		ArrayList<String> names = new ArrayList<String>();	
		String sql = "";
		sql = "select  distinct BR.bloodtype,R.rname from bloodReceiver R, bloodReceiving BR where R.rssn = BR.rssn order by BR.bloodtype;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static ArrayList<String>  q9(String startDate, String endDate) throws SQLException {// to show highest bloodtype received
																					// in a certain period of time
		ArrayList<String> names = new ArrayList<String>();	
		String sql = "";
		sql = "select max(sum),bloodtype from  (select sum(b.bloodtypequantity) as sum ,b.bloodtype  from BloodReceiving b where b.DateofReceiving BETWEEN '"
				+ startDate + "'and'" + endDate + "' group by b.bloodtype  order by sum desc)a ;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static  ArrayList<String>  q10(String startDate, String endDate) throws SQLException {// to show average blood donation rate
																					// in a specific period of time
		ArrayList<String> names = new ArrayList<String>();	
		String sql = "";
		sql = "SELECT AVG(d.BloodTypeQuantity) AS AverageDonationRate FROM Donation d where d.DateofDonation BETWEEN '"
				+ startDate + "'and'" + endDate + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

	public static  ArrayList<String>  q11(String startDate, String endDate) throws SQLException {// to show average demand on each
																					// blood group in certain amount of time
		ArrayList<String> names = new ArrayList<String>();	
		String sql = "";
		sql = "SELECT AVG(b.BloodTypeQuantity) AS AverageDemandRate,BloodType FROM BloodReceiving b where b.DateofReceiving BETWEEN '"
				+ startDate + "'and'" + endDate + "'group by BloodType;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {// Print one row
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + " | "); // Print one element of a row
				names.add(rs.getString(i));
			}
			System.out.println();// Move to the next line to print the next row.
		}
		return names;
	}

}
