package spring_aop.proxy.statically;
import org.junit.jupiter.api.Test;


public class MainTest {

    @Test
    public void test(){
        IGamePlayer gamePlayer = new GameProxyPlayer("小花");
        gamePlayer.start();
        gamePlayer.play();
    }
}
