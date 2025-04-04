package com.github.diegopacheco.proper.oop.media.three;

import java.util.Map;
import java.util.Objects;

/**
 *  This is the Elegant Objects Approach
 *
 *  IMHO is very similar to spring RowMapper
 *
 *  If you realize, Profile is only being coupled with a Media interface.
 *  Profile has no coupling with media implementations.
 *  In fact profile does not know what the media is
 *  if is json, xml, csv, etc.
 */
public class Profile {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String xProfile;
    private String facebookProfile;

    public Profile(String name, String email, String phone, String address, String xProfile, String facebookProfile) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.xProfile = xProfile;
        this.facebookProfile = facebookProfile;
    }

    //
    // The bad thing with Maps is that is not strongly typed
    // However we can make this more generic and dynamic
    // because now we are only coupling with java standard collection(Map)
    //
    // Need to be careful with this for other use cases. But now we are not even coupled with Media.
    // Map acts an Intermediate Object like a Generic DTO.
    //
    public Map<String,String> toMap(){
            Map<String,String> media = new java.util.HashMap<>();
            media.put("name", name);
            media.put("email", email);
            media.put("phone", phone);
            media.put("address", address);
            media.put("xProfile", xProfile);
            media.put("facebookProfile", facebookProfile);
            return media;
    };

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name) && Objects.equals(email, profile.email) && Objects.equals(phone, profile.phone) && Objects.equals(address, profile.address) && Objects.equals(xProfile, profile.xProfile) && Objects.equals(facebookProfile, profile.facebookProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone, address, xProfile, facebookProfile);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", xProfile='" + xProfile + '\'' +
                ", facebookProfile='" + facebookProfile + '\'' +
                '}';
    }
}
