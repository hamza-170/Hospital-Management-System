public class Person
{
    private String id;
    private String name;
    private int age;


    Person(String name,int age)
    {
        this.age=age;
        this.name=name;
    }

    Person(String id,String name,int age)
    {
        this.id=id;
        this.age=age;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }



}
