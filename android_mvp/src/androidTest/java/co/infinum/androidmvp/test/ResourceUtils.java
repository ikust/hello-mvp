package co.infinum.androidmvp.test;

import java.io.InputStream;

/**
 * Utility methods for accessing resources bundled with test APK. Standard Android Resources don't seem to work for test APK
 * (unable to fetch R.java).
 * <p>
 * Resources should be placed under /resources/mockdata folder in androidTest flavour. Use {@link #readFromFile(String)} to read a text
 * file to String giving only a name of the file located in /resources/mockdata folder.
 */
public class ResourceUtils {

    private static final String MOCK_DATA_DIRECTORY = "mockdata/%s";

    /**
     * Converts InputStream to String.
     *
     * @param is
     * @return
     */
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * Reads a resource file to <code>String</code>.
     *
     * @param filename
     * @return
     */
    public static String readFromFile(String filename) {
        InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(String.format(MOCK_DATA_DIRECTORY, filename));
        return convertStreamToString(is);
    }
}
