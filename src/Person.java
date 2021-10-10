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

        int[] encryptedChars = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            encryptedChars[i] = (int) text.charAt(i) * key;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int val : encryptedChars) {
            stringBuilder.append(Character.toString(val));
        }
        return stringBuilder.toString();
    }

    public String decryptString(String text, int publicKey) {
        int key = group.pow(publicKey, privateKey);

        int[] decryptedChars = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            decryptedChars[i] = (int) text.charAt(i) / key;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int val : decryptedChars) {
            stringBuilder.append(Character.toString(val));
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return name + " { \n " +
                "\t public:" + getPublicKey() +
                "\n \t private:" + privateKey +
                "\n } \n";
    }
}
