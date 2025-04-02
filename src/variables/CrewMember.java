package variables;


import entity.Crew;

public class CrewMember implements Crew {
    private String fullName,licenseNumber,jobTitle;
    private int flightHours;

    public CrewMember(String fullName, String licenseNumber, int flightHours, String jobTitle) {
        this.fullName = fullName;
        this.licenseNumber = licenseNumber;
        this.flightHours = flightHours;
        this.jobTitle = jobTitle;
    }
    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public int getFlightHours() {
        return flightHours;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString(){
        return fullName+"|"+licenseNumber+"|"+flightHours+"|"+jobTitle;
    }
}
