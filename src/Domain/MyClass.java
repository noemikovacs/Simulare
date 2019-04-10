package Domain;

public class MyClass {

    String id, name, date, duration,startDate;


    public MyClass(String id, String name, String date, String duration, String startDate) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.startDate = startDate;
    }
    

    @Override
    public String toString() {
        return "MyClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", duration='" + duration + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
