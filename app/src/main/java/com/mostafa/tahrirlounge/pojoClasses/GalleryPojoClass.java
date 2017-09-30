package com.mostafa.tahrirlounge.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mostafa on 9/16/2017.
 */

public class GalleryPojoClass {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gallery")
    @Expose
    private List<String> gallery = null;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

}


