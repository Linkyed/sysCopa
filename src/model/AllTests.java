package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArbitroDAOTest.class, SelecaoDAOTest.class, TecnicoDAOTest.class })
public class AllTests {

}
