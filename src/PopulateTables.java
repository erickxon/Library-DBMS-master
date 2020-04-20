import java.sql.SQLException;
import java.sql.Statement;

public class PopulateTables {
	
	public PopulateTables()
	{
		
	}
	
	public void populateTables(Statement statement)
	{
		try
		{
			deleteExistingRecordsInTables(statement);			
			/*Populate ADDRESS*/
			statement.executeUpdate(PopulateTableQueries.populateAddress1);
			statement.executeUpdate(PopulateTableQueries.populateAddress2);
			statement.executeUpdate(PopulateTableQueries.populateAddress3);
			
			/*Populate LIBRARY_USERS*/
			statement.executeUpdate(PopulateTableQueries.populateLibUsers1);
			statement.executeUpdate(PopulateTableQueries.populateLibUsers2);
			statement.executeUpdate(PopulateTableQueries.populateLibUsers3);
			
			/*Populate LIBRARIANS*/
			statement.executeUpdate(PopulateTableQueries.populateLibrarians1);
			statement.executeUpdate(PopulateTableQueries.populateLibrarians2);
			statement.executeUpdate(PopulateTableQueries.populateLibrarians3);
			
			/*Populate LOCATION_IN_LIBRARY*/
			statement.executeUpdate(PopulateTableQueries.populateLocInLib1);
			statement.executeUpdate(PopulateTableQueries.populateLocInLib2);
			statement.executeUpdate(PopulateTableQueries.populateLocInLib3);
			statement.executeUpdate(PopulateTableQueries.populateLocInLib4);
			
			/*Populate LIBRARY_CARDS*/
			statement.executeUpdate(PopulateTableQueries.populateLibraryCards1);
			statement.executeUpdate(PopulateTableQueries.populateLibraryCards2);
			statement.executeUpdate(PopulateTableQueries.populateLibraryCards3);
			
			/*Populate CARD_USER_RELATIONSHIP*/
			statement.executeUpdate(PopulateTableQueries.populateCardUserRel1);
			statement.executeUpdate(PopulateTableQueries.populateCardUserRel2);
			statement.executeUpdate(PopulateTableQueries.populateCardUserRel3);
			
			/*Populate ITEMS*/
			statement.executeUpdate(PopulateTableQueries.populateItems1);
			statement.executeUpdate(PopulateTableQueries.populateItems2);
			statement.executeUpdate(PopulateTableQueries.populateItems3);
			
			/*Populate BORROWED_ITEMS*/
			statement.executeUpdate(PopulateTableQueries.populateItemBorrowed1);
			statement.executeUpdate(PopulateTableQueries.populateItemBorrowed2);
			statement.executeUpdate(PopulateTableQueries.populateItemBorrowed3);
			
			statement.executeUpdate(PopulateTableQueries.populateBorrowedItems1);
			statement.executeUpdate(PopulateTableQueries.populateBorrowedItems2);
			statement.executeUpdate(PopulateTableQueries.populateBorrowedItems3);
			
			/*Populate RETURNED_ITEMS*/
			statement.executeUpdate(PopulateTableQueries.populateItemReturn1);
			statement.executeUpdate(PopulateTableQueries.populateItemReturn2);
			statement.executeUpdate(PopulateTableQueries.populateItemReturn3);
			
			statement.executeUpdate(PopulateTableQueries.populateReturnedItems1);
			statement.executeUpdate(PopulateTableQueries.populateReturnedItems2);
			statement.executeUpdate(PopulateTableQueries.populateReturnedItems3);
			
			/*Populate HOLD_ITEMS*/
			statement.executeUpdate(PopulateTableQueries.populateItemHold1);
			statement.executeUpdate(PopulateTableQueries.populateItemHold2);
			statement.executeUpdate(PopulateTableQueries.populateItemHold3);
			
			statement.executeUpdate(PopulateTableQueries.poopulateHoldItems1);
			statement.executeUpdate(PopulateTableQueries.poopulateHoldItems2);
			statement.executeUpdate(PopulateTableQueries.poopulateHoldItems3);
			
			/*Populate AUDIO_BOOKS*/
			statement.executeUpdate(PopulateTableQueries.populateItemAudioBooks1);
			statement.executeUpdate(PopulateTableQueries.populateItemAudioBooks2);
			statement.executeUpdate(PopulateTableQueries.populateItemAudioBooks3);
			
			statement.executeUpdate(PopulateTableQueries.populateAudioBooks1);
			statement.executeUpdate(PopulateTableQueries.populateAudioBooks2);
			statement.executeUpdate(PopulateTableQueries.populateAudioBooks3);
			
			/*Populate BOOKS*/
			statement.executeUpdate(PopulateTableQueries.populateItemBooks1);
			statement.executeUpdate(PopulateTableQueries.populateItemBooks2);
			statement.executeUpdate(PopulateTableQueries.populateItemBooks3);
			
			statement.executeUpdate(PopulateTableQueries.populateBooks1);
			statement.executeUpdate(PopulateTableQueries.populateBooks2);
			statement.executeUpdate(PopulateTableQueries.populateBooks3);
			
			/*Populate MOVIES*/
			statement.executeUpdate(PopulateTableQueries.populateItemMovies1);
			statement.executeUpdate(PopulateTableQueries.populateItemMovies2);
			statement.executeUpdate(PopulateTableQueries.populateItemMovies3);
			
			statement.executeUpdate(PopulateTableQueries.populateMovies1);
			statement.executeUpdate(PopulateTableQueries.populateMovies2);
			statement.executeUpdate(PopulateTableQueries.populateMovies3);
			
			/*Populate CDS*/
			statement.executeUpdate(PopulateTableQueries.populateItemCD1);
			statement.executeUpdate(PopulateTableQueries.populateItemCD2);
			statement.executeUpdate(PopulateTableQueries.populateItemCD3);
			
			statement.executeUpdate(PopulateTableQueries.populateCDS1);
			statement.executeUpdate(PopulateTableQueries.populateCDS2);
			statement.executeUpdate(PopulateTableQueries.populateCDS3);
			
			/*Populate STUDY_ROOMS*/
			statement.executeUpdate(PopulateTableQueries.populateStudyRooms1);
			statement.executeUpdate(PopulateTableQueries.populateStudyRooms2);
			statement.executeUpdate(PopulateTableQueries.populateStudyRooms3);
			
			/*Populate ROOM_RESERVATIONS*/
			statement.executeUpdate(PopulateTableQueries.populateRoomReserv1);
			statement.executeUpdate(PopulateTableQueries.populateRoomReserv2);
			statement.executeUpdate(PopulateTableQueries.populateRoomReserv3);
			
			/*Populate COMPUTERS*/
			statement.executeUpdate(PopulateTableQueries.populateComp1);
			statement.executeUpdate(PopulateTableQueries.populateComp2);
			statement.executeUpdate(PopulateTableQueries.populateComp3);
						
			/*Populate COMPUTER_LOGINS*/
			statement.executeUpdate(PopulateTableQueries.populateCompLogin1);
			statement.executeUpdate(PopulateTableQueries.populateCompLogin2);
			statement.executeUpdate(PopulateTableQueries.populateCompLogin3);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void deleteExistingRecordsInTables(Statement statement) throws SQLException 
	{
		statement.executeUpdate(PopulateTableQueries.deleteCompLogins);
		statement.executeUpdate(PopulateTableQueries.deleteComp);
		statement.executeUpdate(PopulateTableQueries.deleteRoomReserv);
		statement.executeUpdate(PopulateTableQueries.deleteStudyRooms);
		statement.executeUpdate(PopulateTableQueries.deleteBorrowedItems);
		statement.executeUpdate(PopulateTableQueries.deleteReturnedItems);
		statement.executeUpdate(PopulateTableQueries.deleteHoldItems);
		statement.executeUpdate(PopulateTableQueries.deleteMovies);
		statement.executeUpdate(PopulateTableQueries.deleteCDS);
		statement.executeUpdate(PopulateTableQueries.deleteAudioBooks);
		statement.executeUpdate(PopulateTableQueries.deleteBooks);
		statement.executeUpdate(PopulateTableQueries.deleteItems);
		statement.executeUpdate(PopulateTableQueries.deleteCardUserRel);
		statement.executeUpdate(PopulateTableQueries.deleteLibCards);
		statement.executeUpdate(PopulateTableQueries.deleteLibrarians);
		statement.executeUpdate(PopulateTableQueries.deleteLibUsers);
		statement.executeUpdate(PopulateTableQueries.deleteLocInLib);
		statement.executeUpdate(PopulateTableQueries.deleteAddress);
		
	}
}
