package model;

public class Test {
    private int id;
    private String step1;
    private String step2;
    private String step3;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public String getStep1()
    {
        return step1;
    }

    public void setStep1(String step1)
    {
        this.step1 = step1;
    }
    public String getStep2()
    {
        return step2;
    }

    public void setStep2(String step2)
    {
        this.step2 = step2;
    }
    public String getStep3()
    {
        return step3;
    }

    public void setStep3(String step3)
    {
        this.step3 = step3;
    }


    @Override
    public String toString()
    {
        return "test:: ID=" + this.id +" s1 =" + this.step1+" s2 =" + this.step2+" s3 =" + this.step3 ;
    }
}
