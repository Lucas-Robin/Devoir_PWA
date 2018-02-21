package billetterie_console;

public class Client //extends ClassWithID
{
  protected long id;
	private String firstname, lastname, mail;

  /************************ Constructors ************************/
  public Client(String firstname, String lastname, String mail)
  {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.mail = mail;
  }

  public Client()
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
  
  public String getFirstname()
  {
    return firstname;
  }

  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }

  public String getLastname()
  {
    return lastname;
  }

  public void setLastname(String lastname)
  {
    this.lastname = lastname;
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
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Client other = (Client) obj;
    if (firstname == null)
    {
      if (other.firstname != null) return false;
    } else if (!firstname.equals(other.firstname)) return false;
    if (lastname == null)
    {
      if (other.lastname != null) return false;
    } else if (!lastname.equals(other.lastname)) return false;
    if (mail == null)
    {
      if (other.mail != null) return false;
    } else if (!mail.equals(other.mail)) return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "Client" + id + " [firstname=" + firstname + ", lastname=" + lastname + ", mail=" + mail + "]";
  }
  
  
  
  
}
