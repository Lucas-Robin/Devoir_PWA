package billetterie_console;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Band")
public class Band extends  Artist
{
  private Set<PersonArtist> members;

  /************************ Constructors ************************/
  public Band(String name, String country, String genre, Set<PersonArtist> members)
  {
    super(name, country, genre);
    this.members = members;
  }
    
  public Band(String name, String country, String genre)
  {
	super(name, country, genre);
	this.members = new HashSet<PersonArtist>();
  }

  public Band()
  {
	super();
	this.members = new HashSet<PersonArtist>();
  }

  
  /********************** Getters setters ***********************/
  public Set<PersonArtist> getMembers()
  {
    return members;
  }

  public void setMembers(Set<PersonArtist> members)
  {
    this.members = members;
  }
  
  

  public void addMember(PersonArtist newMember)
  {
	  // TODO: Add exception for member already in the band
	  this.members.add(newMember);  
  }
  
  public void removeMember(PersonArtist member2Remove)
  {
	  // TODO: Add exception for member already in the band
	  this.members.remove(member2Remove);
  }
  
  
  

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((members == null) ? 0 : members.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    Band other = (Band) obj;
    if (members == null)
    {
      if (other.members != null) return false;
    } else if (!members.equals(other.members)) return false;
    return true;
  }

@Override
public String toString()
{
	return "Band [name=" + name + ", country=" + country + ", genre=" + genre + ",\n\t members=" + members + "]";
}
  
  
  
  
}
