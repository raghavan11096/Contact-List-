package ContactBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


public class ContactDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public ContactDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertContact(Contact contact) throws SQLException {
		String sql = "INSERT INTO mytable(first_name,middle_name,last_name,home_phone,cell_phone,home_address,home_city,home_state,home_zip,work_phone,work_address,work_city,work_state,work_zip,birth_date) VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, contact.getFirst_name());
		statement.setString(2, contact.getMiddle_name());
		statement.setString(3, contact.getLast_name());
		statement.setString(4, contact.getHome_phone());
		statement.setString(5, contact.getCell_phone());
		statement.setString(6, contact.getHome_address());
		statement.setString(7, contact.getHome_city());
		statement.setString(8, contact.getHome_state());
		statement.setInt(9, contact.getHome_zip());
		statement.setString(10, contact.getWork_phone());
		statement.setString(11, contact.getWork_address());
		statement.setString(12, contact.getWork_city());
		statement.setString(13, contact.getWork_state());
		statement.setInt(14, contact.getWork_zip());
		statement.setDate(15, contact.getBirth_date());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Contact> listAllContacts() throws SQLException {
		List<Contact> listContact = new ArrayList<>();
		
		String sql = "SELECT * FROM mytable";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int contact_id = resultSet.getInt("contact_id");
			String first_name = resultSet.getString("first_name");
			String middle_name = resultSet.getString("middle_name");
			String last_name = resultSet.getString("last_name");
			String home_phone = resultSet.getString("home_phone");
			String cell_phone = resultSet.getString("cell_phone");
			String home_address = resultSet.getString("home_address");
			String home_city = resultSet.getString("home_city");
			String home_state = resultSet.getString("home_state");
			int home_zip = resultSet.getInt("home_zip");
			String work_phone = resultSet.getString("work_phone");
			String work_address = resultSet.getString("work_address");
			String work_city = resultSet.getString("work_city");
			String work_state = resultSet.getString("work_state");
			int work_zip = resultSet.getInt("work_zip");
			Date birth_date=resultSet.getDate("birth_date");


			
			Contact contact = new Contact(contact_id,first_name, middle_name, last_name, home_phone, cell_phone, home_address, home_city,home_state,home_zip,work_phone,work_address,work_city,work_state,work_zip,birth_date);
			listContact.add(contact);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listContact;
	}
	
	public boolean deleteContact(Contact contact) throws SQLException {
		String sql = "DELETE FROM mytable where contact_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, contact.getContact_id());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateContact(Contact contact) throws SQLException {
		String sql = "UPDATE mytable SET first_name=?, middle_name=?, last_name=?, home_phone=?, cell_phone=?, home_address=?, home_city=?,home_state=?,home_zip=?,work_phone=?,work_address=?,work_city=?,work_state=?,work_zip=?,birth_date=? ";
		sql += " WHERE contact_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, contact.getFirst_name());
		statement.setString(2, contact.getMiddle_name());
		statement.setString(3, contact.getLast_name());
		statement.setString(4, contact.getHome_phone());
		statement.setString(5, contact.getCell_phone());
		statement.setString(6, contact.getHome_address());
		statement.setString(7, contact.getHome_city());
		statement.setString(8, contact.getHome_state());
		statement.setInt(9, contact.getHome_zip());
		statement.setString(10, contact.getWork_phone());
		statement.setString(11, contact.getWork_address());
		statement.setString(12, contact.getWork_city());
		statement.setString(13, contact.getWork_state());
		statement.setInt(14, contact.getWork_zip());
		statement.setDate(15, contact.getBirth_date());
		statement.setInt(16, contact.getContact_id());
		

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public Contact getContact(int contact_id) throws SQLException {
		Contact contact = null;
		String sql = "SELECT * FROM mytable WHERE contact_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, contact_id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String first_name = resultSet.getString("first_name");
			String middle_name = resultSet.getString("middle_name");
			String last_name = resultSet.getString("last_name");
			String home_phone = resultSet.getString("home_phone");
			String cell_phone = resultSet.getString("cell_phone");
			String home_address = resultSet.getString("home_address");
			String home_city = resultSet.getString("home_city");
			String home_state = resultSet.getString("home_state");
			int home_zip = resultSet.getInt("home_zip");
			String work_phone = resultSet.getString("work_phone");
			String work_address = resultSet.getString("work_address");
			String work_city = resultSet.getString("work_city");
			String work_state = resultSet.getString("work_state");
			int work_zip = resultSet.getInt("work_zip");
			Date birth_date=resultSet.getDate("birth_date");
			
			contact = new Contact(contact_id,first_name, middle_name, last_name, home_phone, cell_phone, home_address, home_city,home_state,home_zip,work_phone,work_address,work_city,work_state,work_zip,birth_date);
		}
		
		resultSet.close();
		statement.close();
		
		
		return contact;
	}
	

	
	public List<Contact> searchContact(String search_contact) throws SQLException {
		List<Contact> searchContact = new ArrayList<>();
		
		String sql = "SELECT * FROM mytable WHERE first_name like '%"+search_contact+"%' OR middle_name like '%"+search_contact+"%' OR last_name like '%"+search_contact+"%' OR home_phone like '%"+search_contact+"%' OR cell_phone like '%"+search_contact+"%' OR home_address like '%"+search_contact+"%' OR home_city like '%"+search_contact+"%' OR home_state like '%"+ search_contact +"%' OR work_phone like '%"+search_contact+"%' OR work_address like '%"+search_contact+"%' OR work_city like '%"+search_contact+"%' OR work_state like '%"+search_contact+"%' ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int contact_id = resultSet.getInt("contact_id");
			String first_name = resultSet.getString("first_name");
			String middle_name = resultSet.getString("middle_name");
			String last_name = resultSet.getString("last_name");
			String home_phone = resultSet.getString("home_phone");
			String cell_phone = resultSet.getString("cell_phone");
			String home_address = resultSet.getString("home_address");
			String home_city = resultSet.getString("home_city");
			String home_state = resultSet.getString("home_state");
			int home_zip = resultSet.getInt("home_zip");
			String work_phone = resultSet.getString("work_phone");
			String work_address = resultSet.getString("work_address");
			String work_city = resultSet.getString("work_city");
			String work_state = resultSet.getString("work_state");
			int work_zip = resultSet.getInt("work_zip");
			Date birth_date=resultSet.getDate("birth_date");


			
			Contact contact = new Contact(contact_id,first_name, middle_name, last_name, home_phone, cell_phone, home_address, home_city,home_state,home_zip,work_phone,work_address,work_city,work_state,work_zip,birth_date);
			searchContact.add(contact);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return searchContact;
	}
	
	
}

