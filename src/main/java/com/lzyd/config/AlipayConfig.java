package com.lzyd.config;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */


public class AlipayConfig {

    //支付宝商户appid
    public static String APPID = "2016102700769316";

    //用支付宝密钥生成工具生成的私钥
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCo0rtvTzr17Q4pcRERzok+aLTCqnU047o0TB1qaVw0PGoKXHjCUJhP8S/foDbAoFBbes52jzYhcUGTTlkfvm/Enl+xJ9DMl1shfZPJ4HxmvNJKtlLQHdttVGOihO0oj3kKGv6Ib6o0iBLNryTm8CpwtGa42dibbxh0sKfMtKFf1dp0O0HrkzUPQNlEjRWzw/av6/pmjIwlSrdGtINYt3Nv4GUvasJJh3MysK8RkGRCo3jfNHupvDexal/Mt23jbwOzNRVlpj+xUigWDMlTsTR7qOD5Io8ZXSDgrVPIZor31O64KJB0wVAK6KfoinwaLq9bIw8qpSKLX8QCuWb6RShzAgMBAAECggEBAJ2S4+PG/e9g7eD8acRHFI6tyFoSJAfTro71pFcYNDmFUiyNlyE3fJLROa/uqGwuthJMk7zReuLIBT7q2ADrDQNmF0cRNLBhbWva/EBnSXXTNC0L9EvQMmjfZYfhrkI3d/BYtc6++wzBHVvh5/2tmM9NcruCicy6awcvg89roVwCiR6i+eJe3sY7sOgNjtAB+euUhxuhoMzVCgoiCN/zyJch829zcIoGPSlk382u3NhxPgNcJ0chdFLR/F5gHG7ClDjMUgwDK8Bky6A0OyZHgVRgMfvvcsb/WZpTLuYL7EFX6ZrZ8CHltllCTj8wRnv6/iZkkkCAsnEF8M+afnDtKQECgYEA0uK64RQntGBs4qKyfQNBEBRgR1E8apR3RaZRac+3EhgcuIEWduwGUfzE5CloNdBDYZFRzeyctyjFiuFwuArBCz7NS/yeiIRurJUtqXhhSPmeDB71Y1Fx+Fwv4+hcXIRDusJcg4sL3g1bipwkj/p4/p1n8H7tQ6LX63vmSJxJSbMCgYEAzPBtMz5rX1ClPrmhpqLMO1Cl5ScSQeXGYgDCo/GGVVPv26XwUl+PaZ0ZbgnAdxGdz3PgcPD0xD0NU+Ad6TfxqfZdrjS8pz+zzDzDuS/MIlUuM7oawxxbFLk8NB2hy+V5tD7nUPADGiijSfjLlCtr9R6C9kWoToZl1rZWHFozxkECgYApP8YUDpAxnQbPUcmd4EwSrBmk+YPayQ2HZx/XlZSWinbbtAxD2Kjn0oxkoKDMnd8AL5+TquuAfA4fuzcEGL5nx7H6YgBUbasEQO28j1pgHstGTavr8FtdnBKV/rZKNmjVF/1mkYURuwUj2KTiMLkH/Jv/E6SvLSQU4JhLrZ48NwKBgGHf1RcrEVZ1CmYZe4U8rLMLQh9deI+2L/dwC4UGfTRVIPFSn6KHdtNmrtVpnNyAslB4M9FcklkCG1Jab46JJEYangTrtMlfV/wLbSINHL2s1qLnl45lBW6xRHpTSIk7L9OQUyLJbYHZtJpIUtmRnz5ycvMwsz/FWe+gJyHlRmLBAoGBAIDCx4B/45+hwx3m2sc4SkiuAZZXgglN5K9AnYqJvW1lXvBVDoPq6HM6KizUmK8Xb31gGL54kFHFcBRSytzFWRUPjP/qFwbwXbXU2SrtXHabpJvmlSea9jysRYgllCyQu37A+ot74NwY4dTqY47Ogs7LslMdURm+k6pa2IX9OIny";

    //电脑网站支付结果异步通知，可以参考异步文档，一定要是外网能访问的
    public static String notify_url = "www.baidu.com";

    //电脑网站支付结果同步通知，用于转跳到用户自己的页面，一定要是外网能访问的
    public static String return_url = "www.baidu.com";

    //沙箱接口，正式上线时请改用正式支付接口
    public static String URL = "https://openapi.alipaydev.com/gateway.do";

    //固定的参数
    public static String CHARSET = "UTF-8";

    //固定的参数
    public static String FORMAT = "json";

    //用支付宝密钥生成工具生成的公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqNK7b0869e0OKXEREc6JPmi0wqp1NOO6NEwdamlcNDxqClx4wlCYT/Ev36A2wKBQW3rOdo82IXFBk05ZH75vxJ5fsSfQzJdbIX2TyeB8ZrzSSrZS0B3bbVRjooTtKI95Chr+iG+qNIgSza8k5vAqcLRmuNnYm28YdLCnzLShX9XadDtB65M1D0DZRI0Vs8P2r+v6ZoyMJUq3RrSDWLdzb+BlL2rCSYdzMrCvEZBkQqN43zR7qbw3sWpfzLdt428DszUVZaY/sVIoFgzJU7E0e6jg+SKPGV0g4K1TyGaK99TuuCiQdMFQCuin6Ip8Gi6vWyMPKqUii1/EArlm+kUocwIDAQAB";

    //固定的参数
    public static String log_path = "/log";

    //固定的参数
    public static String SIGNTYPE = "RSA2";

    public AlipayConfig() {
    }
}
