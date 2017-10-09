package u4entity;

import com.git.comm.utils.u4entity.EntityUtils;
import org.junit.Test;

/**
 * Created by dragon on 10/4/2017.
 */
public class U4EntityTest {

    @Test
    public void test(){
        // 将dto映射为实体类
        Dto dto = new Dto();
        dto.setName("testName");
        dto.setAge("11");
        dto.setSex("man");
        dto.setPhone("133333");
        dto.setEmail("123@123.123");
        System.out.println(EntityUtils.dtoToEntity(dto, new Person()).toString());
    }
}
