
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

//

public class fichier {

    public enum file_default {
        Emploi("src/edt.csv"),
        liste_Etudiant("src/etus.csv");

        private String path;

        file_default(String p){
            this.path=p;
        }
        public String toString(){
            return this.path;
        }

    }

    public static String FileToString(String path) throws IOException{
        String s="";
       File  file= new File(path.toString());
       Scanner inputStream =new Scanner(file);
       while(inputStream.hasNext()){
           String data =inputStream.next();
           s=s.concat(data);
       }
       inputStream.close();
       return s;
    }

    public static String[][] SplitFile(String path) throws Exception {
        String s = FileToString(path.toString());
        String[] ss = s.split("\n"); // TODO: test the \n
        String[][] sss = new String[ss.length][];
        for(int i = 0; i < ss.length; i++){
            sss[i] = ss[i].split(";");
        }
        return sss;
    }


    //afficher le fichier sous sa forme originale
    static void afficher(String path) throws IOException {
        String s = FileToString(path.toString());
        String[] ss = s.split("\n");// TODO: test the \n
        for(int i = 0; i < ss.length; i++){
            System.out.println(ss[i]+";");// TODO: delete the last character ;
        }
    }

    static void writefile(String path) throws IOException {
        String s="";
        File  file= new File(path.toString());
        System.out.println("Veuillez saisir ton emploi du temps ou t'as liste d'étudiants :");
        Scanner inputStream =new Scanner(System.in);
        String data =inputStream.next();
        s=s.concat(data);
        FileWriter f = new FileWriter(path.toString());
        f.write(s);
        f.close();
        inputStream.close();


    }

    public static void main(String[] argv) throws Exception {
    /*String s;
    s=FileToString(fichier.file_default.Emploi.toString());
        try {
            String[][] tab=SplitFile(file_default.Emploi.toString());
            for(int i=0;i<tab.length;i++) {
                for(int j=0;j<tab[i].length;j++)
                System.out.println(tab[i][j]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    afficher(fichier.file_default.Emploi.toString());*/
    writefile(fichier.file_default.Emploi.toString());
    }


}
