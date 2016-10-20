package com.codingcrew.campusconnection.webservices;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 10/18/2016 11:32:37 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

import android.os.AsyncTask;

import com.codingcrew.campusconnection.webservices.WS_Enums.*;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

public class Login {
    
    public String NAMESPACE ="http://tempuri.org/";
    public String url= "http://129.118.70.18/cc_ws/Login.svc";
    public int timeOut = 180;
    public IWsdl2CodeEvents eventHandler;
    public SoapProtocolVersion soapVersion;
    
    public Login(){}
    
    public Login(IWsdl2CodeEvents eventHandler)
    {
        this.eventHandler = eventHandler;
    }
    public Login(IWsdl2CodeEvents eventHandler,String url)
    {
        this.eventHandler = eventHandler;
        this.url = url;
    }
    public Login(IWsdl2CodeEvents eventHandler,String url,int timeOutInSeconds)
    {
        this.eventHandler = eventHandler;
        this.url = url;
        this.setTimeOut(timeOutInSeconds);
    }
    public void setTimeOut(int seconds){
        this.timeOut = seconds * 1000;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void DoWorkAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        DoWorkAsync(null);
    }
    
    public void DoWorkAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                DoWork(headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("DoWork", result);
                }
            }
        }.execute();
    }
    
    public void DoWork(){
        DoWork(null);
    }
    
    public void DoWork(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/","DoWork");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://tempuri.org/ILogin/DoWork", soapEnvelope,headers);
            }else{
                httpTransport.call("http://tempuri.org/ILogin/DoWork", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void DoLoginAsync(String email,String password) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        DoLoginAsync(email, password, null);
    }
    
    public void DoLoginAsync(final String email,final String password,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Account>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Account doInBackground(Void... params) {
                return DoLogin(email, password, headers);
            }
            @Override
            protected void onPostExecute(Account result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("DoLogin", result);
                }
            }
        }.execute();
    }
    
    public Account DoLogin(String email,String password){
        return DoLogin(email, password, null);
    }
    
    public Account DoLogin(String email,String password,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://tempuri.org/","DoLogin");
        soapReq.addProperty("email",email);
        soapReq.addProperty("password",password);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://tempuri.org/ILogin/DoLogin", soapEnvelope,headers);
            }else{
                httpTransport.call("http://tempuri.org/ILogin/DoLogin", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);

                    if (obj == null)
                        return null;

                    SoapObject j = (SoapObject)obj;
                    Account resultVariable =  new Account (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
}
