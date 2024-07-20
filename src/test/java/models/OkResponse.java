package models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class OkResponse {

    @SerializedName("counters")
    private Counters counters;
}
