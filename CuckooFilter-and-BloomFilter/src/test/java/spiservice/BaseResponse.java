/**
 * 
 */
package spiservice;

import java.util.Arrays;

/**
 * @author xiaoy
 *
 */
public class BaseResponse<T> {
    private boolean success;
    private T data;
    private String message;

    public static BaseResponse<Void> success() {
        BaseResponse<Void> response = new BaseResponse<>();
        response.success = true;
        return response;
    }
    
    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response =new BaseResponse<>();
        response.data = data;
        response.success = true;
        return response;
    }
    //fail()
    //successWithMessage(String message)
    //successWtihMessage(T data,String message)
}


/*
 * class TestController<T> { public BaseResponse<Void> voidResponse() { return
 * BaseResponse.success(); }
 * 
 * public BaseResponse<?> successOrFailed(){ if(true){ return
 * BaseResponse.success(Arrays.asList("res1","res2")); }else { return
 * BaseResponse.fail(); } } }
 */