package as;

/**
 * @author zzzz
 * @create 2019-08-15 上午10:45
 */
public class User {
    private Integer id;
    private String name;
    private String object;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "as.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", object='" + object + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
