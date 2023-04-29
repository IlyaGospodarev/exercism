class ReverseString {

    String reverse(String inputString) {
        StringBuilder res = new StringBuilder(inputString);
        return String.valueOf(res.reverse());
    }
}
