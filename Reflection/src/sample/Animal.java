
package sample;

/**
 *
 * @author user
 */
public final class Animal {

    public static int animalsCount = 0;

    public int age = 56;
    public String type = "Собака";
    public boolean isMale = true;
    private String name = "some animal";

    public Animal()
    {

        System.out.println("constructor called");
        animalsCount++;
    }

    public Animal(String name)
    {
        System.out.println("constructor 2 called");
        setName(name);
        animalsCount++;
    }

    public void produceSound()
    {
        System.out.println(name + " produces SOUND!!!");
    }
    public void produceSound(String s)
    {
        System.out.println(name + " produces SOUND " + s);
    }
    public void produceSound(String s, String s2)
    {
        System.out.println(name + " produces SOUND " + s + " " + s2);
    }

    /**
     * @return the name
     */
    public String getName() {

        System.out.println("GETTING NAME");
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}