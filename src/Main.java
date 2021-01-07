import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        is = new  FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0){
            os.write(buffer,0,length);
        }
        is.close();
        os.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập đường dẫn :");
        String sourcePath = sc.nextLine();
        System.out.println("Nhập đường dẫn lưu file : ");
        String destPath = sc.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile,destFile);
//            copyFileUsingJava7Files(sourceFile,destFile);
            System.out.println("Hoàn thành ");
        }catch (IOException ioe){
            System.out.println("Không thể copy file");
            System.out.println(ioe.getMessage());
        }

    }
}
