package constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiConstants {

    public static final String ENDPOINT_URL = "https://api.ok.ru/fb.do";
    public static final String APPLICATION_KEY = "CNDCAKLGDIHBABABA";
    public static final String FORMAT = "json";
    public static final String GROUP_ID = "70000003750183";
    public static final String METHOD = "group.getCounters";
    public static final String SESSION_KEY = "-n-ODuWIkOsyAqrK0PN0af1Du096uv9NCWnXOnNGuqTCNwW9oaLMzPBaHbm2BFbK8407tvvHLHS9ve42ruEl1";
    public static String SIG_MATCHER = "application_key=%scounterTypes=%sformat=%sgroup_id=%smethod=%ssession_key=%s%s";
}
