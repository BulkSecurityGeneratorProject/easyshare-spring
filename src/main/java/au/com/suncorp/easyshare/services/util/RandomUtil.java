package au.com.suncorp.easyshare.services.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Utility class for generating random Strings.
 */

public final class RandomUtil {

    private RandomUtil() {
    }

    /**
     * Generates a password.
     *
     * @return the generated password
     */
    public static String generateString(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static String generateInt(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

}
