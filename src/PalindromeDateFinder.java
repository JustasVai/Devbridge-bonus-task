public class PalindromeDateFinder {
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int year = fromYear; year <= toYear; year++) {
            if (isLeapYear(year)) {
                daysPerMonth[2] = 29;
            } else {
                daysPerMonth[2] = 28;
            }
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= daysPerMonth[month]; day++) {
                    if (isPalindromeDate(year, month, day))
                        System.out.println(String.format("%04d-%02d-%02d", year, month, day));
                }
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static boolean isPalindromeDate(int year, int month, int day) {
        String date = String.format("%04d%02d%02d", year, month, day);
        String reversedDate = new StringBuilder(date).reverse().toString();

        return date.equals(reversedDate);
    }
}
