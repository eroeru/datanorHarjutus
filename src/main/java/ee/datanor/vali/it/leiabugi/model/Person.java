package ee.datanor.vali.it.leiabugi.model;

import lombok.Data;

@Data
public class Person {

  private String firstName;
  private String lastName;
  private long socialSecurityId;



  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }



  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }



  public long getSocialSecurityId() {
    return socialSecurityId;
  }

  public void setSocialSecurityId(long socialSecurityId) {
    this.socialSecurityId = socialSecurityId;
  }





}
