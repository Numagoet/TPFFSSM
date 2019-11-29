package FFSSM;

import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmazoyer
 */
public class FFSSMtest {

    Personne p;
    Club c;
    Moniteur m;

    public void setUp() {
        p = new Personne("1 31 05 85", "Mazoyer", "Justin", null, null, null);
        c = new Club(null, "Castres", null);
        m = new Moniteur("1 31 05 85", "Charbonnier", "Gaétan", null, null, null,5);
    }

    @Test
    public void testLicenceValide() {
        Calendar delivrance = Calendar.getInstance();
        Licence l = new Licence(p, "10", delivrance, 0, c);
        assertTrue(l.estValide(delivrance));

        Calendar unMoisApres = (Calendar) delivrance.clone();
        unMoisApres.add(Calendar.MONTH, 1);
        assertTrue(l.estValide(unMoisApres));

        Calendar unAnApres = (Calendar) delivrance.clone();
        unAnApres.add(Calendar.YEAR, 1);
        assertTrue(l.estValide(unAnApres));

    }

    @Test
    public void testLicenceInvalide() {
        Calendar delivrance = Calendar.getInstance();
        Licence l = new Licence(p, "10", delivrance, 0, c);
        Calendar d = (Calendar) delivrance.clone();
        d.add(Calendar.YEAR, 1);
        d.add(Calendar.DAY_OF_YEAR, 1);
        assertFalse(l.estValide(d));
        Calendar d2 = (Calendar) delivrance.clone();
        d2.add(Calendar.DAY_OF_YEAR, -1);
        assertFalse(l.estValide(d2));
    }
    @Test
    public void COnformitéPlongée(){
        Calendar delivrance = Calendar.getInstance();
        Calendar d = (Calendar) delivrance.clone();
        d.add(Calendar.YEAR, -2);
        Licence l = new Licence(p, "10", delivrance, 0, c);
        Licence l2 = new Licence(p, "10", d, 0, c);
        Site site =new Site("Castres","ISIS");
        Plongee plongee= new Plongee(site,m,delivrance,300,60);
        Plongeur plongeur1 = new Plongeur("1 31 05 85", "Mazoyer", "Justin", null, null, null,l);
        Plongeur plongeur = new Plongeur("1 31 05 85", "Mazoyer", "Justin", null, null, null,l2);
        plongee.ajouteParticipant(plongeur1);
        assertTrue(plongee.estConforme());
        plongee.ajouteParticipant(plongeur);
        assertFalse(plongee.estConforme());
    }

}
