import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UI {
    public void input_num(FamilyTree tree, WriteAndRead writeAndRead) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case (1):
                System.out.println(writeAndRead.read().getInfo());
                System.out.println("Введите следующее действие");
                input_num(tree, writeAndRead);
                break;
            case (2):
                System.out.println("Введите имя человека");
                String name = sc.next();
                for (Person person : writeAndRead.read()) {
                    if (person.getName().equals(name)) {
                        System.out.println(person.getInfo());
                    }
                }
                System.out.println("Введите следующее действие");
                input_num(tree, writeAndRead);
                break;
            case (3):
                System.out.println("Введите имя человека");
                String nameNew = sc.next();
                System.out.println("Введите пол человека");
                String gender = sc.next();
                System.out.println("Введите имя папы");
                String fatherName = sc.next();
                System.out.println("Введите имя мамы");
                String motherName = sc.next();
                tree.add(new Person(fatherName, "Мужчина"));
                tree.add(new Person(motherName, "Женщина"));
                tree.add(new Person(nameNew, gender, tree.getByName(fatherName), tree.getByName(motherName)));
                tree.sortPeopleByName();
                writeAndRead.write(tree);
                System.out.println("Запись добавлена");
                System.out.println("Введите следующее действие");
                input_num(tree, writeAndRead);
                break;
            case (4):
                System.out.println("Введите имя человека которого хотите удалить");
                String removeName = sc.next();
                for (Person person : writeAndRead.read()) {
                    if (!person.getName().equals(removeName)) {
                        tree.add(person);
                    }
                }
                tree.sortPeopleByName();
                writeAndRead.write(tree);
                System.out.println("Запись удалена");
                System.out.println("Введите следующее действие");
                input_num(tree, writeAndRead);
               break;
            case (5):
                System.out.println("Досвидание!");
                break;
        }
    }
}
