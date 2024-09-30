package items;

public class Item {

    public static int TYPE_WEAPON = 0;

    public String name;
    public String description;
    public int type;

    public Item(String name, String description, int type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getTypeWeapon() {
        return TYPE_WEAPON;
    }

    public static void setTypeWeapon(int typeWeapon) {
        TYPE_WEAPON = typeWeapon;
    }
}
