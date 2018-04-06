package app.sveriges.radio.com.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */

public class Programs {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("programimage")
    public String image;

    @SerializedName("programurl")
    public String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Programs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
