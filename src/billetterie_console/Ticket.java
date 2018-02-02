package billetterie_console;

import java.time.LocalDate;

public class Ticket
{
  String validationCode, cat, state, commentary;
  int price; // en centimes
  Show show;
  LocalDate buyDate;
  Client buyer;
  
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

  // Constructor for automated framework
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
 
  
  
}
