import org.testng.annotations.*;

public class TestNgbasics {


    @BeforeSuite
    public void Bsuite(){
        System.out.println("Before suite");
    }

    @BeforeTest
    public void Btest(){
        System.out.println("Before test");
    }

    @BeforeClass
    public void Bclass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void Bmethod(){
        System.out.println("Before method");
    }

    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }

    @AfterSuite
    public void Asuite(){
        System.out.println("After suite");
    }

    @AfterTest
    public void Atest(){
        System.out.println("After test");
    }

    @AfterClass
    public void Aclass(){
        System.out.println("After class");
    }

    @AfterMethod
    public void Amethod(){
        System.out.println("After method");
    }
}
