package com.lzyd.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.lzyd.config.AlipayConfig;
import com.lzyd.pay.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {
    @Override
    public String toAlipay(Map<String, String> sourceMap) throws IOException {
        AlipayClient              alipayClient  = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,AlipayConfig.FORMAT,AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        AlipayTradeWapPayModel alipayTradeWapPayModel = new AlipayTradeWapPayModel();
        alipayTradeWapPayModel.setOutTradeNo(sourceMap.get("out_trade_no"));
        alipayTradeWapPayModel.setProductCode("FAST_INSTANT_TRADE_PAY");
        alipayTradeWapPayModel.setTotalAmount(sourceMap.get("total_amount"));
        alipayTradeWapPayModel.setSubject("Alipay");
        alipayTradeWapPayModel.setBody(sourceMap.get("body"));
        alipayRequest.setBizModel(alipayTradeWapPayModel);
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }


}
