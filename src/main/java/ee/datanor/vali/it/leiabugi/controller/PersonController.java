package ee.datanor.vali.it.leiabugi.controller;


import ee.datanor.vali.it.leiabugi.model.Person;
import ee.datanor.vali.it.leiabugi.service.PersonService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Palun lisada juurde uus kontrolleri meetod millega saaks olemasolevaid kasutajaid muuta,
// sisuliselt on tegu sarnase meetodiga nagu on kasutaja lisamine, kuid muutmiseks kasutatakse REST standardite järgi HTTP POST mitte PUT.


//        Kui muudetavat kasutajat listist ei leita siis tuleks visata viga,
//        kui kasutaja on olemas siis muuta listi siis kasutaja ees või perenime, isikukoodi muuta ei saa.

//        Samuti täiendada ka praegust kasutaja lisamise funktsiooni nii, et kui sisestada isikut isikukoodiga mis juba on olemas siis visata viga.

//        Lisada juurde ka HTTP DELETE kontrolleri meetod millega saab isikukoodi alusel isikuid nimekirjast kustutada


@Slf4j
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {


    @Autowired
    PersonService personService;

    @RequestMapping(value = "/{socialSecurityId}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long socialSecurityId) {
        return personService.getPerson(socialSecurityId);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getPersonList() {
        return personService.getPersons();

    }


    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void addPerson(@RequestBody Person item) {
        personService.addPerson(item);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void changePerson(@RequestBody Person item) {
        personService.changePerson(item);
    }


    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long socialSecurityId) {
        personService.deletePerson(socialSecurityId);


    }
}
