package billetterie_console;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ShowOrganisator")
public class ShowOrganisator
{
  protected long id;
	private String name, mail;

  /************************ Constructors ************************/
  public ShowOrganisator(String name, String mail)
  {
    super();
    this.name = name;
    this.mail = mail;
  }

  public ShowOrganisator()
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

  public String getMail()
  {
    return mail;
  }

  public void setMail(String mail)
  {
    this.mail = mail;
  }

  
  


  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
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
    ShowOrganisator other = (ShowOrganisator) obj;
    if (id != other.id)
      return false;
    if (mail == null)
    {
      if (other.mail != null)
        return false;
    } else if (!mail.equals(other.mail))
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
    return "ShowOrganisator" + id + " [name=" + name + ", mail=" + mail + "]";
  }
  
  
  
  
}
