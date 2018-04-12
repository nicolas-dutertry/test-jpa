package com.dutertry.test.karaf.jpa.cmd;

import java.util.List;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import com.dutertry.test.karaf.jpa.entities.Person;
import com.dutertry.test.karaf.jpa.service.TestService;

/**
 *
 * @author ndutertry
 */
@Command(scope = "person", name = "list", description = "List people")
@Service
public class ListPersonCommand implements Action {

    @Reference
    private TestService testService;

    @Override
    public Object execute() throws Exception {
        List<Person> persons = testService.list();
        if(persons != null) {
            for (Person person : persons) {
                System.out.println(person.getLastName() + " - " + person.getAge() + " years old");
            }            
        }
        
        return null;
    }

}
