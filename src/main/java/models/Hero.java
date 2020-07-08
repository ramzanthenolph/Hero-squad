package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private static List<Hero> heroList = new ArrayList<>();
    private int heroId;
    private String squadAssemble;
    private static boolean duplicate = false;

    public Hero(String name, int age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        findDuplicateHero(this);

        if (duplicate) {
            System.out.println("Duplicate Hero!!");
        } else {
            heroList.add(this);
            this.heroId = heroList.size();
            this.squadAssemble = "";
        }
    }

    public String getName() {
        return name;
    }
    public String getPower(){
        return power;
    }
    public String getWeakness(){
        return weakness;
    }
    public int getAge(){
        return age;
    }
    public String getSquadAssemble() {
        return squadAssemble;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public void setSquadAlliance(String squadAlliance) {
        this.squadAssemble = squadAssemble;
    }

    public static List<Hero> getHeroList() {
        return heroList;
    }
    public static Hero findHero(int searchID) {
        return heroList.get(searchID - 1);
    }
    private static void findDuplicateHero(Hero newInsertion) {
        for (Hero hero : heroList) {
            if (newInsertion.name.equalsIgnoreCase(hero.name) &&
                    newInsertion.power.equalsIgnoreCase(hero.power) &&
                    newInsertion.weakness.equalsIgnoreCase(hero.weakness)) {
                duplicate = true;
                break;
            } else if (newInsertion.name.equalsIgnoreCase(hero.name)) {
                duplicate = true;
                break;
            }
        }
    }
    public void updateSquad(String newSquad) {
        this.squadAssemble = newSquad;
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public void updateAge(int newAge) {
        this.age = newAge;
    }

    public void updatePower(String newPower) {
        this.power = newPower;
    }

    public void updateWeakness(String newWeakness) {
        this.weakness = newWeakness;
    }

    public static void deleteHero(int searchID) {
        Hero heroToDelete = findHero(searchID);
        if (!heroToDelete.getSquadAssemble().equals("")) {
            // IF this hero is in a squad, remove him from squad first
            Squad currentSquad = null;
            String currentSquadName = heroToDelete.getSquadAssemble();
            for (Squad squad : Squad.getAllSquads()) {
                if (squad.getSquadName().equalsIgnoreCase(currentSquadName)) {
                    currentSquad = squad;
                    break;
                }
            }
            assert currentSquad != null;
            currentSquad.removeMember(heroToDelete);
        }
        heroList.remove(searchID - 1);
    }

    public static void clearHeroRegistry(){
        heroList.clear();
    }


}
