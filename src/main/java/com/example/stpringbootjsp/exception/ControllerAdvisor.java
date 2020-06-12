package com.example.stpringbootjsp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler  {
	// すべての例外をキャッチする
	// どこにもキャッチされなかったらこれが呼ばれる
    @ExceptionHandler(value = Exception.class)
    public String handleDemoExceptionForGlobal(Exception e) {
//        log.error(e.getMessage());
        return "error/error";
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException e) {
    	 return "error/error";
    }

//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public ResponseEntity<?> maxUploadSizeException(MaxUploadSizeExceededException e) {
//        return ResponseEntity.badRequest().body("ファイルサイズエラー");
//    }

    // すべての例外をキャッチする
    // どこにもキャッチされなかったらこれが呼ばれる
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
//        return super.handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }

//
//    @ExceptionHandler({
//        HttpRequestMethodNotSupportedException.class,
//        HttpMediaTypeNotSupportedException.class,
//        HttpMediaTypeNotAcceptableException.class,
//        MissingPathVariableException.class,
//        MissingServletRequestParameterException.class,
//        ServletRequestBindingException.class,
//        ConversionNotSupportedException.class,
//        TypeMismatchException.class,
//        HttpMessageNotReadableException.class,
//        HttpMessageNotWritableException.class,
//        MethodArgumentNotValidException.class,
//        MissingServletRequestPartException.class,
//        BindException.class,
//        NoHandlerFoundException.class,
//        AsyncRequestTimeoutException.class
//      })
//      @Nullable
//      public final ResponseEntity<Object> handleException2(Exception ex, WebRequest request) throws Exception {
//        // 각 예외에 대한 분기처리 로직(상속 구현 가능하도록 protected로 메서드가 선언되어 있음)
//      }

    // SpringBoot内で用意されている例外については、ResponseEntityExceptionHandlerクラスで例外ごとに
    // 専用のメソッドが用意されているのでそれをオーバーライドする
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return super.handleExceptionInternal(ex, "MethodArgumentNotValidException", null, HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
//
//    // すべてのハンドリングに共通する処理を挟みたい場合はオーバーライドする
//    // ex) ログを吐くなど
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//        // 任意の処理
//        return super.handleExceptionInternal(ex, body, headers, status, request);
//    }
}
