import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
	
	private final String createAddressQuery = "CREATE TABLE ADDRESS("
			  +"ADDRESS_ID INTEGER NOT NULL,"
				+"ADDRESS_LINE1 VARCHAR2(30) DEFAULT NULL,"
				+"ADDRESS_LINE2 VARCHAR2(30) DEFAULT NULL,"
				+"POSTAL_CODE VARCHAR2(15) DEFAULT NULL,"
				+"PHONE_NUMBER INTEGER DEFAULT NULL,"
				+"CITY VARCHAR2(45) DEFAULT NULL,"
				+"PROVINCE VARCHAR2(20) DEFAULT NULL,"
				+"PRIMARY KEY(ADDRESS_ID)"
				+")";
	private final String createLibUsersQuery = "CREATE TABLE LIBRARY_USERS"
			+"("
			+"USER_ID INTEGER NOT NULL"
			+", FIRST_NAME VARCHAR2(30) DEFAULT NULL"
			+", LAST_NAME VARCHAR2(30) DEFAULT NULL"
			+", EMAIL VARCHAR2(50) DEFAULT NULL"
			+", ADDRESS_ID INTEGER DEFAULT NULL"
			+", PRIMARY KEY(USER_ID)"
			+", FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS(ADDRESS_ID)"
			+")";
	
	
	private final String createLibrariansQuery = "CREATE TABLE LIBRARIANS("
			+"  EMPLOYEE_ID INTEGER NOT NULL"
			+", FIRST_NAME VARCHAR2(45) DEFAULT NULL"
			  +", LAST_NAME VARCHAR2(45) DEFAULT NULL"
			  +", EMPLOYEE_TYPE VARCHAR2(20) DEFAULT NULL"
			  +", PRIMARY KEY(EMPLOYEE_ID))";
	
	private final String createLILQuery = "CREATE TABLE LOCATION_IN_LIBRARY("
					  +"LOCATION_IN_LIBRARY_ID INTEGER NOT NULL"
					+", CATEGORY VARCHAR2(30) DEFAULT NULL"
					+", AISLE_NUM INTEGER DEFAULT NULL"
					+", PRIMARY KEY(LOCATION_IN_LIBRARY_ID)"
					+")";
	
