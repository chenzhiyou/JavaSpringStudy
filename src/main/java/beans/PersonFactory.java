package beans;

public class PersonFactory {
    public Person createPersonFactoryMethod(){
        Child child = new Child();
        child.setName("hhh");
        return child;
    }
}
