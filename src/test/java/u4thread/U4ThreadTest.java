package u4thread;

import com.git.comm.utils.u4thread.ThreadLocalMap;
import org.junit.*;

/**
 * Created by dragon on 12/8/2017.
 */
public class U4ThreadTest {

    @BeforeClass
    public static void beforeClass() {
        ThreadLocalMap.put("BeforeClass", "This is BeforeClass");
        System.out.println(ThreadLocalMap.get("BeforeClass"));
    }

    @Before
    public void before() {
        ThreadLocalMap.put("Before", "This is Before");
        System.out.println(ThreadLocalMap.get("Before"));
    }

    @Test
    public void test() {
        ThreadLocalMap.put("Test", "This is Test");
        System.out.println(ThreadLocalMap.get("Test"));
    }

    @After
    public void after() {
        ThreadLocalMap.put("After", "This is After");
        System.out.println(ThreadLocalMap.get("After"));
    }

    @AfterClass
    public static void afterClass() {
        ThreadLocalMap.reset();
        System.out.println(ThreadLocalMap.get("BeforeClass"));
        System.out.println(ThreadLocalMap.get("Before"));
        System.out.println(ThreadLocalMap.get("Test"));
        System.out.println(ThreadLocalMap.get("After"));

    }
}
