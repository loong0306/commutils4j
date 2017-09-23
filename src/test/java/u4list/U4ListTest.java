package u4list;

import com.git.comm.utils.u4list.ListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dragon on 8/22/2017.
 */
public class U4ListTest {

    @Test
    public void test(){
        // 判断集合是否为空
        List<String> stringList = new ArrayList<String>();
        System.out.println(ListUtils.isEmpty(stringList));
        stringList.add("has");
        System.out.println(ListUtils.isEmpty(stringList));

        // 拆分list，按500条拆分
        List<String> strings =  new ArrayList<String>();
        for (int i = 0; i < 1000; i++){
            strings.add(String.valueOf(i));
        }
        System.out.println(ListUtils.splitList(strings));
    }
}
