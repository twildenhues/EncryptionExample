import java.util.Random;

public class Program {

    public static void main (String[] args) {
        Group group = new Group(727);

        Person person1 = new Person(group, "dieter");
        Person person2 = new Person(group, "detlef");
        Person person3 = new Person(group, "jörg");

        String string = "test123";
        if(args.length > 0) {
            string = args[0];
        }

        System.out.println("string: " + string);

        String encryptString = person1.encryptString(string, person2.getPublicKey());
        System.out.println("encrypted: " + encryptString);

        String decryptString = person2.decryptString(encryptString, person1.getPublicKey());
        System.out.println("decrypted: " + decryptString);

        String decryptStringUnauthorized = person3.decryptString(encryptString, person1.getPublicKey());
        System.out.println("decryptedUnauthorized: " + decryptStringUnauthorized);
    }
}
