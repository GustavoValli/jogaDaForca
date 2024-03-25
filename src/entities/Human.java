package entities;

public class Human {

    private Integer lifePoints;

    public Human(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }

    protected void lostLife(Integer lifePoints) {
        this.lifePoints -= lifePoints;
    }

    protected Integer getLifePoints() {
        return lifePoints;
    }
}
