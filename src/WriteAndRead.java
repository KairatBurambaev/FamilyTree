import java.io.*;

public class WriteAndRead {
    FamilyTree trent = new FamilyTree();
    public void write(FamilyTree tree) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("File.out"));
        out.writeObject(tree);
        out.close();
    }
    public FamilyTree read() throws IOException, ClassNotFoundException  {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("File.out"));
        trent = (FamilyTree) in.readObject();
        in.close();
        return trent;
    }
}