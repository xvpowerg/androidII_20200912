package tw.com.xvpower.testlistviewbig;

import androidx.annotation.NonNull;

public class TestData {
    private String text1;
    private String text2;
    private String text3;
    private int image;

    public TestData(String text1, String text2, String text3, int image) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.image = image;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public int getImage() {
        return image;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
