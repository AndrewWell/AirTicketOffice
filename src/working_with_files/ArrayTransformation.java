package working_with_files;

public class ArrayTransformation {
    private String[] data;
    private String[][] result;

    public ArrayTransformation(String[] data) {
        this.data = data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String[][] transformation() {
        result = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i].split("\\|");
        }
        return result;
    }
}
