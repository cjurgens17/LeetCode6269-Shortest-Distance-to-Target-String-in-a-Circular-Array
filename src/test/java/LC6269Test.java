import static org.junit.Assert.*;

public class LC6269Test {

    @org.junit.Test
    public void closetTarget() {
        int actual1 = LC6269.closetTarget(new String[] {"hello","i","am","leetcode","hello"},"hello", 1);
        int actual2 = LC6269.closetTarget(new String[] {"a","b","leetcode"}, "leetcode", 0);
        int actual3 = LC6269.closetTarget(new String[] {"i","eat","leetcode"}, "ate", 0);

        assertEquals(1,actual1);
        assertEquals(1,actual2);
        assertEquals(-1,actual3);
    }
}