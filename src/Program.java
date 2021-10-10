public class Program {

    public static void main (String[] args) {
        Group group = new Group(23);

        Person person1 = new Person(group, "dieter");
        Person person2 = new Person(group, "detlef");
        Person person3 = new Person(group, "jörg");

        int randomNumber = (int) (Math.random() * 1000);
        System.out.println("number: " + randomNumber);


        int encryptedNumber = person1.encryptInteger(randomNumber, person2.getPublicKey());
        System.out.println("encrypted: " + encryptedNumber);

        int decryptedNumber = person2.decryptInteger(encryptedNumber, person1.getPublicKey());
        System.out.println("decrypted: " + decryptedNumber);

        int decryptIntegerUnauthorized = person3.decryptInteger(encryptedNumber, person1.getPublicKey());
        System.out.println("decryptedAttack: " + decryptIntegerUnauthorized);

    }
}
