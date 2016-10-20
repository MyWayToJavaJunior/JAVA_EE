package ru.sstu;

/**
 * Created by Shvarts on 17.10.2016.
 */
public class Person {

    public DrivingLicense getLicense() {
        return license;
    }

    public void setLicense(DrivingLicense license) {
        this.license = license;
    }

    enum DrivingLicense
    {
        A,
        B,
        C,
        D,
        NO
    }

    private int gender = 0;
    private Gender enumGender = Gender.MALE;
    private DrivingLicense license = DrivingLicense.NO;

    public Head getHead() {
        return head;
    }

    private Head head = new Head(this);



    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int UNDEFINED = 2;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        if(gender >= 0 && gender <= 2)
            this.gender = gender;
    }

    public Gender getEnumGender() {
        return enumGender;
    }

    public void setEnumGender(Gender enumGender) {
        this.enumGender = enumGender;
    }


    public void talk()
    {
        head.talk();
        //System.out.println("Разговор");
    }

    public class Head
    {

        public final static int eyesCount = 2;
        public Head(Person p)
        {
            pers = p;
        }
        public Person getPers() {
            return pers;
        }

        public void setPers(Person pers) {
            this.pers = pers;
        }

        private Person pers;
        public double radius = 20;
        public void talk()
        {
            //System.out.println("Разговор человека с правами категории " + pers.getLicense());
            System.out.println("Разговор человека с правами категории " + pers.license);
        }
    }
}
