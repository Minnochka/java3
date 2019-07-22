package lesson3.test3;


import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        boolean is_exit = false;
        while(!is_exit) {
            System.out.println("Книга 'Властелин колец. Братство кольца.'\n\nВыберите действие:\n1. Оглавление.\n2.Выход.");
            switch (sc.nextInt()) {
                case 1:
                    tableOfContents();
                    break;
                case 2:
                    is_exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }

    private static void tableOfContents()  throws FileNotFoundException, IOException{
        System.out.println("Оглавление:\n");
        String path = "src/lesson3/test3";
        File file = new File(path);
        String[] files = file.list(new FilenameFilter(){
            @Override public boolean accept(File folder, String name) {
                return name.endsWith(".txt");
            }
        });
        for(int i = 0; i < files.length; i++){
            System.out.println((files[i].substring(0,files[i].length() - 4).replace("_"," ")));
        }
        System.out.println("Выберите главу или нажмите 0 для выхода:");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        while(res > file.length() || res < 0){
            System.out.println("Неверный выбор. Попробуйте еще раз.");
            res = sc.nextInt();
        }
        if(res == 0){
            return;
        }
        else{
            CheckPageNumber(path + "/" + files[res - 1]);
        }
    }

    public static void CheckPageNumber(String fileName)  throws FileNotFoundException, IOException{
        HashMap<Integer,String> pageList = readPages(fileName);
        System.out.println("Кол-во страниц: " + pageList.size() + "\nВведите номер страницы или нажмите 0 для выхода:");
        Scanner sc = new Scanner(System.in);
        int currentPage = sc.nextInt();
        while(currentPage != 0){
            if(currentPage > pageList.size()){
                System.out.println("Неверный выбор. Попробуйте еще раз.");
                System.out.println("Кол-во страниц: " + pageList.size() + "\nВведите номер страницы или нажмите 0 для выхода:");
                currentPage = sc.nextInt();
            }
            else {
                System.out.println("----------------------------------------------------");
                System.out.println(pageList.get(currentPage));
                System.out.println("----------------------------------------------------");
                if (currentPage > 1) {
                    System.out.println("1. Предыдущая страница.");
                }
                if (currentPage < pageList.size()) {
                    System.out.println("2. Следующая страница.");
                }
                System.out.println("0. Выход.");
                switch (sc.nextInt()) {
                    case 1:
                        if(currentPage == 1){
                            System.out.println("Неверный выбор. Попробуйте еще раз.");
                        }
                        else {
                            currentPage--;
                        }
                        break;
                    case 2:
                        if(currentPage == pageList.size()){
                            System.out.println("Неверный выбор. Попробуйте еще раз.");
                        }
                        else {
                            currentPage++;
                        }
                        break;
                    case 0:
                        currentPage = 0;
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте еще раз.");
                        break;
                }
            }
        }
    }

    public static HashMap<Integer,String> readPages(String fileName) throws FileNotFoundException, IOException {
        HashMap<Integer,String> pageList = new HashMap<Integer,String>();
        RandomAccessFile raFile =new RandomAccessFile(fileName, "r");
        raFile.seek(0);
        int currentPoint = 0, pageNum = 1, delta;
        int readSize, size = 1800, currentSize;
        byte[] arr = new byte[size];
        while (true){
            delta = size;
            if((readSize = raFile.read(arr)) > 0){
                //System.out.println(readSize);
                //System.out.println(new String(arr, 0, readSize));
                if(readSize < size){
                    pageList.put(pageNum,new String(arr, 0, readSize));
                    break;
                }
                else{
                    for(int j = readSize - 1; j >= 0; j--){
                        //System.out.println("'" + arr + "'");
                        if(arr[j] == ' ' || arr[j] == '\n'){
                            //System.out.println("delta" + delta);
                            pageList.put(pageNum,new String(arr, 0, delta - 1));//arr.toString().substring(0,delta - 1));
                            currentPoint += delta;
                            raFile.seek(currentPoint);
                            break;
                        }
                        else{
                            delta--;
                        }
                    }
                }
                //System.out.println("pageNum: " + pageNum );
                pageNum++;
            }
            else{
                break;
            }
        }
        //System.out.println("Finish");
        raFile.close();
        return pageList;
    }
}
