import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    private static Person _person;
    private static String _name = "Einstein";
    private static String _firstname = "Albert";
    private static String _phonenumber = "+41793456789";
    private static String _emailaddress = "ae@relativity.org";
    private static ArrayList<String> _languages;

    @BeforeEach
    public void setup() {
        _languages = new ArrayList<>();
        _person = new Person(_name, _firstname, _phonenumber, _emailaddress, _languages);
    }

    @Test
    public void allProperties_afterInstantiation_getCorrectValues() {
        assertEquals(_name, _person.getName());
        assertEquals(_firstname, _person.getFirstname());
        assertEquals(_phonenumber, _person.getPhonenumber());
        assertEquals(_emailaddress, _person.getEmailaddress());
        assertEquals(_languages, _person.getLanguages());
    }

    @Test
    public void languages_addFirstLanguage_getCorrectUniqueLanguage() {
        String expectedLanguage = "French";
        List<String> expectedLanguages = new ArrayList<>(Arrays.asList(expectedLanguage));

        _person.setLanguages(expectedLanguages);

        assertEquals(expectedLanguage, _person.getLanguages().get(0));
    }

    @Test
    public void languages_addMultipleLanguagesAtOnce_getCorrectListOfLanguages() {
        List<String> expectedLanguages = Arrays.asList("French", "Spanish", "German");

        _person.setLanguages(new ArrayList<>(expectedLanguages));

        assertEquals(expectedLanguages.size(), _person.getLanguages().size());
        for (String expectedLanguage : expectedLanguages) {
            assertTrue(_person.getLanguages().contains(expectedLanguage));
        }
    }

    @Test
    public void languages_addMultipleLanguagesInExistingLanguagesList_getCorrectListOfLanguages() {
        List<String> initialLanguages = Arrays.asList("French", "Spanish", "German");
        List<String> additionalLanguages = Arrays.asList("Vietnamese");
        List<String> expectedLanguages = new ArrayList<>(initialLanguages);
        expectedLanguages.addAll(additionalLanguages);

        _person.setLanguages(new ArrayList<>(initialLanguages));
        assertEquals(initialLanguages.size(), _person.getLanguages().size());

        _person.setLanguages(new ArrayList<>(additionalLanguages)); // This should add, not replace

        assertEquals(expectedLanguages.size(), _person.getLanguages().size());
        for (String expectedLanguage : expectedLanguages) {
            assertTrue(_person.getLanguages().contains(expectedLanguage));
        }
    }

    @Test
    public void languages_addMultipleLanguagesInExistingLanguagesListWithDuplicate_getCorrectListOfLanguages() {
        List<String> initialLanguages = Arrays.asList("French", "Spanish", "German");
        List<String> additionalLanguages = Arrays.asList("Vietnamese", "French"); // "French" is a duplicate
        List<String> expectedLanguages = new ArrayList<>(initialLanguages);
        expectedLanguages.add("Vietnamese"); // Only "Vietnamese" should be added, "French" is already there

        _person.setLanguages(new ArrayList<>(initialLanguages));
        assertEquals(initialLanguages.size(), _person.getLanguages().size());

        _person.setLanguages(new ArrayList<>(additionalLanguages)); // This should add, not replace

        assertEquals(expectedLanguages.size(), _person.getLanguages().size());
        for (String expectedLanguage : expectedLanguages) {
            assertTrue(_person.getLanguages().contains(expectedLanguage));
        }
    }
}
