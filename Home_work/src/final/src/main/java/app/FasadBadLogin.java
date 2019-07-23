package app;

import Pages.Main;
import app.XmlOperation.FasadGetXml;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class FasadBadLogin {


    private static int pass = 2;
    private static int login = 3;
    private int description = 4;

    private static final Logger log = Logger.getLogger(FasadBadLogin.class);



    public static void setBadLogin(int Namd, String typeError) throws ParserConfigurationException, XMLStreamException, SAXException, IOException {

        Main main = new Main();
        DBOperation dbOperation = new DBOperation();
        Applitoolse applitoolse = new Applitoolse();

        int bdId = Namd + 1;
        int xmlId = Namd - 1;

        applitoolse.setEyes("loginTest", "fail login "+ Namd);
        main.openMailru();
        applitoolse.skrinshot("step1");
        log.info("step 1 " + FasadGetXml.getDataFromXml().get(xmlId).getStep1());
        main.enterLiginAndPass(dbOperation.Get(bdId, login), dbOperation.Get(bdId, pass));
        applitoolse.skrinshot("step2");
        main.loginInMailru();
        log.info("step 2 " + FasadGetXml.getDataFromXml().get(xmlId).getStep2());

        if (typeError == "type1")
            Assert.assertTrue(main.loginIsFailed());

      if (typeError == "type2")
            Assert.assertTrue(main.loginIsFailed2());
        applitoolse.skrinshot("step3");
        log.info("step 3 " + FasadGetXml.getDataFromXml().get(xmlId).getStep3());
        applitoolse.closeEyes();
        singeltonDriver.closeBrowser();


    }


}
