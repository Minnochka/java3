package lesson2;


public class Main {

    public static void main(String[] args){
        SQLData sqlData = new SQLData();
        sqlData.connect();
        sqlData.sqlCreate();
        sqlData.sqlSelect();
        System.out.println("---------------------");
        sqlData.sqlInsert("Дмитрий", "Вольф", "Александрович", "1997-01-25", "разработчик");
        System.out.println("---------------------");
        sqlData.sqlInsert("Дмитрий", "Вольф", "Александрович", "1997-01-25", "кассир");
        System.out.println("---------------------");
        sqlData.sqlInsert("Олег", "Свидригайлов", "Владимирович", "1978-07-15", "главный бухгалтер");
        System.out.println("---------------------");
        sqlData.sqlInsert("Виктория", "Литовская", "Романовна", "1996-09-08", "главный бухгалтер");
        System.out.println("---------------------");
        sqlData.sqlInsert("Елена", "Ровалинская", "Андреевна", "1988-04-13", "секретарь");
        System.out.println("---------------------");
        sqlData.sqlInsert("Марина", "Павлова", "Сергеевна", "1991-02-25", "кассир");
        System.out.println("---------------------");
        sqlData.sqlInsert("Станислав", "Крапивин", "Георгиевич", "1984-05-15", "кассир");
        System.out.println("---------------------");
        sqlData.sqlInsert("Валерий", "Серов", "Юрьевич", "1977-01-04", "генеральный директор");
        System.out.println("---------------------");
        sqlData.sqlInsert("Алексей", "Гришин", "Андреевич", "1994-02-09", "финансовый директор");
        System.out.println("---------------------");
        sqlData.sqlSelect();
        System.out.println("---------------------");
        sqlData.sqlInsert("Дмитрий", "Сальман", "Александрович", "1997-01-25", "разработчик");
        System.out.println("---------------------");
        sqlData.sqlInsert("Павел", "Сальман", "Викторович", "1997-01-25", "главный бухгалтер");
        System.out.println("---------------------");
        sqlData.sqlUpdate(5,"Марина", "Павлова", "Сергеевна", "1991-02-25", "кассир");
        sqlData.sqlDelete(1);
        sqlData.sqlSelect();
        sqlData.sqlDrop();
    }
}
