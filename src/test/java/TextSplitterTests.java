import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

public class TextSplitterTests {
    private TextSplitter textSplitter = new TextSplitter();

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String TEXT_TO_BREAK = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int WIDTH = 6;

    @Test
    public void splitter_inserts_linebreaks_and_as_much_as_needed() {
        int expectedLinebreaks = 4;

        String breakedText = textSplitter.breakTextAfterWidth(TEXT_TO_BREAK, WIDTH);

        assertThat(occurrencesOfLinebreaks(breakedText)).isEqualTo(expectedLinebreaks)
                                                        .isGreaterThan(0);
    }

    @Test
    public void splitter_inserts_linebreaks_at_right_position() {
        List<String> rows = asList(textSplitter.breakTextAfterWidth(TEXT_TO_BREAK, WIDTH).split(LINE_SEPARATOR));

        Condition<String> shorterThanSix = new Condition<>(row -> row.length() <= 6, "row length should be as wide as given width (6)");

        assertThat(rows).are(shorterThanSix);
    }

    private int occurrencesOfLinebreaks(String breakedText) {
        int numberOfActualLineBreaks = (breakedText.split(LINE_SEPARATOR, -1).length) - 1;

        return numberOfActualLineBreaks;
    }
}
