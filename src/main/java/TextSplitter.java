class TextSplitter {

    String breakTextAfterWidth(String textToBreak, int width) {
        StringBuilder breakedText = new StringBuilder();

        char[] chars = textToBreak.toCharArray();
        for (int i = 1; i < chars.length + 1; i++) {
            breakedText.append(chars[i - 1]);

            if (i % width == 0 && i != chars.length) {
                breakedText.append(System.lineSeparator());
            }
        }

        return breakedText.toString();
    }

}