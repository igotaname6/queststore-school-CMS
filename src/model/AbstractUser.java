package model;

public abstract class AbstractUser {
    private String name;
    private String surname;
    private String email;
    private String password;

    public AbstractUser(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return String.format("%s %s", this.name, this.surname);
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
