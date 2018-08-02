package eugenebo.com.github.criminalintent.model;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID id;
    private String crimeTitle;
    private Date crimeDate;
    private boolean crimeSolved;

    public Crime() {
        id = UUID.randomUUID();
        crimeDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getCrimeTitle() {
        return crimeTitle;
    }

    public void setCrimeTitle(String crimeTitle) {
        this.crimeTitle = crimeTitle;
    }

    public Date getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(Date crimeDate) {
        this.crimeDate = crimeDate;
    }

    public boolean isCrimeSolved() {
        return crimeSolved;
    }

    public void setCrimeSolved(boolean crimeSolved) {
        this.crimeSolved = crimeSolved;
    }
}
