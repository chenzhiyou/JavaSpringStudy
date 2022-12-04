package spring_aop_proxy.statically;

public class GameProxyPlayer implements IGamePlayer{

    private String name;
    private GamePlayer gamePlayer;


    public GameProxyPlayer(String name) {
        this.name = name;
        this.gamePlayer = new GamePlayer(name);
    }

    @Override
    public void start() {
        System.out.println("拿到了"+ name+"用户名+密码");
        gamePlayer.start();
    }

    @Override
    public void play() {
        System.out.println("代理击杀成功了，赢得了游戏");

    }
}
