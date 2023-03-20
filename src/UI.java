import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UI {
    private List<Person> personList;
    public void input_num(FamilyTree tree, WriteAndRead writeAndRead) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case (1):
                System.out.println(writeAndRead.read().getInfo());
                break;
            case (2):
                System.out.println("Введите имя человека");
                String name = sc.next();
                for (Person person : writeAndRead.read()) {
                    if (person.getName().equals(name)) {
                        System.out.println(person.getInfo());
                    }
                }
                break;
//            case (3):
//                System.out.println(writeAndRead.read().getInfo());
//                break;
            case (4):
                int index = sc.nextInt();
                for (int i = 0; i<writeAndRead.read().size(); i++) {
                    tree.remove(index);
                }
                writeAndRead.write(tree);
                break;
        }
        tree.sortPeopleByName();
    }
}
