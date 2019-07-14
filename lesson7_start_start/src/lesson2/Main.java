package lesson2;


public class Main {

    public static void main(String[] args){
        SQLData sqlData = new SQLData();
        sqlData.connect();
        sqlData.sqlSelect();
        System.out.println("---------------------");
        sqlData.sqlInsert("Дмитрий", "Сальман", "Александрович", "1997-01-25", "разработчик");
        System.out.println("---------------------");
        sqlData.sqlInsert("Павел", "Сальман", "Викторович", "1997-01-25", "главный бухгалтер");
        System.out.println("---------------------");
        sqlData.sqlUpdate(5,"Марина", "Павлова", "Сергеевна", "1991-02-25", "кассир");
        System.out.println("---------------------");
        sqlData.sqlDelete(11);
        System.out.println("---------------------");
        sqlData.sqlSelect();
    }
}
