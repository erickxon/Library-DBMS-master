import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExecuter 
{
	
	public SelectExecuter(){}
	
	public String getSelectResults(Statement statement, int option)
	{
		StringBuilder sb = new StringBuilder();
		ResultSet rs = null;
		try
		{
			if(option == 1)
			{
				rs = statement.executeQuery(SelectQueries.selQuery1);   
				sb.append("COMP_ID\tCARD_NUM\tLOG_IN_START_DATE\tLOG_IN_END_DATE\n");
				while(rs.next())
				{	   
					int compID = rs.getInt("COMP_ID");
					int cardNum = rs.getInt("CARD_NUM");
					Date loginStartDate = rs.getDate("LOG_IN_START_DATE");
					Date loginEndDate = rs.getDate("LOG_IN_END_DATE");
					sb.append(compID+"\t"+cardNum+"\t"+loginStartDate.toString()+"\t\t"+loginEndDate.toString()+"\n");
				}
				return sb.toString();
			}
			else if(option == 2)
			{
				rs = statement.executeQuery(SelectQueries.selQuery2);
				sb.append("ROOM_ID\tLOCATION_IN_LIBRARY_ID\tNAME\tMAX_CAPACITY\n");
				while(rs.next())
				{
					int roomID = rs.getInt("ROOM_ID");
					int locInLib = rs.getInt("LOCATION_IN_LIBRARY_ID");
					String name = rs.getString("NAME");
					int maxCap = rs.getInt("MAX_CAPACITY");
					sb.append(roomID+"\t"+locInLib+"\t\t"+name+"\t"+maxCap+"\n");
				}
				return sb.toString();
			}
			else if(option == 3)
			{
				rs = statement.executeQuery(SelectQueries.selQuery3);
				sb.append("ROOM_ID\tCARD_NUM\tRESERVATION_START_DATE\tRESERVATION_END_DATE\n");
				while(rs.next())
				{
					int roomID = rs.getInt("ROOM_ID");
					int cardNum = rs.getInt("CARD_NUM");
					Date resStartDate = rs.getDate("RESERVATION_START_DATE");
					Date resEndDate = rs.getDate("RESERVATION_END_DATE");
					sb.append(roomID+"\t"+cardNum+"\t"+resStartDate+"\t\t"+resEndDate+"\n");
				}
				return sb.toString();
			}
			else if(option == 4)
			{
				rs = statement.executeQuery(SelectQueries.selQuery4);
				sb.append("ADDRESS_ID\tADDRESS_LINE1\tADDRESS_LINE2\tPOSTAL_CODE\tPHONE_NUMBER\tCITY\tPROVINCE\n");
				while(rs.next())
				{
					int addressID = rs.getInt("ADDRESS_ID");
					String line1 = rs.getString("ADDRESS_LINE1");
					String line2 = rs.getString("ADDRESS_LINE2");
					String postalCode = rs.getString("POSTAL_CODE");
					long phoneNum = rs.getLong("PHONE_NUMBER");
					String city = rs.getString("CITY");
					String province = rs.getString("PROVINCE");
					if(line1.length()>=15)
						sb.append(addressID+"\t"+line1+"\t"+line2+"\t\t"+postalCode+"\t\t"+phoneNum+"\t\t"+city+"\t"+province+"\n");
					else
						sb.append(addressID+"\t"+line1+"\t\t"+line2+"\t\t"+postalCode+"\t\t"+phoneNum+"\t\t"+city+"\t"+province+"\n");
				}
			}
			else if(option == 5)
			{
				rs = statement.executeQuery(SelectQueries.selQuery5);
				sb.append("ITEM_ID\tDATE_BORROWED\tDUE_DATE\tCARD_NUM\n");
				while(rs.next())
				{
					//SELECT * FROM BORROWED_ITEMS WHERE DUE_DATE = '04/10/2017'
					int itemID = rs.getInt("ITEM_ID");
					Date dateBorrowed = rs.getDate("DATE_BORROWED");
					Date dueDate = rs.getDate("DUE_DATE");
					int cardNum = rs.getInt("CARD_NUM");
					sb.append(itemID+"\t"+dateBorrowed+"\t\t"+dueDate+"\t"+cardNum+"\n");					
				}
			}
			else if(option == 6)
			{
				rs = statement.executeQuery(SelectQueries.selQuery6);
				sb.append("USER_ID\tFIRST_NAME\tLAST_NAME\tEMAIL\t\t\tADDRESS_ID\n");
				while(rs.next())
				{
					//SELECT * FROM LIBRARY_USERS WHERE FIRST_NAME = 'Jason' ORDER BY LAST_NAME ASC;
					int userID = rs.getInt("USER_ID");
					String firstName = rs.getString("FIRST_NAME");
					String lastName = rs.getString("LAST_NAME");
					String email = rs.getString("EMAIL");
					int addressID = rs.getInt("ADDRESS_ID");
					if(email.length()>=20)
						sb.append(userID+"\t"+firstName+"\t"+lastName+"\t"+email+"\t"+addressID+"\n");
					else
						sb.append(userID+"\t"+firstName+"\t"+lastName+"\t"+email+"\t\t"+addressID+"\n");
				}
			}
			else if(option == 7)
			{
				rs = statement.executeQuery(SelectQueries.selQuery7);
				sb.append("EMPLOYEE_ID\tFIRST_NAME\tLAST_NAME\tEMPLOYEE_TYPE\n");
				while(rs.next())
				{
					int empID = rs.getInt("EMPLOYEE_ID");
					String firstName = rs.getString("FIRST_NAME");
					String lastName = rs.getString("LAST_NAME");
					String empType = rs.getString("EMPLOYEE_TYPE");
					sb.append(empID+"\t"+firstName+"\t"+lastName+"\t"+empType+"\n");
				}
			}
			else if(option == 8)
			{
				rs = statement.executeQuery(SelectQueries.selQuery8);
				sb.append("ITEM_ID\tISBN\t\tAUTHOR\tPUBLISHER\n");
				while(rs.next())
				{
					//SELECT * FROM BOOKS WHERE AUTHOR = 'J. GEORGE' OR AUTHOR='G. TOLKIEN'
					int itemID = rs.getInt("ITEM_ID");
					String isbn = rs.getString("ISBN");
					String author = rs.getString("AUTHOR");
					String publisher = rs.getString("PUBLISHER");
					sb.append(itemID+"\t"+isbn+"\t"+author+"\t"+publisher+"\n");
					
				}
			}
			else if(option == 9)
			{
				rs = statement.executeQuery(SelectQueries.selQuery9);
				sb.append("TITLE\t\tAUTHOR\tPUBLISHER\tITEM_ID\n");
				while(rs.next())
				{
					String title = rs.getString("TITLE");
					String author = rs.getString("AUTHOR");
					String publisher = rs.getString("PUBLISHER");
					int itemID = rs.getInt("ITEM_ID");
					if(title.length()>=15)
						sb.append(title+"\t"+author+"\t"+publisher+"\t"+itemID+"\n");
					else
						sb.append(title+"\t\t"+author+"\t"+publisher+"\t"+itemID+"\n");
				}
			}
			else if(option == 10)
			{
				rs = statement.executeQuery(SelectQueries.selQuery10);
				sb.append("USER_ID\tFIRST_NAME\tLAST_NAME\n");
				while(rs.next())
				{
					int userID = rs.getInt("USER_ID");
					String firstName = rs.getString("FIRST_NAME");
					String lastName = rs.getString("LAST_NAME");
					sb.append(userID+"\t"+firstName+"\t"+lastName+"\n");					
				}
			}
			else
			{
				rs = statement.executeQuery(SelectQueries.selQuery11);	
				sb.append("ROOM_ID\tNAME\t\n");
				while(rs.next())
				{
					int roomID = rs.getInt("ROOM_ID");
					String name = rs.getString("NAME");
					sb.append(roomID+"\t"+name+"\n");
				}
				
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
