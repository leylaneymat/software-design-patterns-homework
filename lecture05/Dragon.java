package lecture05;

public class Dragon implements Cloneable {

    private String name;
    private int health;
    private String texturePath;
    private boolean textureLoaded;

    public Dragon(String name, int health, String texturePath) {
        this.name = name;
        this.health = health;
        this.texturePath = texturePath;
    }

    public void loadTexture() {
        System.out.println("Loading texture: " + texturePath);
        textureLoaded = true;
    }

    public void attack() {
        System.out.println(name + " attacks");
    }

    @Override
    public Dragon clone() {
        try {
            return (Dragon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}