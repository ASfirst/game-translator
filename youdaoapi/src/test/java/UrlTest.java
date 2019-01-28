import com.jeramtough.jtlog.facade.L;
import okhttp3.HttpUrl;
import org.junit.Test;

/**
 * Created on 2019-01-28 00:20
 * by @author JeramTough
 */
public class UrlTest {

    @Test
    public void test() {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("openapi.pojo.com")
                .addPathSegment("ocrtransapi")
                .addEncodedQueryParameter("q", "卧槽")
                .build();
        L.debug(httpUrl.toString());
    }
}
