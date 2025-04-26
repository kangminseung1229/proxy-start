package proxy.start.hello.aop.exam;


import org.springframework.stereotype.Repository;
import proxy.start.hello.aop.exam.annotation.Trace;

@Repository
public class ExamRepository {

    private static int seq = 0;

    /**
     * 5번에 한번 실패하는 요청
     * @param itemId
     * @return
     */
    @Trace
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("예외 발생");
        }
        return "ok";
    }
}
