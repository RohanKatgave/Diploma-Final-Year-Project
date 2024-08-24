package rakesh.project.mapsproject;

public class User {

    public String name,id,phone,latitude,longitude,date;

    public User() {
    }

    public User(String name, String id, String phone, String latitude, String longitude,String date) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getDate() {return date;}
}
