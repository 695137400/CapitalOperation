package com.capital.operation;

/**
 * <P style='margin: 0px; padding: 0px;'><b>PackageName:</b> com.capital.operation.</P>
 * <P style='margin: 0px; padding: 0px;'><b>ProjectName:</b> CapitalOperation.</P>
 * <P style='margin: 0px; padding: 0px;'><b>User:</b> 李志超.</P>
 * <P style='margin: 0px; padding: 0px;'><b>Date:</b> 2017-3-16 0016.</P>
 * <P style='margin: 0px; padding: 0px;'><b>Time:</b> 20:21:17</P>
 */
public class LogMessage {
    private boolean results = false;
    private String message = null;

    public boolean isResults() {
        return results;
    }

    public void setResults(boolean results) {
        this.results = results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
