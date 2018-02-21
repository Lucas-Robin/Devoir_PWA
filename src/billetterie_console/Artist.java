package billetterie_console;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Artist")
@XmlSeeAlso({Band.class, PersonArtist.class})
public class Artist //extends ClassWithID
{
  protected long id;
  protected String name, country, genre;

  /************************ Constructors ************************/
  public Artist(String name, String country, String genre)
  {
    super();
    this.name = name;
    this.country = country;
    this.genre = genre;
  }

  public Artist()
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

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getGenre()
  {
    return genre;
  }

  public void setGenre(String genre)
  {
    this.genre = genre;
  }






  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((genre == null) ? 0 : genre.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Artist other = (Artist) obj;
    if (country == null)
    {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (genre == null)
    {
      if (other.genre != null)
        return false;
    } else if (!genre.equals(other.genre))
      return false;
    if (name == null)
    {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "Artist_" + id + " [name=" + name + ", country=" + country + ", genre=" + genre + "]";
  }


}
