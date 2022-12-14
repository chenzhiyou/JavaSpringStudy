package beans;

public class User {
    private Integer id;
    private String userName;
    private String realName;

    public User() {
        System.out.println("User已加载");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    /**
     * 基于setter方法的依赖注入，对应的set方法的名字
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public User(Integer id, String userName, String realName) {
        this.id = id;
        this.userName = userName;
        this.realName = realName;
    }
}
