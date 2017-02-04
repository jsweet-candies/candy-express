package def.express.express_lib_response;
import def.js.Date;
@jsweet.lang.Interface
public abstract class CookieOptions extends def.js.Object {
    @jsweet.lang.Optional
    public double maxAge;
    @jsweet.lang.Optional
    public Boolean signed;
    @jsweet.lang.Optional
    public Date expires;
    @jsweet.lang.Optional
    public Boolean httpOnly;
    @jsweet.lang.Optional
    public String path;
    @jsweet.lang.Optional
    public String domain;
    @jsweet.lang.Optional
    public Boolean secure;
}

