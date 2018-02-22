package billetterie_console;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Ticket")
public class Ticket
{
  protected long id;
	private String validationCode, cat, state, commentary;
	private int price; // en centimes
	private Show show;
	private LocalDate buyDate;
	private Client buyer;
  
  /************************ Constructors ************************/
  // Constructor for common use
  public Ticket(String validationCode, String cat, String commentary, int price, Show show)
  {
    super();
    this.validationCode = validationCode;
    this.cat = cat;
    this.commentary = commentary;
    this.price = price;
    this.show = show;
  }

  public Ticket(String validationCode, String cat, String state, String commentary, int price, Show show,
      LocalDate buyDate, Client buyer)
  {
    super();
    this.validationCode = validationCode;
    this.cat = cat;
    this.state = state;
    this.commentary = commentary;
    this.price = price;
    this.show = show;
    this.buyDate = buyDate;
    this.buyer = buyer;
  }
  
  

  
  public Ticket()
  {
    super();
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }
  
  public String getValidationCode()
  {
    return validationCode;
  }

  public void setValidationCode(String validationCode)
  {
    this.validationCode = validationCode;
  }

  public String getCat()
  {
    return cat;
  }

  public void setCat(String cat)
  {
    this.cat = cat;
  }

  public String getState()
  {
    return state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  public String getCommentary()
  {
    return commentary;
  }

  public void setCommentary(String commentary)
  {
    this.commentary = commentary;
  }

  public int getPrice()
  {
    return price;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }

  public Show getShow()
  {
    return show;
  }

  public void setShow(Show show)
  {
    this.show = show;
  }

  public LocalDate getBuyDate()
  {
    return buyDate;
  }

  public void setBuyDate(LocalDate buyDate)
  {
    this.buyDate = buyDate;
  }

  public Client getBuyer()
  {
    return buyer;
  }

  public void setBuyer(Client buyer)
  {
    this.buyer = buyer;
  }

  @Override
  public String toString()
  {
    return "Ticket [validationCode=" + validationCode + ", cat=" + cat + ", state=" + state + ", commentary="
        + commentary + ", price=" + price + ", show=" + show.print() + ", buyDate=" + buyDate + ", buyer=" + buyer + "]";
  }
 
  public String print()
  {
    return "Ticket [validationCode=" + validationCode + ", cat=" + cat + ", state=" + state + ", commentary="
        + commentary + ", price=" + price + ", buyDate=" + buyDate + ", buyer=" + buyer + "]";
  }
  
  
  
}
