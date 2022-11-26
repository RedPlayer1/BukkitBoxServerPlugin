package redplayer1.rp1.Commands;

public class dataobject {
    
    String name;
    int age;
    boolean hasJob;

    public dataobject(String name, int age, boolean hasJob){
        this.name = name;
        this.age = age;
        this.hasJob = hasJob;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasJob() {
        return hasJob;
    }

    @Override
    public String toString() {
        return "name: "+name+" age: "+age+" hasJob: "+hasJob;
    }
}
