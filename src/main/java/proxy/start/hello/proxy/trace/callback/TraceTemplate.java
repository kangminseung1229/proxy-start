package proxy.start.hello.proxy.trace.callback;


import proxy.start.hello.proxy.trace.LogTrace;
import proxy.start.hello.proxy.trace.TraceStatus;

public class TraceTemplate {

    private final LogTrace trace;
    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);;
            throw e;
        }
    }
}
