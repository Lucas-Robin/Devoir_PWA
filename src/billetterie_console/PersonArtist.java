package billetterie_console;

public class PersonArtist extends  Artist
{
  private String lastname, firstname, sex, role;
  
  /************************ Constructors ************************/
  public PersonArtist(String name, String country, String genre, String lastname, String firstname, String sex,
      String role)
  {
    super(name, country, genre);
    this.lastname = lastname;
    this.firstname = firstname;
    this.sex = sex;
    this.role = role;
  }
  
  

  public PersonArtist()
{
	super();
}



@Override
  public int hashCode()
  {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + ((role == null) ? 0 : role.hashCode());
    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    PersonArtist other = (PersonArtist) obj;
    if (firstname == null)
    {
      if (other.firstname != null) return false;
    } else if (!firstname.equals(other.firstname)) return false;
    if (lastname == null)
    {
      if (other.lastname != null) return false;
    } else if (!lastname.equals(other.lastname)) return false;
    if (role == null)
    {
      if (other.role != null) return false;
    } else if (!role.equals(other.role)) return false;
    if (sex == null)
    {
      if (other.sex != null) return false;
    } else if (!sex.equals(other.sex)) return false;
    return true;
  }

  	
  /********************** Getters setters ***********************/
  public String getLastname()
  {
    return lastname;
  }

  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }

  public String getSex()
  {
    return sex;
  }

  public void setSex(String sex)
  {
    this.sex = sex;
  }

  public String getRole()
  {
    return role;
  }

  public void setRole(String role)
  {
    this.role = role;
  }



@Override
public String toString()
{
	return "PersonArtist [lastname=" + lastname + ", firstname=" + firstname + ", sex=" + sex + ", role=" + role
			+ ", name=" + name + ", country=" + country + ", genre=" + genre + "]";
}
  
  
}
