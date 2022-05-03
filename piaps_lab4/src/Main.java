public class Main {

    public static void main(String[] args) {
        ImageInterface image = new ProxxyImage("C:/piaps_lab4/src/images.jpg");
        Frame frame = new Frame(image);
    }
}