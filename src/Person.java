import java.nio.charset.StandardCharsets;

public class Person {

    private int privateKey;
    private Group group;
    private String name;

    public Person(Group group, String name) {
        this.group = group;
        this.name = name;

        setPrivateKey();

        System.out.println(this);
    }

    public int getPublicKey() {
        return group.generatePublicKey(privateKey);
    }

    public void setPrivateKey() {
        this.privateKey = generateRandomKey();
    }

    private int generateRandomKey() {
        return (int) (Math.random() * group.getSize());
    }

    public int encryptInteger(int number, int publicKey) {
        return number * group.pow(publicKey, privateKey);
    }
    public int decryptInteger(int number, int publicKey) {
        return number / group.pow(publicKey, privateKey);
    }

    public String encryptString(String text, int publicKey) {
        int key = group.pow(publicKey, privateKey);

        char[] chars = text.toCharArray();
        char[] encryptedChars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            encryptedChars[i] = (char) ((chars[i] * key));
        }
        return new String(encryptedChars);
    }

    public String decryptString(String text, int publicKey) {
        int key = group.pow(publicKey, privateKey);

        char[] chars = text.toCharArray();
        char[] decryptedChars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            int value = (chars[i] / key);
            decryptedChars[i] = (char) (value);
        }
        return new String(decryptedChars);
    }

    public String toString() {
        return name + " { \n " +
                "\t public:" + getPublicKey() +
                "\n \t private:" + privateKey +
                "\n } \n";
    }
}
