package xyz.nesting.example.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by joe on 25/12/17.
 */
@ControllerAdvice
public class BizExcepiton {

    //private static final Logger logger =  LoggerFactory.getLogger(BizExcepiton.class);

//    /**
//     * 统一异常处理
//     *
//     * @param exception
//     *            exception
//     * @return
//     */
//    @ExceptionHandler({ RuntimeException.class })
//    @ResponseBody
//    public ModelAndView processException(RuntimeException exception) {
//        logger.info("自定义异常处理-RuntimeException");
//        ModelAndView m = new ModelAndView();
//        m.addObject("roncooException", exception.getMessage());
//        m.setViewName("error/500");
//        return m;
//    }

    /**
     * 统一异常处理
     *
     * @param exception
     *            exception
     * @return
     */
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public ErrorInfo processException(Exception exception) {
        ErrorInfo r = new ErrorInfo();
        r.setMessage(exception.getMessage());
        r.setCode(100);
        r.setData("Some Data");
        r.setUrl("url");
        return r;
    }

    public class ErrorInfo {

//        public static final Integer OK = 0;
//        public static final Integer ERROR = 100;

        private Integer code;
        private String message;
        private String url;
        private String data;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
        // 省略getter和setter

    }

}
