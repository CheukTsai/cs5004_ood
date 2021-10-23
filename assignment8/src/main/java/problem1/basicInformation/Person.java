package problem1.basicInformation;

import java.util.Objects;

/**
 * A class that represents a person info.
 */
public class Person {

    private String firstName;
    private String lastName;
    private String companyName;
    private String address;
    private String city;
    private String county;
    private String state;
    private String zip;
    private String phone1;
    private String phone2;
    private String email;
    private String web;

    /**
     * A constructor that create a new object of Person.
     *
     * @param firstName   - String, firstName
     * @param lastName    - String, lastName
     * @param companyName - String, companyName
     * @param address     - String, address
     * @param city        - String, city
     * @param county      - String, county
     * @param state       - String, state
     * @param zip         - String, zip
     * @param phone1      - String, phone1
     * @param phone2      - String, phone2
     * @param email       - String, email
     * @param web         - String, web
     */
    public Person(String firstName, String lastName, String companyName, String address,
        String city, String county, String state, String zip, String phone1, String phone2,
        String email, String web) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zip = zip;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.web = web;
    }

    /**
     * Return firstName
     *
     * @return String, firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return lastName
     *
     * @return String, lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return company name
     *
     * @return String, company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Return address
     *
     * @return String, address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Return city
     *
     * @return String, city
     */
    public String getCity() {
        return city;
    }

    /**
     * Return county
     *
     * @return, String, county
     */
    public String getCounty() {
        return county;
    }

    /**
     * Return state
     *
     * @return String, state
     */
    public String getState() {
        return state;
    }

    /**
     * Return zip
     *
     * @return String, zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Return phone1
     *
     * @return String, phone1
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * Return phone2
     *
     * @return String, phone2
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * Return email
     *
     * @return String, email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Return web
     *
     * @return String, web
     */
    public String getWeb() {
        return web;
    }

    /**
     * {@inheritDoc} Indicates whether some other object passed as an argument is "equal to" the
     * current instance.
     *
     * @param o - an object to compare
     * @return boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) && Objects
            .equals(getLastName(), person.getLastName()) && Objects
            .equals(getCompanyName(), person.getCompanyName()) && Objects
            .equals(getAddress(), person.getAddress()) && Objects
            .equals(getCity(), person.getCity()) && Objects
            .equals(getCounty(), person.getCounty()) && Objects
            .equals(getState(), person.getState()) && Objects.equals(getZip(), person.getZip())
            && Objects.equals(getPhone1(), person.getPhone1()) && Objects
            .equals(getPhone2(), person.getPhone2()) && Objects
            .equals(getEmail(), person.getEmail()) && Objects.equals(getWeb(), person.getWeb());
    }

    /**
     * {@inheritDoc} Returns an integer representation of the object memory address.
     *
     * @return int, hash code
     */
    @Override
    public int hashCode() {
        return Objects
            .hash(getFirstName(), getLastName(), getCompanyName(), getAddress(), getCity(),
                getCounty(),
                getState(), getZip(), getPhone1(), getPhone2(), getEmail(), getWeb());
    }

    /**
     * {@inheritDoc} Returns an String representation of the object
     *
     * @return int hash code
     */
    @Override
    public String toString() {
        return "Person{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", companyName='" + companyName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", county='" + county + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            ", phone1='" + phone1 + '\'' +
            ", phone2='" + phone2 + '\'' +
            ", email='" + email + '\'' +
            ", web='" + web + '\'' +
            '}';
    }
}
