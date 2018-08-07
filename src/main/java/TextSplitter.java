public class TextSplitter {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String breakTextAfterWidth(String textToBreak, int width) {
        int numberOfNeededLineBreaks = Math.round(textToBreak.length() / width);
        StringBuilder breakedText = new StringBuilder(textToBreak);

        for (int i = 1; i <= numberOfNeededLineBreaks; i++) {
            breakedText.insert((width * i) + i - 1, LINE_SEPARATOR);
        }

        return breakedText.toString();
    }
}
