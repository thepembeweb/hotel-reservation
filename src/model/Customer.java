package model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        validateEmail(email);
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validateEmail(String email) {
        Matcher matcher = Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}(.[a-z]{2,3})+$|^$",
                Pattern.CASE_INSENSITIVE).matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Email is invalid");
        }
    }

    @Override
    public String toString() {
        return String.format("Customer\nfirstName=%s\nlastName=%s\nemail=%s\n", firstName, lastName, email);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Customer))
            return false;

        Customer otherCustomer = (Customer)o;

        boolean firstNameEquals = (this.firstName == null && otherCustomer.firstName == null)
                || (this.firstName != null && this.firstName.equals(otherCustomer.firstName));
        boolean lastNameEquals = (this.lastName == null && otherCustomer.lastName == null)
                || (this.lastName != null && this.lastName.equals(otherCustomer.lastName));
        boolean emailEquals = (this.email == null && otherCustomer.email == null)
                || (this.email != null && this.email.equals(otherCustomer.email));

        return firstNameEquals && lastNameEquals && emailEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (firstName != null) {
            result = 31 * result + firstName.hashCode();
        }
        if (lastName != null) {
            result = 31 * result + lastName.hashCode();
        }
        if (email != null) {
            result = 31 * result + email.hashCode();
        }
        return result;
    }

}
