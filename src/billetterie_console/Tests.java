package billetterie_console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tests
{

	public static void main(String[] args)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		Band aal = new Band("Animals as Leader", "USA", "Métal Preogressif");
		PersonArtist jr = new PersonArtist("Javier Reyes", "USA", "Metal Progressif, Jazz fusion",
										   "Javier", "Reyes", "M", "Guitarist");
		PersonArtist ta = new PersonArtist("Tosin Abasi", "USA", "Metal Progressif, Jazz fusion",
				   "Tosin", "Abasi", "M", "Guitarist");
		PersonArtist mg = new PersonArtist("Matt Gartska", "USA", "Metal Progressif",
				   "Matt", "Gartska", "M", "Drummer");
		
		Place p1 = new Place("Sale de concert", "Divan du monde", 490, "+33 1 40 05 08 10", "", "", "");
		
		ShowOrganisator so1 = new ShowOrganisator("Blabla", "contact@blabla.com");
		
		Show s1 = new Show("AAL@Divan du Monde", "", LocalDateTime.parse("09-05-2019 19:30", formatter), so1, p1);
		s1.addArtist(aal);
		
		aal.addMember(ta);
		aal.addMember(jr);
		aal.addMember(mg);
		
		System.out.println(aal);
		System.out.println(s1);
		System.out.println(p1);
	}

}
