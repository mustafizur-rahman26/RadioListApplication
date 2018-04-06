package app.sveriges.radio.com;

/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public class Environment {

    public static long CACHE_MAX_LIFETIME_IN_MILLIS = 5 * 1000;

    // Default values (PRODUCTION)
    public static boolean showLog = false;
    public static boolean useSnackbar = true;
    public static String BASE_API_URL = "http://api.sr.se/";
    public static String PROGRAM_API_URL = "http://api.sr.se/api/v2/programs?format=json&size=40/";

    private static Type type = Type.DEVELOP;

    public static void configure() {
        switch (type) {
            case DEVELOP:
                showLog = true;
                useSnackbar = true;
                PROGRAM_API_URL = "http://api.sr.se/api/v2/programs?format=json&size=40/";
                break;
            case PREPRODUCTION:
                showLog = true;
                useSnackbar = true;
                PROGRAM_API_URL = "http://api.sr.se/api/v2/programs?format=json&size=40/";
                break;
            case PRODUCTION:
                showLog = false;
                useSnackbar = true;
                PROGRAM_API_URL = "http://api.sr.se/api/v2/programs?format=json&size=40/";
                break;
        }
    }

    public enum Type {
        DEVELOP,
        PREPRODUCTION,
        PRODUCTION
    }
}
