package hashCode用法;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HashMapTest other = (HashMapTest) obj;
        if (i != other.i)
            return false;
        return true;
    }

    public static void main(String[] args) {
        HashMapTest a = new HashMapTest();
        HashMapTest b = new HashMapTest();
        a.setI(5);
        b.setI(5);

        HashMap<HashMapTest, String> map = new HashMap<HashMapTest, String>();
        String s1 = map.put(a, "测试1");

        String s2 = map.put(b, "测试2");

        System.out.println("s1=" + s1 + ",s2=" + s2);

        System.out.println("a=" + a + ",b=" + b);
        System.out.println("a的hashCode=" + a.hashCode() + ",b的hashCode=" + b.hashCode());
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        /**
         * 为什么map.get(a)等于"测试2" 原因:当我们调用put()方法时，首先对key进行hash值。hash值对应着存放元素的位置
         * 如果该位置不存放着其他的元素，增加添加元素即可 如果该位置存放着其他的元素，那么这个位置上的元素将以链表的形式存放，
         * 新加入的元素放在链头，最先加入的元素放链尾
         */

        Iterator<Map.Entry<HashMapTest, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {

            Map.Entry<HashMapTest, String> entry = iter.next();

            HashMapTest key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key=" + key + ",value=" + value);

        }

    }

}
