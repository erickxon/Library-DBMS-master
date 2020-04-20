import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		connection = DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521/orcl","system","oracle");
		System.out.println("Connected to database.");
		Statement s = connection.createStatement();
//		
//		ResultSet rs = s.executeQuery("SELECT * FROM LIBRARY_USERS");
//		
//		while(rs.next())
//		{
//			String firstName = rs.getString("first_name");
//			String lastName = rs.getString("last_name");
//			String email = rs.getString("email");
//			System.out.println(firstName+" "+lastName+" "+email);
//		}
//		rs.close();
//		
//		rs = s.executeQuery("SELECT * FROM ITEMS");
//		while(rs.next())
//		{
//			String title = rs.getString("title");
//			System.out.println(title);
//		}
//		rs.close();
		
		CreateTables ct = new CreateTables();
		DropTables dt = new DropTables();
		PopulateTables pt = new PopulateTables();
		SelectExecuter se = new SelectExecuter();
		String[] buttons = { "Create Tables", "Populate Tables", "Drop Tables", "Queries","Cancel"};
		int returnValue = 0;
		String secondReturnValue = "";
		while(returnValue != 4)
		{
			returnValue = JOptionPane.showOptionDialog(null, "Please select one of the following options: ",
			"Library DBMS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
			if(returnValue == 0)
			{
				ct.createTables(s);
				JOptionPane.showMessageDialog(null, "Successfully created tables.");
			}
			else if(returnValue == 1)
			{
				pt.populateTables(s);
				JOptionPane.showMessageDialog(null, "Successfully populated tables.");
			}
			else if(returnValue == 2)
			{
				dt.dropTables(s);
				JOptionPane.showMessageDialog(null, "Dropped All Tables.");
			}
			if(returnValue == 3)
			{
				while(secondReturnValue != null)
				{
					secondReturnValue = JOptionPane.showInputDialog("Select a query to execute: \n"
							+ "1) SELECT * FROM COMPUTER_LOGINS WHERE LOG_IN_START_DATE >=TO_TIMESTAMP('2017-09-27','YYYY-MM-DD');\n"
							+ "2) SELECT * FROM STUDY_ROOMS WHERE MAX_CAPACITY >=5;\n"
							+ "3) SELECT * FROM ROOM_RESERVATIONS WHERE "
							+ "\nRESERVATION_START_DATE >=TO_TIMESTAMP('2017-09-26','YYYY-MM-DD') AND "
							+ "\nRESERVATION_END_DATE<TO_TIMESTAMP('2017-09-29','YYYY-MM-DD');\n"
							+ "4) SELECT * FROM ADDRESS WHERE CITY = 'TORONTO';\n"
							+ "5) SELECT * FROM BORROWED_ITEMS WHERE DUE_DATE = '04/10/2017';\n"
							+ "6) SELECT * FROM LIBRARY_USERS WHERE FIRST_NAME = 'JASON' ORDER BY LAST_NAME ASC;\n"
							+ "7) SELECT * FROM LIBRARIANS WHERE EMPLOYEE_TYPE = 'PART-TIME' ORDER BY FIRST_NAME ASC, LAST_NAME ASC;\n"
							+ "8) SELECT * FROM BOOKS WHERE AUTHOR = 'J. GEORGE' OR AUTHOR='G. TOLKIEN';\n"
							+ "9) Table View: SELECT * FROM FULL_BOOKS_INFO;\n"
							+ "10) SELECT LIBRARY_USERS.USER_ID,LIBRARY_USERS.FIRST_NAME,LIBRARY_USERS.LAST_NAME\n"
							+ "FROM LIBRARY_CARDS, LIBRARY_USERS,CARD_USER_RELATIONSHIP\n"
									+"WHERE LIBRARY_CARDS.EXPIRY_DATE <TO_DATE('01/01/2022','MM/DD/YYYY') AND\n"
									+"LIBRARY_CARDS.EXPIRY_DATE>TO_DATE('01/01/2017','MM/DD/YYYY')\n"
									+"AND LIBRARY_CARDS.CARD_NUM = CARD_USER_RELATIONSHIP.CARD_NUM\n"
									+"AND CARD_USER_RELATIONSHIP.USER_ID = LIBRARY_USERS.USER_ID\n"
									+"ORDER BY LAST_NAME ASC;\n"
							+ "11) SELECT sr.ROOM_ID,sr.NAME"
									+"\nFROM STUDY_ROOMS sr"
									+"\nWHERE NOT EXISTS"
									+"(SELECT rr.ROOM_ID"
									+"\nFROM ROOM_RESERVATIONS rr"
									+"\nWHERE rr.RESERVATION_START_DATE>=TO_DATE('09/25/2017','MM/DD/YYYY')"
									+"\nAND rr.RESERVATION_END_DATE <= TO_DATE('09/30/2017','MM/DD/YYYY')"
									+"\nAND sr.ROOM_ID = rr.ROOM_ID)"
									+"\nORDER BY NAME ASC;\n"
							+ "\n", "1");
					if(secondReturnValue != null){
						String returned = se.getSelectResults(s,Integer.parseInt(secondReturnValue));
						JOptionPane.showMessageDialog(null, new JTextArea(returned));
					}
				}
			}
		}
		
		s.close();
		System.out.println("Closing db connection.");
		connection.close();
	}

}
