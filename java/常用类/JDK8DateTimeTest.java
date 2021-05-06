import org.junit.Test;

import java.time.*;

public class JDK8DateTimeTest {
    
    public static final  JDK8DateTimeTest G=new JDK8DateTimeTest();
    @Test
    public void test(){
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime.getDayOfYear());
    }

    @Test
    public void test1(){
        Instant now = Instant.now();
        Instant epoch = Instant.EPOCH;
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        long l = now.toEpochMilli();

        Instant.ofEpochMilli(l);
    }
}

class AA{
    public static void main(String[] args) {
        JDK8DateTimeTest g = JDK8DateTimeTest.G;
    }
}
