package grammar;

/**
 * @Description: 人
 * @Author: Tu-Yi
 * @Created: 2021/03/12 12:48
 */
public class Person implements Comparable<Person> {

    private String nameString;
    private int age;
    private String sex;
    public String getNameString() {
        return nameString;
    }
    public void setNameString(String nameString) {
        this.nameString = nameString;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Person(String nameString, int age, String sex) {
        super();
        this.nameString = nameString;
        this.age = age;
        this.sex = sex;
    }
    public Person() {
        super();
    }

    public int compareTo(Person o) {
        return this.age - o.age;
    }
    @Override
    public String toString() {

        return (this.nameString + "\t" + this.age);
    }
}
