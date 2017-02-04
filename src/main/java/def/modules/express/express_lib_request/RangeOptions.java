package def.modules.express.express_lib_request;
@jsweet.lang.Interface
public abstract class RangeOptions extends def.js.Object {
    /**
         * Specifies if overlapping & adjacent ranges should be combined, defaults to `false`.
         * When `true`, ranges will be combined and returned as if they were specified that
         * way in the header.
         *
         * ```js
         * parseRange(100, 'bytes=50-55,0-10,5-10,56-60', { combine: true })
         * // => [
         * //      { start: 0,  end: 10 },
         * //      { start: 50, end: 60 }
         * //    ]
         * ```
         */
    @jsweet.lang.Optional
    public Boolean combined;
}

