package def.express.express_lib_router_index;
public interface NextFunction {
    public void apply(Object err);
    public void apply();
}

