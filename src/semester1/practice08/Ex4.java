package semester1.practice08;

public final class Ex4 {
  private Ex4() {}

  static class CardWallet {
    private String cardNumber, pinCode;
    private double balance;

    CardWallet(String cardNumber, String pinCode, double balance) {
      if (cardNumber == null || !cardNumber.matches("\\d{16}"))
        throw new IllegalArgumentException("Номер картки має містити 16 цифр");
      this.cardNumber = cardNumber;
      this.pinCode = pinCode;
      this.balance = Math.max(0, balance);
    }

    public boolean changePin(String oldPin, String newPin) {
      if (!pinCode.equals(oldPin) || newPin == null || !newPin.matches("\\d{4}")) return false;
      pinCode = newPin;
      return true;
    }

    @Override
    public String toString() {
      return String.format(
          "CardWallet{card='**** **** **** %s', balance=%.2f UAH}",
          cardNumber.substring(cardNumber.length() - 4), balance);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 04 ---%n");

    CardWallet wallet = new CardWallet("1234567812344589", "1234", 12500);
    System.out.println(wallet);
    System.out.println("PIN updated: " + wallet.changePin("1234", "9876"));
  }
}
