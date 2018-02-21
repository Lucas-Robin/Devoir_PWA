package billetterie_console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Show //extends ClassWithID
{
  protected long id;
  private String name, commentary;
  private LocalDateTime date;
  private Set<Artist> artistsList;
  private ShowOrganisator organisator;
  private Place place;
  private Set<Ticket> ticketsList;

  /************************ Constructors ************************/
  // Constructor for common use
  public Show(String name, String commentary, LocalDateTime date, ShowOrganisator organisator, Place place)
  {
    super();
    this.name = name;
    this.commentary = commentary;
    this.date = date;
    this.organisator = organisator;
    
    this.place = place;
    place.addShow(this);    
    
    this.artistsList = new HashSet<Artist>();
    this.ticketsList = new HashSet<Ticket>();
  }

  public Show(String name, String commentary, LocalDateTime date, Set<Artist> artistsList, ShowOrganisator organisator,
      Place place, Set<Ticket> ticketsList)
  {
    super();
    this.name = name;
    this.commentary = commentary;
    this.date = date;
    this.artistsList = artistsList;
    this.organisator = organisator;
    
    this.place = place;
    place.addShow(this);
    
    this.ticketsList = ticketsList;
  }
  
  public Show()
  {
	super();
  }

  
  
  
  /********************** Getters setters ***********************/
  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getCommentary()
  {
    return commentary;
  }

  public void setCommentary(String commentary)
  {
    this.commentary = commentary;
  }

  public LocalDateTime getDate()
  {
    return date;
  }

  public void setDate(LocalDateTime date)
  {
    this.date = date;
  }

  public Set<Artist> getArtistsList()
  {
    return artistsList;
  }

  public void setArtistsList(Set<Artist> artistsList)
  {
    this.artistsList = artistsList;
  }

  public ShowOrganisator getOrganisator()
  {
    return organisator;
  }

  public void setOrganisator(ShowOrganisator organisator)
  {
    this.organisator = organisator;
  }

  public Place getPlace()
  {
    return place;
  }

  public void setPlace(Place place)
  {
    this.place = place;
    place.addShow(this);
  }

  public Set<Ticket> getTicketsList()
  {
    return ticketsList;
  }

  public void setTicketsList(Set<Ticket> ticketsList)
  {
    this.ticketsList = ticketsList;
  }
  
  

  @Override
  public String toString()
  {
    return "Show" + id + " [name=" + name + ", commentary=" + commentary + ", date=" + 
           date.format(DateTimeFormatter.ofPattern("EEEE dd MMM yyyy HH:mm")) + ",\n\t artistsList=" + artistsList
           + ",\n\t organisator=" + organisator + ", place=" + place.print() + ",\n\t ticketsList=" + 
           ticketsList.stream().map((ticket) -> ticket.print()).collect(Collectors.joining(",\n\t\t")) + "]";
  }
  
  public String print()
  { 
    return "Show" + id + " [name=" + name + ", commentary=" + commentary + ", date=" + 
           date.format(DateTimeFormatter.ofPattern("EEEE dd MMM yyyy HH:mm")) + ",\n\t artistsList=" + artistsList + 
           ",\n\t organisator=" + organisator + "]";
  }
  
  public void addArtist(Artist newArtist)
  {
    this.artistsList.add(newArtist);
  }

  public void removeArtist(Artist artist2Remove)
  {
    this.artistsList.remove(artist2Remove);
  }
  
}
