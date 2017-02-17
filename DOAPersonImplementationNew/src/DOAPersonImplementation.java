import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DOAPersonImplementation implements PersonDAO{

	private Connection connection=null;
	
		public Connection getConnection() throws ClassNotFoundException, SQLException
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:testuser/testpass@localhost");
//			String url="jdbc:oracle:thin:@localhost:1521:XE";
//			connection= DriverManager.getConnection(url, "person"/*user*/,
//					"person"/*password*/);
			return connection;
		}
		
		public void closeConnection() throws SQLException{
			if(connection!=null)
				connection.close();
		}
		
		public void insert(Person person) throws ClassNotFoundException, SQLException {
			PreparedStatement preparedStatement=
		getConnection().prepareStatement("INSERT INTO person(pid, name) VALUES(?,?)");
			preparedStatement.setInt(1, person.getId());
			preparedStatement.setString(2, person.getName());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			closeConnection();
		}
		
		public List<Person> select() throws SQLException, ClassNotFoundException{
			List<Person> persons= new ArrayList<>();
			Statement statement= getConnection().createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT * FROM person ORDER BY pid");
			
			Person person=null;
			
			while(resultSet.next()){
				person= new Person();
				person.setId(resultSet.getInt("pid"));
				person.setName(resultSet.getString("name"));
				persons.add(person);
			}
			
			resultSet.close();
			statement.close();
			closeConnection();
			return persons;
		}
 
		public Person selectById(int id) throws ClassNotFoundException, SQLException  {
			
			Statement statement= getConnection().createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT * FROM person WHERE pid="+id);
			
			Person person=null;
			
			while(resultSet.next()){
				person= new Person();
				person.setId(resultSet.getInt("pid"));
				person.setName(resultSet.getString("name"));
			
			}
			
			resultSet.close();
			statement.close();
			closeConnection();
			return person;
		}
		
		public void Delete(int id) throws ClassNotFoundException, SQLException  {
			List<Person> persons= new ArrayList<>();
			Statement statement= getConnection().createStatement();
			String st1 = "DELETE  FROM person WHERE pid="+id;
			System.out.println("statment before execute "   +st1);
			statement.executeUpdate(st1);
			Person person=null;
			persons.remove(person);
		}	
}






















