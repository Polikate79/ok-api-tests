package models;

import lombok.Builder;
import lombok.Setter;

@Builder
public class OkRequest {

    private String url;
    private String applicationKey;
    private String counterTypes;
    @Builder.Default
    private String format = "json";
    private String groupId;
    @Builder.Default
    private String method = "group.getCounters";
    @Setter
    private String sig;
    private String sessionKey;

    @Override
    public String toString() {
        return url +
                "?application_key=" + applicationKey +
                "&counterTypes=" + counterTypes +
                "&format=" + format +
                "&group_id=" + groupId +
                "&method=" + method +
                "&sig=" + sig +
                "&session_key=" + sessionKey;
    }
}
