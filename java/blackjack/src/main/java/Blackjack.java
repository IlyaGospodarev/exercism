public class Blackjack {

    public int parseCard(String card) {
        
        return switch(card) {
            case "ace" -> 11;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            case "ten", "jack", "queen", "king" -> 10;
            default -> 0;
        };
    }

    public boolean isBlackjack(String card1, String card2) {
        
        return parseCard(card1) + parseCard(card2) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {

        return isBlackjack && dealerScore < 10 ? "W" : "S";
    }

    public String smallHand(int handScore, int dealerScore) {

        if(handScore >= 17) {
            return "S";
        } else if (handScore <= 11) {
            return "H";
        } else if ((handScore >= 12 && handScore <= 16) && dealerScore >= 7) {
            return "H";
        } else return "S";
    }

    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (handScore > 21) {
           return "P";
        }

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
