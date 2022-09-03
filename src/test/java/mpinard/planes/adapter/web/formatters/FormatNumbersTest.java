package mpinard.planes.adapter.web.formatters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FormatNumbersTest {

    @Test
    public void When_FormatWithMillions_Expect_FormattedWithCommas() {
        assertThat(FormatNumbers.formatWithCommas(3_769_495)).isEqualTo("3,769,495");
    }

}