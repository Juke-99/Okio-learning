package buffer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import okio.Buffer;

public class WriteSamplesTest {
    Buffer buffer = new Buffer();
    
    @Test
    public void readText() {
        buffer.writeUtf8("loaclhost");
        assertThat("loaclhost").isEqualTo(buffer.readUtf8());
        buffer.writeUtf8("Hello!!", 0, 6);
        assertThat("Hello!").isEqualTo(buffer.readUtf8());
        buffer.writeUtf8("SRE at Google.", 3, 5);
        assertThat(" a").isEqualTo(buffer.readUtf8());
        
        buffer.writeUtf8("Hello");
        buffer.writeUtf8(", eric", 0, 2);
        buffer.writeUtf8("Network.");
        assertThat("Hello, Network.").isEqualTo(buffer.readUtf8());
    }
}
