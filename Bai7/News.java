import java.util.List;

public class News implements INews {
    public int ID;
    public String Title;
    public String PublishDate;
    public String Author;
    public String Content;
    public float AverageRate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public float getAverageRate() {
        return AverageRate;
    }

    @Override
    public void Display() {
        System.out.println(this.Title);
        System.out.println(this.PublishDate);
        System.out.println(this.Author);
        System.out.println(this.Content);
        System.out.println(this.AverageRate);
    }

    int [] RateList = new int[3];

    public void Calculate(){
        int total = 0;
        for (int i = 0; i < RateList.length; i++) {
            total+=RateList[i];

        }
        this.AverageRate = total/3;
    }
}
