package billetterie_console;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Show
{
  String name, commentary;
  LocalDateTime date;
  Set<Artist> artistsList;
  ShowOrganisator organisator;
  Place place;
  Set<Ticket> ticketsList;
  
  // Constructor for common use
  public Show(String name, String commentary, LocalDateTime date, ShowOrganisator organisator, Place place)
  {
    super();
    this.name = name;
    this.commentary = commentary;
    this.date = date;
    this.organisator = organisator;
    this.place = place;
    this.artistsList = new HashSet<Artist>();
    this.ticketsList = new HashSet<Ticket>();
  }

  //Constructor for automated framework
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
    this.ticketsList = ticketsList;
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
  }

  public Set<Ticket> getTicketsList()
  {
    return ticketsList;
  }

  public void setTicketsList(Set<Ticket> ticketsList)
  {
    this.ticketsList = ticketsList;
  }
  
  
  
  
}
