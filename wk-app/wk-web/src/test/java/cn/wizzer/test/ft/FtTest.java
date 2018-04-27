package cn.wizzer.test.ft;

import org.junit.Test;
import org.nutz.lang.Strings;

public class FtTest {

    @Test
    public void testValueOfLong(){
        String abc = "555";
        System.out.println(Long.valueOf(Strings.sNull(abc)));
    }
}
