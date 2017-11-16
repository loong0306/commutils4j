package u4object;

import com.git.comm.utils.u4object.ObjectUtils;
import org.junit.Test;
import u4entity.Person;

/**
 * Created by dragon on 11/16/2017.
 */
public class U4ObjectTest {

    @Test
    public void test() {
        Person person = new Person();
        person.setName("dragon");
        person.setAge("22");
        person.setSex("man");
        ObjectUtils.getSonFromObject(person);
    }
}
