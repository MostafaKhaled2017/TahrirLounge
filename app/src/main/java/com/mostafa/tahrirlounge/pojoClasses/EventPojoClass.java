package com.mostafa.tahrirlounge.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mostafa on 9/16/2017.
 */

public class EventPojoClass {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("eventName")
    @Expose
    private String eventName;
    @SerializedName("eventImage")
    @Expose
    private String eventImage;
    @SerializedName("eventInstractor")
    @Expose
    private String eventInstractor;
    @SerializedName("eventDetails")
    @Expose
    private String eventDetails;
    @SerializedName("eventDate")
    @Expose
    private String eventDate;
  /*  @SerializedName("instractorImage")
    @Expose
    private String instractorImage;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventInstractor() {
        return eventInstractor;
    }

    public void setEventInstractor(String eventInstractor) {
        this.eventInstractor = eventInstractor;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

  /*  public String getInstractorImage() {
        return instractorImage;
    }

    public void setInstractorImage(String instractorImage) {
        this.instractorImage = instractorImage;
    }
*/
}


