import java.sql.Statement;

public class DropTables {
	
	private final String dropAddressQuery = "DROP TABLE ADDRESS";
	private final String dropLibUsersQuery = "DROP TABLE LIBRARY_USERS";
	private final String dropLibrariansQuery = "DROP TABLE LIBRARIANS";
	private final String dropLILQuery = "DROP TABLE LOCATION_IN_LIBRARY";
	private final String dropLibraryCardsQuery = "DROP TABLE LIBRARY_CARDS";
	private final String dropCardUserRelQuery = "DROP TABLE CARD_USER_RELATIONSHIP";
	private final String dropItemsQuery = "DROP TABLE ITEMS";
	private final String dropBorrowedItemsQuery = "DROP TABLE BORROWED_ITEMS";
	private final String dropHoldItemsQuery = "DROP TABLE HOLD_ITEMS";
	private final String dropReturnedItemsQuery = "DROP TABLE RETURNED_ITEMS";
	private final String dropBooksQuery = "DROP TABLE BOOKS";
	private final String dropAudioBooksQuery = "DROP TABLE AUDIO_BOOKS";
	private final String dropMoviesQuery = "DROP TABLE MOVIES";
	private final String dropCDsQuery = "DROP TABLE CDS";
	private final String dropStudyRoomsQuery = "DROP TABLE STUDY_ROOMS";
	private final String dropRoomReservationsQuery = "DROP TABLE ROOM_RESERVATIONS";
	private final String dropComputersQuery = "DROP TABLE COMPUTERS";
	private final String dropComputerLoginsQuery = "DROP TABLE COMPUTER_LOGINS";
	private final String dropFullBooksInfoView = "DROP VIEW FULL_BOOKS_INFO";
	
	public DropTables()
	{
		
	}
	
	public void dropTables(Statement statement)
	{
		try
		{
			statement.executeUpdate(dropFullBooksInfoView);
			statement.executeUpdate(dropRoomReservationsQuery);
			statement.executeUpdate(dropStudyRoomsQuery);
			
			statement.executeUpdate(dropComputerLoginsQuery);
			statement.executeUpdate(dropComputersQuery);
			
			statement.executeUpdate(dropHoldItemsQuery);
			statement.executeUpdate(dropBorrowedItemsQuery);
			statement.executeUpdate(dropReturnedItemsQuery);
			
			statement.executeUpdate(dropMoviesQuery);
			statement.executeUpdate(dropAudioBooksQuery);
			statement.executeUpdate(dropBooksQuery);
			statement.executeUpdate(dropCDsQuery);
			statement.executeUpdate(dropItemsQuery);
			
			statement.executeUpdate(dropLibrariansQuery);
			
			statement.execute(dropCardUserRelQuery);
			statement.executeUpdate(dropLibraryCardsQuery);
			statement.executeUpdate(dropLibUsersQuery);
			
			statement.executeUpdate(dropLILQuery);
			statement.executeUpdate(dropAddressQuery);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
