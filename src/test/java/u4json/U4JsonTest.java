package u4json;

import com.alibaba.fastjson.JSON;
import com.git.comm.utils.u4json.WrapMapper;
import com.git.comm.utils.u4json.Wrapper;
import org.junit.Test;
import u4entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dragon on 8/23/2017.
 */
public class U4JsonTest {

    @Test
    public void test(){
        // String - List
        List<String> stringList = new ArrayList<String>();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
        Wrapper<List<String>> wrapString = WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, stringList);
        System.out.println("wrapString = " + wrapString.getResult());

        // Object - Person
        Person person = new Person();
        person.setName("dragon");
        person.setAge("22");
        person.setSex("man");
        Wrapper<Person> wrapPerson = WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, person);
        System.out.println("wrapPerson = " + wrapPerson.getResult());

        // Object - Person - List
        List<Person> personList = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setName("dragon");
        person1.setAge("22");
        person1.setSex("man");
        personList.add(person1);
        Person person2 = new Person();
        person2.setName("loong");
        person2.setAge("18");
        person2.setSex("man");
        personList.add(person2);
        Wrapper<List<Person>> wrapPersonList = WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, personList);
        System.out.println("wrapPersonList = " + wrapPersonList.getResult());
    }
}
