package upenn.fleamarket.demo.data;

import org.springframework.data.annotation.Id;

public class Item {
  @Id
  protected String id;

  protected String name;
  protected String description = "";
  protected String school_name;
  protected String location;
  protected String email;
  protected String phone = "";
  protected String price;
  protected String slack = "";
  protected String condition;
  protected String image = "assets/images/default_3.jpg";

  public Item(String name, String school_name, String location, String email, String price, String condition) {
    this.condition = condition;
    this.name = name;
    this.email = email;
    this.location = location;
    this.school_name = school_name;
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format("Item[name = %s, id = %s, school name = %s, location = %s, price = %s, condition = %s]", name,
        id, school_name, location, price, condition);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSchool_name() {
    return school_name;
  }

  public void setSchool_name(String school_name) {
    this.school_name = school_name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getSlack() {
    return slack;
  }

  public void setSlack(String slack) {
    this.slack = slack;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

}