package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Counters {
    @SerializedName("themes")
    private Integer themes;
    @SerializedName("photo_albums")
    private Integer photoAlbums;
    @SerializedName("videos")
    private Integer videos;
    @SerializedName("links")
    private Integer links;
    @SerializedName("presents")
    private Integer presents;
    @SerializedName("moderators")
    private Integer moderators;
    @SerializedName("members")
    private Integer members;
    @SerializedName("join_requests")
    private Integer joinRequests;
    @SerializedName("black_list")
    private Integer blackList;
    @SerializedName("maybe")
    private Integer maybe;
    @SerializedName("photos")
    private Integer photos;
}
