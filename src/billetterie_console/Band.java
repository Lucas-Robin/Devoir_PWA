package billetterie_console;

import java.util.Set;

public class Band extends  Artist
{
  Set<PersonArtist> members;

  public Band(String name, String country, String genre, Set<PersonArtist> members)
  {
    super(name, country, genre);
    this.members = members;
  }

  public Set<PersonArtist> getMembers()
  {
    return members;
  }

  public void setMembers(Set<PersonArtist> members)
  {
    this.members = members;
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
  
  
}
