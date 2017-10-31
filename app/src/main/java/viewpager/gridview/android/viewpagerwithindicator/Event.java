package viewpager.gridview.android.viewpagerwithindicator;

public class Event {

    public String IncidentID;
    public String IncidentName;
    public String color;
    public String iconUrl;

    public Event(String incidentID, String incidentName, String color, String iconUrl) {
        IncidentID = incidentID;
        IncidentName = incidentName;
        this.color = color;
        this.iconUrl = iconUrl;
    }

    public String getIncidentID() {
        return IncidentID;
    }

    public String getIncidentName() {
        return IncidentName;
    }

    public String getColor() {
        return color;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
