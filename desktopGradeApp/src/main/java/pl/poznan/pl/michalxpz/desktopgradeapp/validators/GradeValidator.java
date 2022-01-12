package pl.poznan.pl.michalxpz.desktopgradeapp.validators;

import pl.poznan.pl.michalxpz.desktopgradeapp.exceptions.InvalidGradeRangeException;
import pl.poznan.pl.michalxpz.desktopgradeapp.exceptions.InvalidNumberFormatException;

public class GradeValidator {
    public static Integer parseGrade(String value) throws InvalidNumberFormatException, InvalidGradeRangeException {
        try {
            Integer gradeInt = Integer.parseInt(value);
            if (gradeInt < 2 || gradeInt > 5) throw new InvalidGradeRangeException();
            return gradeInt;
        } catch (NumberFormatException exception) {
            throw new InvalidNumberFormatException();
        }
    }
}
