package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private String cause;
    private static boolean isRegisteredHero = false;
    private List<Hero> heroMembers = new ArrayList<>();
    private static List<Squad> squadList = new ArrayList<>();
    private int squadId;
    private boolean isSquadFull = false;

    public Squad(String squadName,String cause, Hero hero) {
        this.squadName = squadName;
        this.cause = cause;
        crossCheckHero(hero.getHeroId());

        if (isRegisteredHero) {
            hero.setSquadAlliance(squadName);
            heroMembers.add(hero);
            squadList.add(this);
            this.squadId = squadList.size();
        } else {
            System.out.println("Your Hero isn't registered");
        }
    }

    public String getSquadName() {
        return squadName;
    }
    public int getSquadId() {
        return squadId;
    }

    public void addMembers(Hero hero) {
        if (heroMembers.size() >= 3) {
            isSquadFull = true;
        } else {
            heroMembers.add(hero);
        }
    }

    public boolean getSquadFull() {
        return isSquadFull;
    }

    public List<Hero> getMembers() {
        return heroMembers;
    }

    public String getCause() {
        return cause;
    }
    public void changeHeroSquad(Hero hero, Squad newSquad) {
        if (heroMembers.size() >= 3) {
            isSquadFull = true;
        } else {
            Squad currentSquad = null;
            for (Squad squad : squadList) {
                if (hero.getSquadAssemble().equalsIgnoreCase(squad.squadName)) {
                    currentSquad = squad;
                    break;
                }
            }

            for (Squad squad : squadList) {
                if (newSquad.squadName.equalsIgnoreCase(squad.squadName)) {
                    if (!hero.getSquadAssemble().equalsIgnoreCase("")) {
                        //IF HERO EXISTED IN PREVIOUS SQUAD
                        //noinspection ConstantConditions
                        currentSquad.heroMembers.remove(hero);
                        newSquad.heroMembers.add(hero);
                        hero.updateSquad(newSquad.squadName);
                        break;
                    } else {
                        //IF HERO HAD NO ALLIANCE
                        newSquad.heroMembers.add(hero);
                        hero.setSquadAlliance(newSquad.squadName);
                    }
                } else {
                    System.out.println("Squad Doesn't exist");
                }
            }
        }
    }

}
