import javax.swing.*;

public class RealImage implements ImageInterface {
    private final String file;//добавила final
    private ImageIcon image;

    public ImageIcon getImage() {
        return image;
    }

    public RealImage(String file) {
        this.file = file;
        this.load();
    }

    @Override
    public void display() {
        System.out.println("Просмотр");
    }

    public void load(){
        System.out.println("Загрузка");
        image = new ImageIcon(file);

    }

}