package dz_do_practic_2;

public class Ex1 {
    public static void main(String[] args) {
        double usdAmount = 250.0;
        final double EXCHANGE_RATE = 41.25;
        final double COMMISSION_PERCENT = 1.5;

        double totalUah = usdAmount * EXCHANGE_RATE;
        double commissionUah = totalUah * COMMISSION_PERCENT / 100.0;
        double netAmountUah = totalUah - commissionUah;
        long cashAmountUah = Math.round(netAmountUah);

        String receipt = "================ КВИТАНЦІЯ ОБМІНУ ================\n"
                + String.format("Сума до обміну:             %.2f USD%n", usdAmount)
                + String.format("Курс валют:                 %.2f UAH/USD%n", EXCHANGE_RATE)
                + String.format("Нараховано до комісії:      %.2f UAH%n", totalUah)
                + String.format("Комісія банку (%.1f%%):       %.2f UAH%n", COMMISSION_PERCENT, commissionUah)
                + "--------------------------------------------------\n"
                + String.format("Чиста сума до видачі:       %.2f UAH%n", netAmountUah)
                + "До видачі готівкою:         " + cashAmountUah + " UAH\n"
                + "==================================================";

        System.out.println(receipt);
    }
}
