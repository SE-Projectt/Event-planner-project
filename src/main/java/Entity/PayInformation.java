package Entity;

public class PayInformation {
    public class Payinformation {
        private String CardNumber;
        private String CardNameOwner;
        private String CVC;

        public Payinformation() {
            CardNumber = "12345678";
            CardNameOwner = "*";
            CVC="1234";
        }
        public Payinformation(String cardNumber,String cardNameOwner,String cVC) {
            CardNumber = cardNumber;
            CardNameOwner = cardNameOwner;
            CVC=cVC;
        }

        public void setCardNumber(String cardNumber) {
            CardNumber = cardNumber;
        }

        public void setCardNameOwner(String cardNameOwner) {
            CardNameOwner = cardNameOwner;
        }

        public void setCVC(String CVC) {
            this.CVC = CVC;
        }

        public String getCardNumber() {
            return CardNumber;
        }

        public String getCardNameOwner() {
            return CardNameOwner;
        }

        public String getCVC() {
            return CVC;
        }
        @Override
        public String toString() {
            return "PayInformation{" +
                    "CardNumber=" + CardNumber +
                    ", CardNameOwner='" + CardNameOwner + '\'' +
                    ", CVC=" + CVC +
                    '}';
        }
    }
}
