import java.io.*;
import java.lang.invoke.VolatileCallSite;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        WriteAndRead writeAndRead = new WriteAndRead();
        View view = new View();
        UI ui = new UI();

        view.print_command();
        ui.input_num(tree, writeAndRead);

    }
}