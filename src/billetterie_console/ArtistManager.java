package billetterie_console;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/ArtistManager")
@Produces({"text/xml", "application/JSON", "application/xml"})
public class ArtistManager
{
  long currentId = 0;
  Map<Long, Artist> artists = new HashMap<Long, Artist>();
  
  public ArtistManager()
  {
    init();
  }
  
  

  final void init()
  {
    Band aal = new Band("Animals as Leader", "USA", "Métal Preogressif");
    PersonArtist jr = new PersonArtist("Javier Reyes", "USA", "Metal Progressif, Jazz fusion",
                       "Javier", "Reyes", "M", "Guitarist");
    PersonArtist ta = new PersonArtist("Tosin Abasi", "USA", "Metal Progressif, Jazz fusion",
           "Tosin", "Abasi", "M", "Guitarist");
    PersonArtist mg = new PersonArtist("Matt Gartska", "USA", "Metal Progressif",
           "Matt", "Gartska", "M", "Drummer");
    
    aal.addMember(ta);
    aal.addMember(jr);
    aal.addMember(mg);
    
    this.artists.put(this.currentId, aal);
    this.currentId++;
    this.artists.put(this.currentId, jr);
    this.currentId++;
    this.artists.put(this.currentId, ta);
    this.currentId++;
    this.artists.put(this.currentId, mg);

  }
}
