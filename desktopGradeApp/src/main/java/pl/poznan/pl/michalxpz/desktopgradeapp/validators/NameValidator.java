package pl.poznan.pl.michalxpz.desktopgradeapp.validators;

import pl.poznan.pl.michalxpz.desktopgradeapp.exceptions.InvalidNameAndSurnameException;

public class NameValidator {
    public static String parseName(String name) throws InvalidNameAndSurnameException {
        if (!name.contains(" ") || name.split(" ").length < 2) throw new InvalidNameAndSurnameException();
        return name;
    }
}
