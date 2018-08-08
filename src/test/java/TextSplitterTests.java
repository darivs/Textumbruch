import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class TextSplitterTests {

    @Parameterized.Parameters(name = " {1} at {0}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {6, "123567", "123456" + System.lineSeparator() + "7"},
                {3, "123456", "123" + System.lineSeparator() + "456"},
                {6, "123456", "123456"}
        });
    }

    private final TextSplitter textSplitter = new TextSplitter();

    private int width;
    private String text;
    private String expected;

    public TextSplitterTests(int width, String text, String expected) {
        this.width = width;
        this.text = text;
        this.expected = expected;
    }

    @Test
    public void split() {
        String textWithLinebreaks = textSplitter.breakTextAfterWidth(text, width);

        assertThat(textWithLinebreaks).isEqualTo(expected);
    }

}