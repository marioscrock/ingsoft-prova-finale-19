public class MusicCD extends Product {

    private String artist;
    private String label;

    public MusicCD(String title, String artist, String label, double price) {
        super(title, price);
        this.artist = artist;
        this.label = label;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + artist + ", " + label;
    }

}
