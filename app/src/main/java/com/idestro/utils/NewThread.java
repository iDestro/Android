package com.idestro.utils;

/**
 * Created by idestro on 2018/11/27.
 */

public class NewThread extends Thread {
    private String result;
    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
