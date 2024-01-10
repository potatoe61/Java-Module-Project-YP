public class Formatter {

    public static String formatAmount(double amount) {
        String currency = "рубль";
        int rubles = (int) amount;
        if (rubles == 0 || rubles >= 5 && rubles <= 20 || rubles % 10 >= 5 || rubles % 10 == 0 || rubles % 100 >= 11 && rubles % 100 <= 19) {
            currency = "рублей";
        } else if (rubles % 10 == 1) {
            currency = "рубль";
        } else if (rubles % 10 >= 2 && rubles % 10 <= 4) {
            currency = "рубля";
        }
        return String.format("%.2f %s", amount, currency);
    }
}
