package vinova.henry.com.mvpretrofituser.features.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dminh on 1/31/2018.
 */

public class Address {
    @SerializedName("streetA")
    @Expose
    private String streetA;
    @SerializedName("streetB")
    @Expose
    private String streetB;
    @SerializedName("streetC")
    @Expose
    private String streetC;
    @SerializedName("streetD")
    @Expose
    private String streetD;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("geo")
    @Expose
    private Geo geo;

    public String getStreetA() {
        return streetA;
    }

    public void setStreetA(String streetA) {
        this.streetA = streetA;
    }

    public String getStreetB() {
        return streetB;
    }

    public void setStreetB(String streetB) {
        this.streetB = streetB;
    }

    public String getStreetC() {
        return streetC;
    }

    public void setStreetC(String streetC) {
        this.streetC = streetC;
    }

    public String getStreetD() {
        return streetD;
    }

    public void setStreetD(String streetD) {
        this.streetD = streetD;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
