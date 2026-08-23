package comparator;

import model.Reader;

import java.util.Comparator;

public class ReaderFirstNameComparator implements Comparator<Reader> {
    @Override
    public int compare(Reader reader1, Reader reader2) {
        return reader1.getFirstName().compareTo(reader2.getFirstName());
    }
}
