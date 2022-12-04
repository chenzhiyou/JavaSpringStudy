package spring_aop_proxy.statically;

public class GamePlayer implements IGamePlayer{

    // 玩家名称
    private String name = "";

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("登录游戏");
        System.out.println(name+ "开始了游戏");
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name+ "被杀掉了");

    }
}