//	private final String createLibraryCardsQuery = "CREATE TABLE LIBRARY_CARDS("
//					  +"CARD_NUM INTEGER NOT NULL "
//					+", WHEN_CREATED DATE DEFAULT NULL" 
//					+", EXPIRY_DATE DATE DEFAULT NULL"
//					+", USER_ID INTEGER NOT NULL"
//					+", PRIMARY KEY(CARD_NUM)"
//					+", FOREIGN KEY (USER_ID) REFERENCES LIBRARY_USERS(USER_ID)"
//					+")";
	
	private final String createLibraryCardsQuery = "CREATE TABLE LIBRARY_CARDS("
			  +"CARD_NUM INTEGER NOT NULL "
			+", WHEN_CREATED DATE DEFAULT NULL" 
			+", EXPIRY_DATE DATE DEFAULT NULL"
			+", PRIMARY KEY(CARD_NUM)"
			+")";
	
	private final String createCardUserRelQuery = "CREATE TABLE CARD_USER_RELATIONSHIP("
			+ "USER_ID INTEGER NOT NULL"
			+ ", CARD_NUM INTEGER NOT NULL"
			+ ", FOREIGN KEY (USER_ID) REFERENCES LIBRARY_USERS(USER_ID)"
			+ ", FOREIGN KEY (CARD_NUM) REFERENCES LIBRARY_CARDS(CARD_NUM)"
			+ ")";
	
	private final String createItemsQuery = "CREATE TABLE ITEMS("
					  +"ITEM_ID INTEGER NOT NULL"
					+", LOCATION_IN_LIBRARY_ID INTEGER NOT NULL"
					+", TITLE VARCHAR2(45) DEFAULT NULL"
					+", AVAILABLE INTEGER DEFAULT '0'"
					+", PRIMARY KEY(ITEM_ID)"
					+", FOREIGN KEY (LOCATION_IN_LIBRARY_ID) REFERENCES LOCATION_IN_LIBRARY(LOCATION_IN_LIBRARY_ID)"
					+")";
	private final String createBorrowedItemsQuery = "CREATE TABLE BORROWED_ITEMS("
					  +"ITEM_ID INTEGER NOT NULL "
					+", DATE_BORROWED DATE DEFAULT NULL" 
					+", DUE_DATE DATE DEFAULT NULL" 
					+", CARD_NUM INTEGER NOT NULL" 
					+", FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)"
					+", FOREIGN KEY (CARD_NUM) REFERENCES LIBRARY_CARDS(CARD_NUM)"
					+")";

	private final String createHoldItemsQuery = "CREATE TABLE HOLD_ITEMS("
					  +"ITEM_ID INTEGER NOT NULL"
					+", WHEN_HOLD DATE DEFAULT NULL"
					+", DONE_BY_LIBRARIAN_ID NOT NULL"
					+", CARD_NUM INTEGER NOT NULL" 
					+", FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)"
					+", FOREIGN KEY (CARD_NUM) REFERENCES LIBRARY_CARDS(CARD_NUM)"
					+", FOREIGN KEY (DONE_BY_LIBRARIAN_ID) REFERENCES LIBRARIANS(EMPLOYEE_ID)"
					+")";
	
	private final String createReturnedItemsQuery = "CREATE TABLE RETURNED_ITEMS("
					+"  ITEM_ID INTEGER NOT NULL "
					+", DATE_RETURNED DATE DEFAULT NULL"
					+", CARD_NUM INTEGER NOT NULL" 
					+", FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)"
					+", FOREIGN KEY (CARD_NUM) REFERENCES LIBRARY_CARDS(CARD_NUM)"
					+")";

	private final String createBooksQuery = "CREATE TABLE BOOKS("
					  +"ITEM_ID INTEGER NOT NULL"
					  +", ISBN VARCHAR2(50) DEFAULT NULL"
					  +", AUTHOR VARCHAR2(50) DEFAULT NULL"
					  +", PUBLISHER VARCHAR2(50) DEFAULT NULL"
					  +", FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)"
					  +")";
	
	private final String createAudioBooksQuery = "CREATE TABLE AUDIO_BOOKS("
			+"ITEM_ID INTEGER NOT NULL"
			+",  NARRATOR VARCHAR2(50) DEFAULT NULL"
			+", FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)"
			+")";
	
	private final String createMoviesQuery = "CREATE TABLE MOVIES("
			+"ITEM_ID INTEGER NOT NULL,"
			+"GENRE_TYPES VARCHAR2(100) DEFAULT NULL"
			+", FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)"
			+")";
	
	private final String createCDsQuery = "CREATE TABLE CDS("
			+"ITEM_ID INTEGER NOT NULL,"
			+"ARTISTS VARCHAR(256) DEFAULT NULL"
			+", ALBUM VARCHAR2(50) DEFAULT NULL"
			+", MUSIC_TYPE VARCHAR2(50) DEFAULT NULL"
			+", FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)"
			+")";
	
	private final String createStudyRoomsQuery = "CREATE TABLE STUDY_ROOMS("
			+"ROOM_ID INTEGER NOT NULL"
			+", LOCATION_IN_LIBRARY_ID INTEGER NOT NULL"
			+", NAME VARCHAR2(45) DEFAULT NULL"
			+", MAX_CAPACITY INTEGER DEFAULT NULL"
			+", PRIMARY KEY(ROOM_ID)"
			+", FOREIGN KEY (LOCATION_IN_LIBRARY_ID) REFERENCES LOCATION_IN_LIBRARY(LOCATION_IN_LIBRARY_ID)"
			+")";
			
		private final String createRoomReservationsQuery = "CREATE TABLE ROOM_RESERVATIONS("
				+"ROOM_ID INTEGER NOT NULL"
				+", CARD_NUM INTEGER NOT NULL"
				+", RESERVATION_START_DATE DATE DEFAULT NULL"
				+", RESERVATION_END_DATE DATE DEFAULT NULL"
				+", FOREIGN KEY (ROOM_ID) REFERENCES STUDY_ROOMS(ROOM_ID)"
				+", FOREIGN KEY (CARD_NUM) REFERENCES LIBRARY_CARDS(CARD_NUM)"
				+")";
		
		private final String createComputersQuery = "CREATE TABLE COMPUTERS("
				+"COMP_ID INTEGER NOT NULL"
				+", LOCATION_IN_LIBRARY_ID INTEGER NOT NULL"
				+", OPERATING_SYSTEM VARCHAR(30) DEFAULT NULL"
				+", PRIMARY KEY(COMP_ID)"
				+", FOREIGN KEY (LOCATION_IN_LIBRARY_ID) REFERENCES LOCATION_IN_LIBRARY(LOCATION_IN_LIBRARY_ID)"
				+")";
		private final String createComputerLoginsQuery = "CREATE TABLE COMPUTER_LOGINS("
				+"COMP_ID INTEGER NOT NULL"
				+", CARD_NUM INTEGER NOT NULL"
						+", LOG_IN_START_DATE TIMESTAMP DEFAULT NULL"
						+", LOG_IN_END_DATE TIMESTAMP DEFAULT NULL"
						+", FOREIGN KEY (COMP_ID) REFERENCES COMPUTERS(COMP_ID)"
						+", FOREIGN KEY (CARD_NUM) REFERENCES LIBRARY_CARDS(CARD_NUM)"
						+")";		
		private final String createFullBooksInfoView = "CREATE VIEW \"FULL_BOOKS_INFO\" (\"ITEM_ID\", \"TITLE\", \"AUTHOR\", \"PUBLISHER\") AS "
						+"SELECT ITEMS.ITEM_ID,ITEMS.TITLE, BOOKS.AUTHOR,BOOKS.PUBLISHER "
						+"FROM ITEMS,BOOKS "
						+"WHERE BOOKS.ITEM_ID = ITEMS.ITEM_ID";
	public CreateTables()
	{
		
	}
	
	public void createTables(Statement statement)
	{
		try 
		{
			statement.executeUpdate(createAddressQuery);
			statement.executeUpdate(createLibUsersQuery);
			statement.executeUpdate(createLibrariansQuery);
			statement.executeUpdate(createLILQuery);
			statement.executeUpdate(createLibraryCardsQuery);
			statement.executeUpdate(createCardUserRelQuery);
			statement.executeUpdate(createItemsQuery);
			statement.executeUpdate(createBorrowedItemsQuery );
			statement.executeUpdate(createHoldItemsQuery);
			statement.executeUpdate(createReturnedItemsQuery);
			statement.executeUpdate(createBooksQuery);
			statement.executeUpdate(createAudioBooksQuery);
			statement.executeUpdate(createMoviesQuery);
			statement.executeUpdate(createCDsQuery);
			statement.executeUpdate(createStudyRoomsQuery);
			statement.executeUpdate(createRoomReservationsQuery);
			statement.executeUpdate(createComputersQuery);
			statement.executeUpdate(createComputerLoginsQuery);
			statement.executeUpdate(createFullBooksInfoView);
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
