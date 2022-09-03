package mpinard.planes.adapter.web.formatters;

import lombok.experimental.UtilityClass;

import java.text.NumberFormat;
import java.util.Locale;

@UtilityClass
public class FormatNumbers {

    public static String formatWithCommas(int value) {
        return NumberFormat.getInstance(Locale.US).format(value);
    }

}
