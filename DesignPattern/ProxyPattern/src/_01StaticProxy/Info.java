package _01StaticProxy;

/*
* 这里定义的信息实体类,主要功能是为了测试代理类和目标类功能
* */
public class Info  {

    public Info(String name, String ID, String tel) {
        Name = name;
        this.ID = ID;
        Tel = tel;
    }

    private String Name;
    private String ID;
    private String Tel;


    public String getName() {
        return Name;
    }


    public String getID() {
        return ID;
    }



    public String getTel() {
        return Tel;
    }



}
