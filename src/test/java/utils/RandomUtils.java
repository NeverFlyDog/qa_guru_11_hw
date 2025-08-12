package utils;

public class RandomUtils {

    public static String getRandomEmail() {
        return null;
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Generates formatted random phone number.
     *
     * @return phone number formatted as +7 (xxx) xxx-xx-xx
     */
    public static String getRandomPhone() {
        return String.format(
                "+7 (%s) %s-%s-%s",
                getRandomIntInRange(100, 999),
                getRandomIntInRange(10, 99),
                getRandomIntInRange(10, 99),
                getRandomIntInRange(10, 99)
        );
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    private static String getRandomItemFromArray(String[] array) {
        return array[getRandomIntInRange(0, array.length - 1)];
    }
}
