package model;

import java.util.Objects;

public class Reader {
    private final int id;
    private String firstName;
    private String secondName;

    public Reader(int id, String firstName, String secondName) {
        if (firstName == null || secondName == null) {
            throw new NullPointerException();
        }

        if (id < 0 || firstName.length() <= 1 || secondName.length() <= 1) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String fullName() {
        return secondName + " " + firstName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Reader other = (Reader) obj;

        return this.id == other.id &&
                this.firstName.equals(other.firstName) &&
                this.secondName.equals(other.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName);
    }

    @Override
    public String toString() {
        return "Reader {" +
                "id = " + id +
                ", firstName = " + firstName +
                ", secondName = " + secondName +
                "}";
    }
}
