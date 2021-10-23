/**
 * Represents an Author with their details--name, email and physical address
 *
 * @author therapon
 *
 */
public class Author {
    private Name name;
    private String email;
    private Address address;
    /**
     * Creates a new author given the author's name, email and address as strings.
     *
     * @param name the author's name
     * @param email the author's email address
     * @param address the authors physical address
     */
    public Author(Name name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
    /**
     * @return the name
     */
    public Name getName() {
        return name;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }
}

