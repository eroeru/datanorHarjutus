package ee.datanor.vali.it.leiabugi.model;

import lombok.Data;

@Data
public class Person {

  private String firstName;
  private String lastName;
  private long socialSecurityId;


  //neid järgnevaid gettereid-settereid ilmselt poleks hetkel vajagi, kuna getSocialSecurityId töötab niisamagi (ilmselt tänu Spring @Autowired vms),
  // kuid kuna me oleme õppinud neid panema ning muidu kuvab mu seadistuse järgi punaselt, siis jätsin sisse
  //Peab mainima, et me *ei ole* õppinud Springi kasutama. eile kuulsime sellest esmakordselt.

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



//  public long getID() {return socialSecurityId;} - pole vaja, algselt kirjutasin, sest IntelliJ-s kuvas getSocialSecurityId kui viga



}
