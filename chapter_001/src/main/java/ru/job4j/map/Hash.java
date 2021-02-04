package ru.job4j.map;

public class Hash {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String passport;
    private String comment;

    public Hash(String name, int age, String passport, String comment) {
        this.name = name;
        this.age = age;
        this.passport = passport;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }

        Hash user = (Hash) o;

        return user.name.equals(name) &&
                user.age == age &&
                user.passport.equals(passport);
    }


    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + passport.hashCode();
        System.out.println("HashCode = "+ result);
        return result;
    }
   /// переопределение метода должно обеспечить равенство хэшкода для одинаковых объектов
    // необходимо исключать при сравнении незначимые поля и которые не задействованы в методе equals
    //  при вычислении хэша - использовать нечетные простые числа
    //
    //
    public static void main(String [] args) {
        Hash user1 = new Hash("Nick",17,"123RSWQ 4567","user1");
        Hash user2 = new Hash("Nick",17,"123RSWQ 4567","user2");
       user1.hashCode();
        user2.hashCode();
    }
}
