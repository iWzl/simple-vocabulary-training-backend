package cc.itsc.project.vocabulary.training.backend.pojo.vo.common;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.DefaultHttpRsp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 消息的统一回复类,提供消息回复统一模板
 * 项目使用JSON,通过这种方式，构造通用的JSON返回包装类
 *
 * @author Leonardo iWzl
 */
@ApiModel(description = "通用JSON返回")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponseMessage<T extends HttpResponse> implements Serializable {
    private static final String SUCCESS = "SUCCESS";

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "返回状态")
    private Meta meta;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "返回携带的数据")
    private T data;

    /**
     * 隐藏构造器,规范化项目操作，通过内部的静态方法统一创建管理
     * @author Leo Wang
     */
    private ServiceResponseMessage(){
    }

    public static ServiceResponseMessage<DefaultHttpRsp> createBySuccessCodeMessage(){
        ServiceResponseMessage<DefaultHttpRsp> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(ResultCodeEnum.SUCCESS_NO_CONTENT.getCode(),SUCCESS);
        return serviceResponseMessage;
    }

    public static ServiceResponseMessage<DefaultHttpRsp> createBySuccessCodeMessage(String msg){
        ServiceResponseMessage<DefaultHttpRsp> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(ResultCodeEnum.SUCCESS_NO_CONTENT.getCode(),msg);
        return serviceResponseMessage;
    }

    public static <T extends HttpResponse> ServiceResponseMessage<T> createBySuccessCodeMessage(ResultCodeEnum resultCode, T data){
        ServiceResponseMessage<T> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(resultCode.getCode(),SUCCESS);
        serviceResponseMessage.data = data;
        return serviceResponseMessage;
    }

    public static  <T extends HttpResponse> ServiceResponseMessage<T>  createBySuccessCodeMessage(T data){
        ServiceResponseMessage<T> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(ResultCodeEnum.SUCCESS.getCode(),SUCCESS);
        serviceResponseMessage.data = data;
        return serviceResponseMessage;
    }


    public static  <T extends HttpResponse> ServiceResponseMessage<T> createBySuccessCodeMessage(String msg, T data){
        ServiceResponseMessage<T> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(ResultCodeEnum.SUCCESS.getCode(),msg);
        serviceResponseMessage.data = data;
        return serviceResponseMessage;
    }


    public static <T extends HttpResponse> ServiceResponseMessage<T> createByFailCodeMessage(String msg){
        ServiceResponseMessage<T> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(ResultCodeEnum.BAD_REQUEST.getCode(),msg);
        return serviceResponseMessage;
    }

    public static <T extends HttpResponse>ServiceResponseMessage<T> createByFailCodeMessage(ResultCodeEnum resultCode, String msg){
        ServiceResponseMessage<T> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(resultCode.getCode(),msg);
        return serviceResponseMessage;
    }


    public static <T extends HttpResponse> ServiceResponseMessage<T> createCommonMessage(ResultCodeEnum resultCode, String msg, T data){
        ServiceResponseMessage<T> serviceResponseMessage = new ServiceResponseMessage<>();
        serviceResponseMessage.meta = new Meta(resultCode.getCode(),msg);
        serviceResponseMessage.data = data;
        return serviceResponseMessage;
    }



    /**
     * 消息返回的元数据
     * 包含消息的返回码和提示信息
     *
     * @author Leonardo iWzl
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModel(description = "接口调用状态")
    private static class Meta{
        @JsonProperty
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @ApiModelProperty(notes = "返回状态码")
        private int code;
        @JsonProperty
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @ApiModelProperty(notes = "返回提示消息",example = "SUCCESS")
        private String msg;

        private Meta(int resultCode, String message) {
            this.code = resultCode;
            this.msg = message;
        }
    }
}
