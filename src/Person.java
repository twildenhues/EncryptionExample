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

    public String toString() {
        return name + " { \n " +
                "\t public:" + getPublicKey() +
                "\n \t private:" + privateKey +
                "\n } \n";
    }
}
