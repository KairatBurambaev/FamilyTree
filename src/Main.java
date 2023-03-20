import java.io.*;
import java.lang.invoke.VolatileCallSite;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        WriteAndRead writeAndRead = new WriteAndRead();
        View view = new View();
        UI ui = new UI();

        tree.add(new Person("Максим", "Мужчина"));
        tree.add(new Person("Мария", "Женщина"));
        tree.add(new Person("Денис", "Мужчина", tree.getByName("Максим"),  tree.getByName("Мария")));
        tree.add(new Person("Евгения", "Женщина", tree.getByName("Максим"),  tree.getByName("Мария")));
        tree.add(new Person("Дмитрий", "Мужчина", tree.getByName("Максим"),  tree.getByName("Мария")));

        tree.sortPeopleByName();
        writeAndRead.write(tree);

        view.print_command();
        ui.input_num(tree, writeAndRead);


//        System.out.println(writeAndRead.read().getInfo());
    }
}