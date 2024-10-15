
package Mernis;
//------------------------------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 9.0.1.0
//
// Created by Quasar Development 
//
// This class has been generated for test purposes only and cannot be used in any commercial project.
// To use it in commercial project, you need to generate this class again with Premium account.
// Check https://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
//
// Licence: F6DE6F68E7C2E9D469FD6E42E47BEE156C89DDB15949D72EAE7B3CE29072B54F8D795DCA91EF4B633C7A3C5B1472C7002BC560A3F2A00E698EBD7262800355C1
//------------------------------------------------------------------------

import java.util.*;


public class NAUKPSPublicSoap12
{
    private String url = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
    private HashMap< String,String> httpHeaders = new HashMap< String,String>();
    private boolean enableLogging = false;
    private String userName=null;
    private String password=null;
    private NAUConnectionProvider connectionProvider=new NAUHttpConnectionProvider();

    public NAUKPSPublicSoap12()
    {
    }

    public NAUKPSPublicSoap12(String url)
    {
        this.url=url;
    }

    public NAUKPSPublicSoap12 (String url,NAUConnectionProvider connectionProvider) {
        this.url=url;
        this.connectionProvider=connectionProvider;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getHttpHeaders() {
        return httpHeaders;
    }

    public boolean isLoggingEnabled() {
        return enableLogging;
    }

    public void setLoggingEnabled(boolean enableLogging) {
        this.enableLogging = enableLogging;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
    protected NAURequestResultHandler createRequestResultHandler()
    {
        NAURequestResultHandler handler = new NAURequestResultHandler(NAUSoapVersion.v1_2);
        return handler;
    }
    
    private org.w3c.dom.Document createTCKimlikNoDogrulaRequest(final Long TCKimlikNo,final String Ad,final String Soyad,final Integer DogumYili,NAURequestResultHandler __handler) throws java.lang.Exception
    {
        org.w3c.dom.Document __xml=__handler.createEnvelopeXml();
        org.w3c.dom.Element __mainNode=__handler.writeElement("http://tckimlik.nvi.gov.tr/WS","TCKimlikNoDogrula",__xml);
        __handler.getBody().appendChild(__mainNode);

        org.w3c.dom.Element __TCKimlikNoItemElement=__handler.writeElementWithType(TCKimlikNo,Long.class, "TCKimlikNo", "http://tckimlik.nvi.gov.tr/WS", __mainNode, false);
        if(__TCKimlikNoItemElement != null)
        {
            __TCKimlikNoItemElement.setTextContent(TCKimlikNo.toString());
        }

        org.w3c.dom.Element __AdItemElement=__handler.writeElementWithType(Ad,String.class, "Ad", "http://tckimlik.nvi.gov.tr/WS", __mainNode, true);
        if(__AdItemElement != null)
        {
            __AdItemElement.setTextContent(Ad.toString());
        }

        org.w3c.dom.Element __SoyadItemElement=__handler.writeElementWithType(Soyad,String.class, "Soyad", "http://tckimlik.nvi.gov.tr/WS", __mainNode, true);
        if(__SoyadItemElement != null)
        {
            __SoyadItemElement.setTextContent(Soyad.toString());
        }

        org.w3c.dom.Element __DogumYiliItemElement=__handler.writeElementWithType(DogumYili,Integer.class, "DogumYili", "http://tckimlik.nvi.gov.tr/WS", __mainNode, false);
        if(__DogumYiliItemElement != null)
        {
            __DogumYiliItemElement.setTextContent(DogumYili.toString());
        }
        __handler.finishEnvelopeXml(__xml);
        return __xml;
    }
    
    public Boolean TCKimlikNoDogrula(final Long TCKimlikNo,final String Ad,final String Soyad,final Integer DogumYili) throws java.lang.Exception
    {
        NAURequestResultHandler __handler =createRequestResultHandler();
        org.w3c.dom.Document __xml=createTCKimlikNoDogrulaRequest(TCKimlikNo, Ad, Soyad, DogumYili, __handler);
        sendRequest("http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula",__xml,__handler);
        org.w3c.dom.Node __result=NAUHelper.getResult(__handler.getOutputBody(), "TCKimlikNoDogrulaResult",false);
        if(__result!=null)
        {
            return NAUHelper.toBoolFromString(((org.w3c.dom.Element)__result).getTextContent());
        }
        return null;
    }
    protected void sendRequest(String soapAction,org.w3c.dom.Document soapBody, NAURequestResultHandler handler) throws java.lang.Exception
    {
        HashMap< String,String> __headers = new HashMap<>();
        __headers.putAll(httpHeaders);
        __headers.put("SOAPAction",soapAction);
        __headers.put("user-agent","easyWSDL Generator 9.0.1.0");
        __headers.put("content-type","application/soap+xml; charset=utf-8");
        if (userName != null)
        {
            String authStr = userName+":"+password;
            String data=Base64.getEncoder().encodeToString(authStr.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            String authValue = "Basic "+data;
            __headers.put("authorization",authValue);
        }
        String __requestBody=NAUHelper.getStringFromDocument(soapBody);
        if(enableLogging)
        {
            System.out.println("requestDump: "+__requestBody);
        }
        NAUResponseData response=connectionProvider.sendRequest(url,__requestBody, __headers,handler);
        if(enableLogging)
        {
             System.out.println("responseDump: "+response.getBody());
        }
        handler.setResponse(response);
    }
}