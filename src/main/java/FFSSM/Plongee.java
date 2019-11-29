/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Set<Licence> palanquee = new HashSet<>();

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        palanquee.add(participant.derniereLicence());
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
        boolean result = true;
        for (Licence l : palanquee) {
            if (!l.estValide(date)) {
                result = false;
            }
        }
        return result;
    }

}
