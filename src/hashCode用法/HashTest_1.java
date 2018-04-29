package hashCode用法;

import java.util.HashSet;
import java.util.Set;

public class HashTest_1 {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {

        return i % 10;
    }

    public static void main(String[] args) {
        HashTest_1 a = new HashTest_1();
        HashTest_1 b = new HashTest_1();
        a.setI(5);
        b.setI(5);
        Set<HashTest_1> set = new HashSet<HashTest_1>();
        set.add(a);
        set.add(b);
        /**
         * 输出结果 第一个肯定是相等的，他们的hash值都等于5
         * 第二个肯定不相等，因为没有重写equals()方法，默认是父类java.lang.object类的equals方法()，
         * 只是判断2个变量所引用的对象是否相等，肯定不相等，所以返回false
         * 
         */
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
    }

}
