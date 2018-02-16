package billetterie_console;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Place 
{
  private String type, // Salle de concert, lieu plein air...  
         		 name, 
         		 phonenumber, 
         		 mail, 
         		 infosPMR, 
         		 commentary;
  private int capacity;
  private Set<Show> showList;
  
  /************************ Constructors ************************/
  // Constructor for common use
  public Place(String type, String name, int capacity, String phonenumeber, String mail, String infosPMR, String commentary)
  {
    super();
    this.type = type;
    this.name = name;
    this.phonenumber = phonenumeber;
    this.mail = mail;
    this.infosPMR = infosPMR;
    this.commentary = commentary;
    this.capacity = capacity;
    this.showList = new HashSet<Show>();
  }

  public Place(String type, String name, String phonenumber, String mail, String infosPMR, String commentary,
      int capacity, Set<Show> showList)
  {
    super();
    this.type = type;
    this.name = name;
    this.phonenumber = phonenumber;
    this.mail = mail;
    this.infosPMR = infosPMR;
    this.commentary = commentary;
    this.capacity = capacity;
    this.showList = showList;
  }

  public Place()
  {
	super();
  }

@Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + capacity;
    result = prime * result + ((commentary == null) ? 0 : commentary.hashCode());
    result = prime * result + ((infosPMR == null) ? 0 : infosPMR.hashCode());
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
    result = prime * result + ((showList == null) ? 0 : showList.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Place other = (Place) obj;
    if (capacity != other.capacity) return false;
    if (commentary == null)
    {
      if (other.commentary != null) return false;
    } else if (!commentary.equals(other.commentary)) return false;
    if (infosPMR == null)
    {
      if (other.infosPMR != null) return false;
    } else if (!infosPMR.equals(other.infosPMR)) return false;
    if (mail == null)
    {
      if (other.mail != null) return false;
    } else if (!mail.equals(other.mail)) return false;
    if (name == null)
    {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    if (phonenumber == null)
    {
      if (other.phonenumber != null) return false;
    } else if (!phonenumber.equals(other.phonenumber)) return false;
    if (showList == null)
    {
      if (other.showList != null) return false;
    } else if (!showList.equals(other.showList)) return false;
    if (type == null)
    {
      if (other.type != null) return false;
    } else if (!type.equals(other.type)) return false;
    return true;
  }

  
  /********************** Getters setters ***********************/
  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getPhonenumber()
  {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber)
  {
    this.phonenumber = phonenumber;
  }

  public String getMail()
  {
    return mail;
  }

  public void setMail(String mail)
  {
    this.mail = mail;
  }

  public String getInfosPMR()
  {
    return infosPMR;
  }

  public void setInfosPMR(String infosPMR)
  {
    this.infosPMR = infosPMR;
  }

  public String getCommentary()
  {
    return commentary;
  }

  public void setCommentary(String commentary)
  {
    this.commentary = commentary;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public void setCapacity(int capacity)
  {
    this.capacity = capacity;
  }

  public Set<Show> getShowList()
  {
    return showList;
  }

  public void setShowList(Set<Show> showList)
  {
    this.showList = showList;
  }
  
  
  public void addShow(Show newShow)
  {
	  this.showList.add(newShow);
  }
  
  public void removeShow(Show show2Remove)
  {
	  this.showList.remove(show2Remove);
  }

@Override
public String toString()
{
	return "Place [type=" + type + ", name=" + name + ", phonenumber=" + phonenumber + ", mail=" + mail + ", infosPMR=" +
	       infosPMR + ", commentary=" + commentary + ", capacity=" + capacity + ",\n\t showList=" + 
	       showList.stream().map((show) -> show.print()).collect(Collectors.joining(",\n\t\t")) + "]";
}

public String print()
{
  return "Place [type=" + type + ", name=" + name + ", phonenumber=" + phonenumber + ", mail=" + mail + ", infosPMR="
      + infosPMR + ", commentary=" + commentary + ", capacity=" + capacity + "]";
}

}
