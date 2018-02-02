package billetterie_console;

public class ShowOrganisator
{
  String name, mail;

  public ShowOrganisator(String name, String mail)
  {
    super();
    this.name = name;
    this.mail = mail;
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
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ShowOrganisator other = (ShowOrganisator) obj;
    if (mail == null)
    {
      if (other.mail != null) return false;
    } else if (!mail.equals(other.mail)) return false;
    if (name == null)
    {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    return true;
  }
  
  
}
