package model;

public class Reader {
    private final int id;
    private final String firstName;
    private final String secondName;

    public Reader(int id, String firstName, String secondName) {
        if (firstName == null || secondName == null) {
            throw new NullPointerException("Reader names cannot be null.");
        }

        firstName = firstName.strip();
        secondName = secondName.strip();

        if (firstName.isEmpty() || secondName.isEmpty()) {
            throw new IllegalArgumentException("Reader names cannot be empty");
        }

        if (!firstName.matches("[\\p{L}\\p{M} '-’]+")
                || !secondName.matches("[\\p{L}\\p{M} '-’]+")) {
            throw new IllegalArgumentException(
                    "Names can contain only letters, spaces, hyphens, and apostrophes."
            );
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Reader ID must be positive.");
        }

        if (firstName.length() < 2 || secondName.length() < 2) {
            throw new IllegalArgumentException(
                    "Names must contain at least 2 characters."
            );
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

    public String getFullName() {
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

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
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
