package team.service;


public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
        {"10", "1", "Tom", "22", "3000"},
        {"13", "2", "Jack", "32", "18000", "15000", "2000"},
        {"11", "3", "Emma", "23", "7000"},
        {"11", "4", "James", "24", "7300"},
        {"12", "5", "Lucas", "28", "10000", "5000"},
        {"11", "6", "Ava", "22", "6800"},
        {"12", "7", "Amelia", "29", "10800","5200"},
        {"13", "8", "Henry", "30", "19800", "15000", "2500"},
        {"12", "9", "Mia", "26", "9800", "5500"},
        {"11", "10", "Noah", "21", "6600"},
        {"11", "11", "Elijah", "25", "7100"},
        {"12", "12", "Evelyn", "27", "9600", "4800"}
    };
    
    //One-to-one correspondence with the above EMPLOYEES array elements
    //PC      :21, model, display
    //NoteBook:22, model, price
    //Printer :23, type, name
    public static final String[][] EQUIPMENTS = {
        {},
        {"22", "LenovoT4", "6000"},
        {"21", "Dell", "NEC17\""},
        {"21", "Dell", "Samsung17\""},
        {"23", "InkJet", "Canon2900"},
        {"21", "Asus", "Samsung17\""},
        {"21", "Asus", "Samsung17\""},
        {"23", "Matrix", "Epson20K"},
        {"22", "HP m6", "5800"},
        {"21", "Dell", "NEC17\""},
        {"21", "Asus","Samsung17\""},
        {"22", "HP m6", "5800"}
    };
}
