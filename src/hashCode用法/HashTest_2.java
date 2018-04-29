package hashCode用法;

import java.util.HashSet;
import java.util.Set;

public class HashTest_2 {

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
        HashTest_2 other = (HashTest_2) obj;
        if (i != other.i)
            return false;
        return true;
    }

    public static void main(String[] args) {
        HashTest_2 a = new HashTest_2();
        HashTest_2 b = new HashTest_2();
        a.setI(5);
        b.setI(5);
        Set<HashTest_2> set = new HashSet<HashTest_2>();
        set.add(a);
        set.add(b);
        System.out.println("a的hashCode=" + a.hashCode() + ",b的hashCode=" + b.hashCode());
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);

    }

}
