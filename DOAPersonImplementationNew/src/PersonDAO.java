import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
	void insert(Person p) throws ClassNotFoundException, SQLException;
	List<Person> select() throws SQLException, ClassNotFoundException ;
	Person selectById(int id) throws ClassNotFoundException, SQLException;
	void Delete(int id) throws ClassNotFoundException, SQLException;
	
	Connection getConnection() throws ClassNotFoundException, SQLException;
 
}
