



import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main extends DOAPersonImplementation{

	public static void main(String[] args) 
		// TODO Auto-generated method stub
	
		
		throws SQLException, ClassNotFoundException, java.io.IOException{
		
		 
				
				
				
				displayMenu();
			   
			   String op="";
			   
			   
			  while (!op.equalsIgnoreCase("5")){
				  Scanner sc= new Scanner(System.in);
				  op=sc.next();
				   switch (op) {
				case "1":
					System.out.println(" enter id");
					int id=sc.nextInt();
					System.out.println("enter  name");
					String name=sc.next();
									
					Person pers = new Person();
					pers.setId(id);
					pers.setName(name);
			
			
					DOAPersonImplementation dao = new  DOAPersonImplementation();
					dao.insert(pers);
					displayMenu();
					continue;

				case "2":
					System.out.println(" enter id");
					int id2=sc.nextInt();
					
					DOAPersonImplementation dao2 = new  DOAPersonImplementation();
					dao2.Delete(id2);
					displayMenu();
					continue;
					
				case "3":
					DOAPersonImplementation dao3 = new DOAPersonImplementation();
					
					List<Person> list = dao3.select();
					
					
					for (Person pers3:list)
						System.out.println((pers3.getName()+","+pers3.getId()));
					displayMenu();
					continue;
					
				case "4":
					  try {
					   System.out.println(" enter id");
						int id4=sc.nextInt();
							DOAPersonImplementation dao4 = new  DOAPersonImplementation();
							Person person=new Person();
							person=dao4.selectById(id4);
							System.out.println("name : " + person.getName());
					} catch (Exception e) {
						System.err.println("not found");
					}
					  displayMenu();
				   }
				   
					continue;
			  	
	}
				

			  

			
		}
	 public static void displayMenu()
	    {
		 System.out.println();
		  System.out.println("Enter number next options"
			   		+"\n 1.Add new Person"+"\n 2.Delete a Person"+
			   		"\n 3.List all Persons"+"\n 4.List Person By Id"
			   		+"\n 5.Exit");
	    }
}
