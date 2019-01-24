package ee.datanor.vali.it.leiabugi.model;

import lombok.Data;

@Data
public class Person {

  private String firstName;
  private String lastName;
  private long socialSecurityId;

  public long getID() {return socialSecurityId;}



}
