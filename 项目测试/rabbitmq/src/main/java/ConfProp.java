import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "lhf")
public class ConfProp {
    private String abc="";
}
