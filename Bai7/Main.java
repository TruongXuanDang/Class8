import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<News> arrayNews= new ArrayList<News>();
        int flag = 0;
        do{
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    News newNews = createNews();

                    arrayNews.add(newNews);
                    break;
                case 2:
                    for (int i = 0; i < arrayNews.size(); i++) {
                        arrayNews.get(i).Display();
                    }
                    break;
                case 3:
                    for (int i = 0; i < arrayNews.size(); i++) {
                        arrayNews.get(i).Calculate();
                        arrayNews.get(i).Display();
                    }
                    break;
                case 4:
                    flag = 1;
                    break;
            }
        }
        while(flag ==0);

    }

    public static News createNews (){
        News newNews = new News();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        newNews.Title = scanner.nextLine();
        System.out.println("Publish Date: ");
        newNews.PublishDate = scanner.nextLine();
        System.out.println("Author: ");
        newNews.Author = scanner.nextLine();
        System.out.println("Content: ");
        newNews.Content = scanner.nextLine();

        for (int i = 0; i < newNews.RateList.length; i++) {
            System.out.println("Ky tu thu "+(i+1));
            newNews.RateList[i] = scanner.nextInt();
        }
        
        return newNews;
    }

}
