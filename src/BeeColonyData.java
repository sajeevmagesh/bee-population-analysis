
public class BeeColonyData {
    private String state;
    private int januaryColonies;
    private int maximumColonies;
    private int lostColonies;
    private double percentLost;
    private int addedColonies;
    private int renovatedColonies;
    private double percentRenovated;

    public BeeColonyData(String state, int januaryColonies, int maximumColonies, int lostColonies, double percentLost, int addedColonies, int renovatedColonies, double percentRenovated) {
        this.state = state;
        this.januaryColonies = januaryColonies;
        this.maximumColonies = maximumColonies;
        this.lostColonies = lostColonies;
        this.percentLost = percentLost;
        this.addedColonies = addedColonies;
        this.percentRenovated = percentRenovated;
    }

    // Getters
    public String getState() {
        return state;
    }

    public int getJanuaryColonies() {
        return januaryColonies;
    }

    public int getMaximumColonies() {
        return maximumColonies;
    }

    public int getLostColonies() {
        return lostColonies;
    }

    public double getPercentLost() {
        return percentLost;
    }

    public int getAddedColonies() {
        return addedColonies;
    }

    public int getRenovatedColonies() {
        return renovatedColonies;
    }

    public double getPercentRenovated() {
        return percentRenovated;
    }
}
