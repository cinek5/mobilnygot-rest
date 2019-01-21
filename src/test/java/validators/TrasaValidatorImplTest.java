package validators;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.validators.TrasaValidator;
import com.example.cinek.validators.TrasaValidatorImpl;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Cinek on 20.01.2019.
 */

public class TrasaValidatorImplTest {
    @Test
    public void test_Should_Return_True_When_Trasa_Has_More_Than_2_Punkty()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();

        SkladowyPunktTrasy skladowyPunktTrasy = new SkladowyPunktTrasy();
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy();
        SkladowyPunktTrasy skladowyPunktTrasy3 = new SkladowyPunktTrasy();

        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy, skladowyPunktTrasy2, skladowyPunktTrasy3));

        //when
        boolean hasValidPunktySize = trasaValidator.hasValidPunktySize(trasaPunktowana);

        //then
        assertTrue(hasValidPunktySize);

    }
    @Test
    public void test_Should_Return_True_When_Trasa_Has_Exactly_2_Punkty()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();

        SkladowyPunktTrasy skladowyPunktTrasy = new SkladowyPunktTrasy();
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy();
        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy, skladowyPunktTrasy2));

        //when
        boolean hasValidPunktySize = trasaValidator.hasValidPunktySize(trasaPunktowana);

        //then
        assertTrue(hasValidPunktySize);

    }
    @Test
    public void test_Should_Return_False_When_Trasa_Has_Less_Than_2_Punkty()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();

        SkladowyPunktTrasy skladowyPunktTrasy = new SkladowyPunktTrasy();

        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy));

        //when
        boolean hasValidPunktySize = trasaValidator.hasValidPunktySize(trasaPunktowana);

        //then
        assertFalse(hasValidPunktySize);

    }

    @Test
    /** Trasa has valid punkty order, when punkty can be put in natural order, eg 1, 2, 3 ,4
     * It's not valid when there are more than 1 punkt with same position eg. 1,1,3,4**/
    public void test_Should_Return_True_When_Trasa_Has_Valid_Punkty_Order()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        SkladowyPunktTrasy skladowyPunktTrasy = new SkladowyPunktTrasy();
        skladowyPunktTrasy.setKolejnoscPunktu(1);
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy();
        skladowyPunktTrasy2.setKolejnoscPunktu(2);
        SkladowyPunktTrasy skladowyPunktTrasy3 = new SkladowyPunktTrasy();
        skladowyPunktTrasy3.setKolejnoscPunktu(3);
        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy,skladowyPunktTrasy2, skladowyPunktTrasy3 ));
        //when
        boolean hasValidOrder = trasaValidator.hasValidPunktyOrder(trasaPunktowana);

        //then
        assertTrue(hasValidOrder);
    }
    @Test
    public void test_Should_Return_False_When_Trasa_Has_2_Punkty_With_Same_Order()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        SkladowyPunktTrasy skladowyPunktTrasy = new SkladowyPunktTrasy();
        skladowyPunktTrasy.setKolejnoscPunktu(1);
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy();
        skladowyPunktTrasy2.setKolejnoscPunktu(1);
        SkladowyPunktTrasy skladowyPunktTrasy3 = new SkladowyPunktTrasy();
        skladowyPunktTrasy3.setKolejnoscPunktu(3);
        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy,skladowyPunktTrasy2, skladowyPunktTrasy3 ));
        //when
        boolean hasValidOrder = trasaValidator.hasValidPunktyOrder(trasaPunktowana);

        //then
        assertFalse(hasValidOrder);
    }

    @Test
    public void test_Should_Return_False_When_Trasa_Has_Gap_In_Order()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        SkladowyPunktTrasy skladowyPunktTrasy = new SkladowyPunktTrasy();
        skladowyPunktTrasy.setKolejnoscPunktu(1);
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy();
        skladowyPunktTrasy2.setKolejnoscPunktu(3);
        SkladowyPunktTrasy skladowyPunktTrasy3 = new SkladowyPunktTrasy();
        skladowyPunktTrasy3.setKolejnoscPunktu(4);
        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy,skladowyPunktTrasy2, skladowyPunktTrasy3 ));
        //when
        boolean hasValidOrder = trasaValidator.hasValidPunktyOrder(trasaPunktowana);

        //then
        assertFalse(hasValidOrder);
    }

    @Test
    public void test_Should_Return_True_When_Trasa_Has_Same_Grupa_As_Punkty()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        GrupaGorska grupaGorska = new GrupaGorska(1l, "Testowa");
        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        trasaPunktowana.setGrupaGorska(grupaGorska);

        SkladowyPunktTrasy skladowyPunktTrasy1 = new SkladowyPunktTrasy();
        PunktTrasy punktTrasy1 = new PunktTrasy();
        punktTrasy1.setGrupaGorska(grupaGorska);
        skladowyPunktTrasy1.setPunktTrasy(punktTrasy1);

        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy();
        PunktTrasy punktTrasy2 = new PunktTrasy();
        punktTrasy2.setGrupaGorska(grupaGorska);
        skladowyPunktTrasy2.setPunktTrasy(punktTrasy2);

        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy1,skladowyPunktTrasy2 ));
        //when
        boolean hasPunktySameGrupaAsTrasa = trasaValidator.hasPunktySameGrupaAsTrasa(trasaPunktowana);

        //then
        assertTrue(hasPunktySameGrupaAsTrasa);

    }

    @Test
    public void test_Should_Return_False_When_Trasa_Has_Different_Grupa_As_Punkty()
    {
        //given
        TrasaValidator trasaValidator = new TrasaValidatorImpl();

        GrupaGorska grupaGorskaPunkt = new GrupaGorska(1l, "Testowa");
        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        trasaPunktowana.setGrupaGorska(new GrupaGorska(2l, "trasa"));

        SkladowyPunktTrasy skladowyPunktTrasy1 = new SkladowyPunktTrasy();
        PunktTrasy punktTrasy1 = new PunktTrasy();
        punktTrasy1.setGrupaGorska(grupaGorskaPunkt);
        skladowyPunktTrasy1.setPunktTrasy(punktTrasy1);

        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy();
        PunktTrasy punktTrasy2 = new PunktTrasy();
        punktTrasy2.setGrupaGorska(grupaGorskaPunkt);
        skladowyPunktTrasy2.setPunktTrasy(punktTrasy2);

        trasaPunktowana.setSkladowePunktyTrasy(asList(skladowyPunktTrasy1,skladowyPunktTrasy2 ));
        //when
        boolean hasPunktySameGrupaAsTrasa = trasaValidator.hasPunktySameGrupaAsTrasa(trasaPunktowana);

        //then
        assertFalse(hasPunktySameGrupaAsTrasa);

    }
}
