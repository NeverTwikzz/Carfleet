import java.util.ArrayList;
import java.util.List;

public class Person {
    //region private attributes
    private String _name;
    private String _firstname;
    private String _phonenumber;
    private String _emailaddress;
    private ArrayList<String> _languages;
    //endregion private attributes

    //region public methods
    public Person(String name, String firstname, String phonenumber, String emailaddress, ArrayList<String> languages) {
        this._name = name;
        this._firstname = firstname;
        this._phonenumber = phonenumber;
        this._emailaddress = emailaddress;
        this._languages = languages;
    }

    public String getName() {
        return _name;
    }

    public String getFirstname() {
        return _firstname;
    }

    public String getPhonenumber() {
        return _phonenumber;
    }

    public String getEmailaddress() {
        return _emailaddress;
    }

    public ArrayList<String> getLanguages() {
        return _languages;
    }
    public void setLanguages(List<String> newLanguages) {
        // Si la liste des langues actuelle est nulle, initialiser une nouvelle ArrayList
        if (this._languages == null) {
            this._languages = new ArrayList<>();
        }

        // Ajouter chaque nouvelle langue à la liste s'il n'y est pas déjà présent pour éviter les doublons
        for (String language : newLanguages) {
            if (!this._languages.contains(language)) {
                this._languages.add(language);
            }
        }
    }
    //endregion public methods
}