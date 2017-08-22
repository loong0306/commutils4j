package u4list;

import com.git.comm.utils.u4list.ListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dragon on 8/22/2017.
 */
public class U4ListTest {

    ListUtils listUtils = new ListUtils();

    @Test
    public void test(){
        // 判断集合是否为空
        List<String> stringList = new ArrayList<String>();
        System.out.println(listUtils.isEmpty(stringList));
        stringList.add("has");
        System.out.println(listUtils.isEmpty(stringList));
    }
}
