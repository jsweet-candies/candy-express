package def.express.express_path_to_regexp;
/** This class holds all the global functions and variables of the ~express~path_to_regexp package. */
public final class Globals {
    private Globals(){}
    /**
   * Parse an Express-style path into an array of tokens.
   */
    native public static jsweet.util.union.Union<String,Key>[] parse(String path);
    /**
   * Transforming an Express-style path into a valid path.
   */
    native public static java.util.function.BiFunction<Object,PathFunctionOptions,String> compile(String path);
    /**
   * Transform an array of tokens into a path generator function.
   */
    native public static java.util.function.BiFunction<Object,PathFunctionOptions,String> tokensToFunction(String[] tokens);
    /**
   * Transform an array of tokens into a matching regular expression.
   */
    native public static PathRegExp tokensToRegExp(String[] tokens, Options options);
    /**
   * Transform an array of tokens into a matching regular expression.
   */
    native public static PathRegExp tokensToRegExp(String[] tokens);
    /**
   * Transform an array of tokens into a path generator function.
   */
    native public static java.util.function.BiFunction<Object,PathFunctionOptions,String> tokensToFunction(Key[] tokens);
    /**
   * Transform an array of tokens into a matching regular expression.
   */
    native public static PathRegExp tokensToRegExp(Key[] tokens, Options options);
    /**
   * Transform an array of tokens into a matching regular expression.
   */
    native public static PathRegExp tokensToRegExp(Key[] tokens);
}

